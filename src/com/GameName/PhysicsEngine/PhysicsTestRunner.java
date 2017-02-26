package com.GameName.PhysicsEngine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ListIterator;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Matrix4f;

import com.GameName.PhysicsEngine.Bodies.MovingBody;
import com.GameName.PhysicsEngine.Bodies.Raycast;
import com.GameName.PhysicsEngine.Bodies.StaticBody;
import com.GameName.PhysicsEngine.Detection.Triangle;
import com.GameName.PhysicsEngine.Detection.Colliders.AABB;
import com.GameName.PhysicsEngine.Detection.Colliders.CollisionEllipse;
import com.GameName.PhysicsEngine.Detection.Colliders.CollisionMesh;
import com.GameName.PhysicsEngine.Detection.Colliders.CollisionMeshLoader;
import com.GameName.PhysicsEngine.Detection.Colliders.CollisionSphere;
import com.GameName.PhysicsEngine.Render.PhysicsRenderProperties;
import com.GameName.PhysicsEngine.Render.PhysicsRenderer;
import com.GameName.PhysicsEngine.Render.PhysicsShader;
import com.GameName.PhysicsEngine.Render.Octree.OctreeRender;
import com.GameName.PhysicsEngine.Render.Octree.PhysicsCubeRender;
import com.GameName.PhysicsEngine.Render.Octree.PhysicsPlaneRender;
import com.GameName.PhysicsEngine.Render.Sphere.SphereRender;
import com.GameName.RenderEngine.RenderEngine;
import com.GameName.RenderEngine.Models.Model;
import com.GameName.RenderEngine.Models.ModelLoader;
import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.RenderEngine.Util.Camera;
import com.GameName.RenderEngine.Util.Color;
import com.GameName.RenderEngine.Util.Color.ColorFormat;
import com.GameName.RenderEngine.Util.RenderStructs.Transform;
import com.GameName.RenderEngine.Window.Window;
import com.GameName.Util.Vectors.Vector3f;

public class PhysicsTestRunner {
	private static Window window;
	private static Camera camera;

	private static RenderEngine renderEngine;
	private static PhysicsEngine physicsEngine;
	
	private static PhysicsShader physicsShader;
	
	private static MovingBody ellipseBody;
	private static StaticBody staticBody;
	
	private static SphereRender sphere, sphereCenter, unitSphere;
	private static Model cube, meshClone;
	private static OctreeRender octreeRender;
	
	private static Transform sphereTransform;
	private static Transform cubeTransform;
	
	private static float speed, sphereSpeed, rotationShereSpeed;
	private static Vector3f target;
	
	private static float[] meshData;
	
	private static ArrayList<Raycast> raycasts, raycastRenders;
	private static float rayI, rayJ;
	private static long startTime;
	
	private static ArrayList<PhysicsPlaneRender> collidedPlane;
	private static ArrayList<PhysicsCubeRender> collidedAABB;
	
//	private static Raycast raycast;
//	private static boolean rayRemoved;
	
	public static void main(String[] args) throws IOException, LWJGLException {
		window = new Window();
		window.setFPS(1200000);
		window.initDisplay(600,600);
		
		init();
		
		double frameTimeAvg = 0.0;
		int frameAvgCounter = 0;
		
		camera.x = 2.5f;
		camera.z = 7;
		
		target = new Vector3f();
		while(!window.isCloseRequested()) {
			
			handleInput();
			render();
						
			physicsEngine.simulate(1.0f);
			renderEngine.render(camera);
			window.update();
			
			if(frameAvgCounter >= 50) {
				frameTimeAvg /= (double) frameAvgCounter;
				window.setTitle("Physics Testing | FPS: " + (int)(1.0/frameTimeAvg) + "\t FrameTime: " + (float)frameTimeAvg);
				
				frameTimeAvg = 0.0;
				frameAvgCounter = 0;
			} else {
				frameTimeAvg += window.getFrameTime();
				frameAvgCounter ++;
			}			
		}
		
		sphere.cleanUp();
		cube.cleanUp();
		
		physicsShader.cleanUp();
		
		window.destroy();
	}
	
	private static void init() {
		// Create Engine & Components
		physicsEngine = new PhysicsEngine();
		renderEngine = new RenderEngine();

		camera = new Camera(70, (float) window.getWidth() / (float) window.getHeight(), 0.3f, 1000);
		
		// Create Shaders 
		physicsShader = new PhysicsShader();
		PhysicsRenderer physicsRenderer = (PhysicsRenderer) physicsShader.getRenderer();
		renderEngine.addRenderer(physicsRenderer);
		
		// Create Collision Frames
		CollisionEllipse collisionEllipse = new CollisionEllipse(new Vector3f(2, 4, .75)); //Vector3f.random(2).add(0.5f));//
		CollisionMesh collisionMesh = CollisionMeshLoader.loadObj("res/models/cylinder.obj");//DefaultCube //cylinder 

		// Create Object Transforms
		sphereTransform = new Transform();
		cubeTransform = new Transform();
		
		// Transform transforms
		cubeTransform.translate(new Vector3f(5, 0, 0));
//		cubeTransform.rotate(new Vector3f(30834.768, 16627.076, 27693.992));

		// Create Renders
		sphere = new SphereRender(collisionEllipse, 30); // 		    collisionEllipse.getRadius().max()
		unitSphere = new SphereRender(new CollisionEllipse(new Vector3f(1)), 30); // 0.99999f
		sphereCenter = new SphereRender(new CollisionEllipse(new Vector3f(0.01f)), 3);

		cube = new Model(ModelLoader.loadOBJ("res/models/cylinder.obj"));
		meshClone = new Model(ModelLoader.loadOBJ("res/models/cylinder.obj"));
		octreeRender = new OctreeRender(collisionMesh.getOctree());
		
		meshData = ModelLoader.verti;

		// Attach Shaders
		sphere.setShader(physicsShader);
		unitSphere.setShader(physicsShader);
		sphereCenter.setShader(physicsShader);
		
		cube.setShader(physicsShader);
		octreeRender.setShader(physicsShader);
		meshClone.setShader(physicsShader);

		// Create Collision Bodies
		ellipseBody = new MovingBody(collisionEllipse);
		staticBody = new StaticBody(collisionMesh);
		
		physicsEngine.add(staticBody);
//		physicsEngine.add(ellipseBody);
		
		staticBody.setPosition(cubeTransform.getTranslation());
		staticBody.setRotation(cubeTransform.getRotation());
		
		raycasts = new ArrayList<>();
		raycastRenders = new ArrayList<>();
		
		raycasts.add(new Raycast(new Vector3f(8.537911, -2.570443, 2.424048), staticBody.getPosition()));
		physicsEngine.add(raycasts.get(raycasts.size() - 1));
		
		startTime = -1;
		
		collidedAABB = new ArrayList<>(); 
		collidedPlane = new ArrayList<>();
	}
	
	private static boolean R_SHIFT = false, R_SHIFT_TOGGLE = false;
	private static boolean R_CTRL = false, R_CTRL_TOGGLE = false;
	private static boolean F = false, F_TOGGLE = false;
	
	private static void handleInput() {
		// Toggle States
		if(Keyboard.isKeyDown(Keyboard.KEY_RCONTROL) && !R_CTRL_TOGGLE) {
			R_CTRL_TOGGLE = true;
			R_CTRL = !R_CTRL;
		} else if(!Keyboard.isKeyDown(Keyboard.KEY_RCONTROL))
			R_CTRL_TOGGLE = false;
		
		if(Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) && !R_SHIFT_TOGGLE) {
			R_SHIFT_TOGGLE = true;
			R_SHIFT = !R_SHIFT;
		} else if(!Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
			R_SHIFT_TOGGLE = false;
		
		if(Keyboard.isKeyDown(Keyboard.KEY_F) && !F_TOGGLE) {
			F_TOGGLE = true;
			F = !F;
		} else if(!Keyboard.isKeyDown(Keyboard.KEY_F))
			F_TOGGLE = false;
		
		// Sphere Movement
		sphereSpeed = (float) ((Keyboard.isKeyDown(Keyboard.KEY_O) ? 2 : (Keyboard.isKeyDown(Keyboard.KEY_U) ? 0.25f : 1)) * window.getFrameTime());
		
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD7)) ellipseBody.addVelocity(new Vector3f(0,  sphereSpeed, 0)); 
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD1)) ellipseBody.addVelocity(new Vector3f(0, -sphereSpeed, 0));
		
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD4)) ellipseBody.addVelocity(new Vector3f(-sphereSpeed, 0, 0)); 
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD6)) ellipseBody.addVelocity(new Vector3f( sphereSpeed, 0, 0)); 
                                                                                         
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD5)) ellipseBody.addVelocity(new Vector3f(0, 0,  sphereSpeed)); 
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD8)) ellipseBody.addVelocity(new Vector3f(0, 0, -sphereSpeed)); 
		
		// Sphere Rotation
		rotationShereSpeed = (float) ((Keyboard.isKeyDown(Keyboard.KEY_O) ? 60 : (Keyboard.isKeyDown(Keyboard.KEY_O) ? 15 : 30)) * window.getFrameTime());
		
		if(Keyboard.isKeyDown(Keyboard.KEY_Y)) ellipseBody.addRotation(new Vector3f(0,  rotationShereSpeed, 0)); 
		if(Keyboard.isKeyDown(Keyboard.KEY_H)) ellipseBody.addRotation(new Vector3f(0, -rotationShereSpeed, 0));
		
		if(Keyboard.isKeyDown(Keyboard.KEY_I)) ellipseBody.addRotation(new Vector3f(-rotationShereSpeed, 0, 0)); 
		if(Keyboard.isKeyDown(Keyboard.KEY_K)) ellipseBody.addRotation(new Vector3f( rotationShereSpeed, 0, 0)); 
                                                                                         
		if(Keyboard.isKeyDown(Keyboard.KEY_J)) ellipseBody.addRotation(new Vector3f(0, 0,  rotationShereSpeed)); 
		if(Keyboard.isKeyDown(Keyboard.KEY_L)) ellipseBody.addRotation(new Vector3f(0, 0, -rotationShereSpeed)); 
		
		// Camera Movement
		speed = (float) ((Keyboard.isKeyDown(Keyboard.KEY_SPACE) ? 24 : (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) ? 1 : 6)) * window.getFrameTime());
		
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) camera.moveForward(speed);
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) camera.moveForward(-speed);
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) camera.moveRight(speed);
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) camera.moveRight(-speed);
		if(Keyboard.isKeyDown(Keyboard.KEY_Q)) camera.moveUp(speed);
		if(Keyboard.isKeyDown(Keyboard.KEY_Z)) camera.moveUp(-speed);

		if(Keyboard.isKeyDown(Keyboard.KEY_UP)) camera.rotX -= (speed*8);
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)) camera.rotX -= (-speed*8);
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) camera.rotY -= (speed*8);
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) camera.rotY -= (-speed*8);

		// Reset Buttons
		if(Keyboard.isKeyDown(Keyboard.KEY_R))  {
			camera.x = 2.5f;
			camera.y = 0;
			camera.z = 7;
			
			camera.rotX = 0;
			camera.rotY = 0;
			camera.rotZ = 0;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD0))  {
			ellipseBody.setPosition(new Vector3f());
			ellipseBody.setRotation(new Vector3f());
		}
		
		// Cube Rotation
		if(cubeTransform.getRotation().x % 360 < target.x)
			cubeTransform.setRotation(cubeTransform.getRotation().add(new Vector3f(90/2, 0, 0).multiply((float) window.getFrameTime())));
		else target.x = 0;//(float) (Math.random() * 360);
		
		if(cubeTransform.getRotation().y % 360 < target.y)
			cubeTransform.setRotation(cubeTransform.getRotation().add(new Vector3f(0,49/2, 0).multiply((float) window.getFrameTime())));
		else target.y = 0;//(float) (Math.random() * 360);
		
		if(cubeTransform.getRotation().z % 360 < target.z)
			cubeTransform.setRotation(cubeTransform.getRotation().add(new Vector3f(0, 0, 81/2).multiply((float) window.getFrameTime())));
		else target.z = 0;//(float) (Math.random() * 360);
			
		if(Keyboard.isKeyDown(Keyboard.KEY_C)) cubeTransform.setRotation(cubeTransform.getRotation().multiply(0, 1, 1));
		if(Keyboard.isKeyDown(Keyboard.KEY_V)) cubeTransform.setRotation(cubeTransform.getRotation().multiply(1, 0, 1));
		if(Keyboard.isKeyDown(Keyboard.KEY_B)) cubeTransform.setRotation(cubeTransform.getRotation().multiply(1, 1, 0));
		
		staticBody.setRotation(cubeTransform.getRotation());
		
//		if(Keyboard.isKeyDown(Keyboard.KEY_EQUALS)) {
//			if(raycast != null) physicsEngine.remove(raycast);
//			
//			raycast = new Raycast(camera.getPosition(), camera.getPosition().add(
//					new Vector3f(0, 0, -10).invertRotate(camera.getRotation().add(0, 0, 0))));
//			physicsEngine.add(raycast);
//			rayRemoved = false;
//		}
//		
//		if(!rayRemoved && raycast != null && (raycast.getIntersection() != null || raycast.getStartPosition().distance(raycast.getPosition()) > 10)) {
//			physicsEngine.remove(raycast);
//			System.out.println("Removed: " + raycast.getIntersection());
//			rayRemoved = true;
//		}
		
		ListIterator<Raycast> list = raycasts.listIterator();
		while(list.hasNext()) {
			if(startTime == -1)
				startTime = System.currentTimeMillis();
			Raycast ray = list.next();
			
			if(ray.getIntersection() != null || ray.getStartPosition().distance(ray.getPosition()) > 10) {
				physicsEngine.remove(ray);
				if(ray.getIntersection() == null) {
//					raycastRenders.clear();
					raycastRenders.add(ray);
				}
				
				list.remove();
//				list.add(new Raycast(ray.getStartPosition(), ray.getEndPosition()));
				
				rayJ ++;
//				System.out.println(rayJ);
				
				if(rayI > 180) {
					System.out.println("Done");
					long change = System.currentTimeMillis() - startTime;
					System.out.println(change / 1000.0);
					System.out.println(raycastRenders.size() > 0);
					
					break;
				}
				
				if(rayJ > 360) {
					rayI ++;
					rayJ = 0;
				}
				
				float sin_s = (float) Math.sin(Math.toRadians(rayI));
				float sin_t = (float) Math.sin(Math.toRadians(rayJ));
				float cos_s = (float) Math.cos(Math.toRadians(rayI));
				float cos_t = (float) Math.cos(Math.toRadians(rayJ));
				
				list.add(new Raycast( new Vector3f(
							cos_s * sin_t * 5,
							sin_s * sin_t * 5,
							        cos_t * 5
						).add(staticBody.getPosition()),
						
						staticBody.getPosition())
					);
				
				physicsEngine.add(raycasts.get(raycasts.size() - 1));
			}
		}
		
		if(raycasts.size() > 0) {
			Raycast ray = raycasts.get(raycasts.size() - 1);
			CollisionSphere cSphere = new CollisionSphere(0.01f, ray.getStartPosition());
			
			for(Model r : collidedAABB)
				r.cleanUp();
			collidedAABB.clear();
			for(AABB aabb : staticBody.getMesh().getOctree().collect(cSphere, staticBody.getPosition(), 
					ray.getEndPosition().subtract(ray.getStartPosition()), true)) {
				
				collidedAABB.add(new PhysicsCubeRender(aabb.getCenter(), aabb.getRadius()));
				collidedAABB.get(collidedAABB.size() - 1).setShader(physicsShader);
			}
			
			for(Model r : collidedPlane)
				r.cleanUp();
			collidedPlane.clear();
			HashSet<Triangle> results = staticBody.getMesh().getOctree().collect(cSphere, staticBody.getPosition(), 
					ray.getEndPosition().subtract(ray.getStartPosition()));
			for(Triangle tri : results) {
				collidedPlane.add(new PhysicsPlaneRender(tri.getA(), tri.getB(), tri.getC()));
				collidedPlane.get(collidedPlane.size() - 1).setShader(physicsShader);
			}
		}
	}
	
	private static void render() {
		// Collision Point Transform
		Transform cpTransform = sphereTransform.clone();
		if(ellipseBody.getIntersection() != null) ;
//			cpTransform.setTranslation(staticBody.getPosition().add(ellipseBody.getIntersection().getPoint()));
		else if(Keyboard.isKeyDown(Keyboard.KEY_X))
			ellipseBody.addVelocity(new Vector3f( sphereSpeed, 0, 0));
		
		if(F)
			cpTransform.setScale(new Vector3f(1000, 1, 1));
		
		// Dynamic Rendering
		
//		Matrix4f transfrom = ellipseBody.getBody().getInverseTransform();
//		Vector3f spherePosition = staticBody.getMesh().getPosition().subtract(ellipseBody.getPosition()).transform(transfrom).multiply(-1);
//		
//		float[] newData = new float[meshData.length];
//		for(int i = 0; i < newData.length; i += 3) {
//			Vector3f pos = new Vector3f(meshData[i], meshData[i+1], meshData[i+2]);
//			
//			pos = pos.rotate(staticBody.getRotation());
//			pos = pos.transform(transfrom);
//			
//			newData[i + 0] = pos.x;
//			newData[i + 1] = pos.y;
//			newData[i + 2] = pos.z;
//		}
//		meshClone.getModelData().storeDataInAttributeList(Shader.ATTRIBUTE_LOC_POSITIONS, 3, newData, true);
//		
//		unitSphere.render(new PhysicsRenderProperties(new Transform(spherePosition, new Vector3f(), new Vector3f(1)), new Vector3f(1), false), camera);
//		meshClone.render(new PhysicsRenderProperties(new Transform(), new Vector3f(1, 0, 1), true), camera);
//		
//		 Render Sphere
//		sphereCenter.render(new PhysicsRenderProperties(cpTransform, new Vector3f(.75, 0, .75), false), camera);
//		sphere.render(new PhysicsRenderProperties(sphereTransform, 
//				ellipseBody.getIntersection() == null ? new Vector3f(0, 1, 0) : new Vector3f(1, 0, 0),
//			false), camera);
		
//		Vector3f p0 = new Vector3f(-0.980785, 1.0, -0.195091).rotate(staticBody.getRotation()).add(staticBody.getPosition());
//		Vector3f p1 = new Vector3f(0.19509, 1.0, -0.980785).rotate(staticBody.getRotation()).add(staticBody.getPosition());
//		Vector3f p2 = new Vector3f(0.980785, 1.0, 0.19509).rotate(staticBody.getRotation()).add(staticBody.getPosition());
		
//		Transform p0Transform = new Transform(p0, new Vector3f(), new Vector3f(2));
//		Transform p1Transform = new Transform(p1, new Vector3f(), new Vector3f(2));
//		Transform p2Transform = new Transform(p2, new Vector3f(), new Vector3f(2));
		
//		sphereCenter.render(new PhysicsRenderProperties(p0Transform, new Vector3f(.5, 1, 1), false), camera);
//		sphereCenter.render(new PhysicsRenderProperties(p1Transform, new Vector3f(.5, 1, 1), false), camera);
//		sphereCenter.render(new PhysicsRenderProperties(p2Transform, new Vector3f( 0, 1, 0), false), camera);
			
		if(rayI > 180) {
			for(Raycast raycast : raycastRenders) {
				if(raycast != null) {
					Vector3f p0 = raycast.getStartPosition();
					Vector3f p1 = raycast.getIntersection() == null ? raycast.getEndPosition() : raycast.getIntersection().getPoint();
					
					for(int i = 0; i < 1; i ++) {
						Transform lineTransform = new Transform(p1.subtract(p0).divide(100).multiply(i).add(p0), new Vector3f(), new Vector3f(1));
						sphereCenter.render(new PhysicsRenderProperties(lineTransform, 
								raycast.getIntersection() == null ? new Vector3f(1, 0, 0) : new Vector3f(1, 1, 0), false), camera);
					}
				}
			}
		}
		
		if(raycasts.size() > 0) {
			float i = 0;
			for(Model r : collidedAABB) {
				java.awt.Color color = java.awt.Color.getHSBColor((i ++ / collidedAABB.size()), .5f, 1);
				r.render(new PhysicsRenderProperties(cubeTransform, new Vector3f(color.getRed(), color.getGreen(), color.getBlue()).divide(255), true), camera);
			}
			
			Transform cubeTransformClone = cubeTransform.clone();
			cubeTransformClone.setScale(cubeTransformClone.getScale().add(0.0001f));
			
			i = 0;
			for(Model r : collidedPlane) {
				java.awt.Color color = java.awt.Color.getHSBColor((i ++ / collidedPlane.size()), .5f, 1);
				r.render(new PhysicsRenderProperties(cubeTransformClone, new Vector3f(color.getRed(), color.getGreen(), color.getBlue()).divide(255), true), camera);
			}
			
			Raycast raycast = raycasts.get(raycasts.size() - 1);
			if(raycast != null) {
				Vector3f p0 = raycast.getStartPosition();
				Vector3f p1 = raycast.getIntersection() == null ? raycast.getEndPosition() : raycast.getIntersection().getPoint();
				
				for(int j = 0; j < 100; j ++) {
					Transform lineTransform = new Transform(p1.subtract(p0).divide(100).multiply(j).add(p0), new Vector3f(), new Vector3f(1));
					sphereCenter.render(new PhysicsRenderProperties(lineTransform, 
							raycast.getIntersection() == null ? new Vector3f(1, 0, 0) : new Vector3f(1, 1, 0), false), camera);
				}
			}
		}
		
		sphereCenter.render(new PhysicsRenderProperties(new Transform(new Vector3f(8.537911, -2.570443, 2.424048), new Vector3f(0), new Vector3f(2)), new Vector3f(.25, .35, 1), false), camera);
		
//		unitSphere.render(new PhysicsRenderProperties(new Transform(ellipseBody.getPosition(), new Vector3f(), new Vector3f(ellipseBody.getBody().getRadius().max())), new Vector3f(.75f), false), camera);
		
		// Render Main Cube
		cube.render(new PhysicsRenderProperties(cubeTransform, new Vector3f(1, .5f, 0), !R_CTRL), camera);
		
		if(!R_CTRL) {
			Transform trans = cubeTransform.clone();
			trans.setScale(new Vector3f(1.0001f));
			
			cube.render(new PhysicsRenderProperties(trans, new Vector3f(1, 1, 1), false), camera);
		}
		
		if(!R_SHIFT)
			octreeRender.render(new PhysicsRenderProperties(cubeTransform, new Vector3f(0, 0, .75f), false, true), camera);
		
		
		
//		 Lock-in Data
//		ellipseBody.setPosition(new Vector3f(1.985207, 0.0, 0.0));
//		ellipseBody.setRotation(new Vector3f(0.0, 0.0, -51.074936)); 
//		ellipseBody.setRotation(new Vector3f(0.0, 0.0, -125.54509));
//		ellipseBody.setPosition(new Vector3f(0.0, 0.0, 0.0)); // Cube Rot: 45 0 15
//		ellipseBody.setPosition(new Vector3f(2.1749117, 0.98305106, 0.0)); // Cube Rot: 45 0 15
//		ellipseBody.setPosition(new Vector3f(2.0174327, 1.1752194, 0.0));
//		ellipseBody.setPosition(new Vector3f(2.1911242, 0.0, 0.0));
//		ellipseBody.setPosition(new Vector3f(2.1, 0, 0));
//		ellipseBody.setPosition(new Vector3f(3, 0, 1.6));
//		ellipseBody.setPosition(new Vector3f(2.5, 0, -1));
//		ellipseBody.setPosition(new Vector3f(5, -.5, -1.9));
//		ellipseBody.setPosition(new Vector3f(-1.5795497, 0.0, -1.5795498).rotate(new Vector3f(0, 45, 0)).add(5, 0, 0));
//		ellipseBody.setPosition(new Vector3f(-1.5795497, 0.0, -1.5795498).add(5, 0, 0));//1.020695, 0.0, 0.0));
		sphereTransform.setTranslation(ellipseBody.getPosition()); // -1.4054742, 0.0, -1.4054742
		sphereTransform.setRotation(ellipseBody.getRotation());
	}
}