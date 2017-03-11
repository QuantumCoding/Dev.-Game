package com.GameName.PhysicsEngine;

import java.io.IOException;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;

import com.GameName.PhysicsEngine.Bodies.MovingBody;
import com.GameName.PhysicsEngine.Bodies.StaticBody;
import com.GameName.PhysicsEngine.Detection.Colliders.CollisionEllipse;
import com.GameName.PhysicsEngine.Detection.Colliders.CollisionMesh;
import com.GameName.PhysicsEngine.Detection.Colliders.CollisionMeshLoader;
import com.GameName.PhysicsEngine.Detection.Intersection.Tests.MovingEllipsoidMeshIntersectionTest;
import com.GameName.PhysicsEngine.Render.PhysicsRenderProperties;
import com.GameName.PhysicsEngine.Render.PhysicsRenderer;
import com.GameName.PhysicsEngine.Render.PhysicsShader;
import com.GameName.PhysicsEngine.Render.Octree.OctreeRender;
import com.GameName.PhysicsEngine.Render.Sphere.SphereRender;
import com.GameName.RenderEngine.RenderEngine;
import com.GameName.RenderEngine.Models.Model;
import com.GameName.RenderEngine.Models.ModelLoader;
import com.GameName.RenderEngine.Util.Camera;
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
	private static StaticBody staticBody2;
	
	private static SphereRender sphere;
	private static Model cube, cube2;
	private static OctreeRender octreeRender;
	
	private static Transform sphereTransform;
	private static Transform cubeTransform;
	private static Transform cubeTransform2;
	
	private static float speed, sphereSpeed, rotationShereSpeed;
	private static Vector3f target, targetRadius, radiusChangeRate;
	
	public static void main(String[] args) throws IOException, LWJGLException {
		window = new Window();
		window.setFPS(120);
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
		cube2.cleanUp();
		
		physicsShader.cleanUp();
		
		window.destroy();
	}
	
	private static void init() {
		// Create Engine & Components
		physicsEngine = new PhysicsEngine();
		renderEngine = new RenderEngine();

		camera = new Camera(70, (float) window.getWidth() / (float) window.getHeight(), 0.3f, 1000);
		
		physicsEngine.addIntersectionTest(new MovingEllipsoidMeshIntersectionTest());
		
		// Create Shaders 
		physicsShader = new PhysicsShader();
		PhysicsRenderer physicsRenderer = (PhysicsRenderer) physicsShader.getRenderer();
		renderEngine.addRenderer(physicsRenderer);
		
		// Create Collision Frames											2, 4, .75
		CollisionEllipse collisionEllipse = new CollisionEllipse(Vector3f.random(2).add(.75f)); // Vector3f.random(2).add(0.5f));//
		CollisionMesh collisionMesh = CollisionMeshLoader.loadObj("res/models/cylinder.obj");//DefaultCube //cylinder 
		CollisionMesh collisionMesh2 = CollisionMeshLoader.loadObj("res/models/invertedSphere2.obj");//DefaultCube //cylinder 

		// Create Object Transforms
		sphereTransform = new Transform();
		cubeTransform = new Transform();
		cubeTransform2 = new Transform();
		
		// Transform transforms
		cubeTransform.translate(new Vector3f(5, 0, 0));
//		cubeTransform.rotate(new Vector3f(30834.768, 16627.076, 27693.992));
		cubeTransform2.translate(new Vector3f(5, 0, -3));
		cubeTransform2.scale(new Vector3f(1));
		
		// Create Renders
		sphere = new SphereRender(new CollisionEllipse(new Vector3f(1)), 30); //     collisionEllipse.getRadius().max()

		cube = new Model(ModelLoader.loadOBJ("res/models/cylinder.obj"));
		cube2 = new Model(ModelLoader.loadOBJ("res/models/invertedSphere2.obj"));
		octreeRender = new OctreeRender(collisionMesh.getOctree());
		
		// Attach Shaders
		sphere.setShader(physicsShader);
		
		cube.setShader(physicsShader);
		cube2.setShader(physicsShader);
		octreeRender.setShader(physicsShader);

		// Create Collision Bodies
		ellipseBody = new MovingBody(collisionEllipse);
		staticBody = new StaticBody(collisionMesh);
		staticBody2 = new StaticBody(collisionMesh2);
		
//		physicsEngine.add(staticBody);
		physicsEngine.add(staticBody2);
		physicsEngine.add(ellipseBody);
		
		staticBody.setPosition(cubeTransform.getTranslation());
		staticBody.setRotation(cubeTransform.getRotation());
		
		staticBody2.setPosition(cubeTransform2.getTranslation());
		staticBody2.setRotation(cubeTransform2.getRotation());
		
		staticBody2.setScale(cubeTransform2.getScale());
	}
	
	private static boolean R_SHIFT = false, R_SHIFT_TOGGLE = false;
	private static boolean R_CTRL = false, R_CTRL_TOGGLE = false;
	private static boolean F = false, F_TOGGLE = false;
	
	private static boolean num9 = false;
	
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
		sphereSpeed = 0.5f;
		sphereSpeed = (float) ((Keyboard.isKeyDown(Keyboard.KEY_O) ? sphereSpeed * 2 : 
			(Keyboard.isKeyDown(Keyboard.KEY_U) ? sphereSpeed / 2 : sphereSpeed)) * window.getFrameTime());
		
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD7)) ellipseBody.addForce(new Vector3f(0,  sphereSpeed, 0)); 
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD1)) ellipseBody.addForce(new Vector3f(0, -sphereSpeed, 0));
		
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD4)) ellipseBody.addForce(new Vector3f(-sphereSpeed, 0, 0)); 
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD6)) ellipseBody.addForce(new Vector3f( sphereSpeed, 0, 0)); 
                                                                                         
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD5)) ellipseBody.addForce(new Vector3f(0, 0,  sphereSpeed)); 
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD8)) ellipseBody.addForce(new Vector3f(0, 0, -sphereSpeed)); 
		
		if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD9) && !num9) 
			ellipseBody.addForce(new Vector3f(100000000, 100000000, 100000000)); 
		num9 = Keyboard.isKeyDown(Keyboard.KEY_NUMPAD9);
		
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
			
			ellipseBody.setVelocity(new Vector3f());
//			ellipseBody.setVelocity(new Vector3f(10 / 120.0, 0.01, -2 / 120.0)); 
		}
		
		// Cube Rotation
		if(cubeTransform.getRotation().x % 360 < target.x)
			cubeTransform.setRotation(cubeTransform.getRotation().add(new Vector3f(90/2, 0, 0).multiply((float) window.getFrameTime())));
		else target.x = 3600;//(float) (Math.random() * 360);
		
		if(cubeTransform.getRotation().y % 360 < target.y)
			cubeTransform.setRotation(cubeTransform.getRotation().add(new Vector3f(0, 49/2, 0).multiply((float) window.getFrameTime())));
		else target.y = 36000;//(float) (Math.random() * 360);
		
		if(cubeTransform.getRotation().z % 360 < target.z)
			cubeTransform.setRotation(cubeTransform.getRotation().add(new Vector3f(0, 0, 81/2).multiply((float) window.getFrameTime())));
		else target.z = 36000;//(float) (Math.random() * 360);
			
		if(Keyboard.isKeyDown(Keyboard.KEY_C)) cubeTransform.setRotation(cubeTransform.getRotation().multiply(0, 1, 1));
		if(Keyboard.isKeyDown(Keyboard.KEY_V)) cubeTransform.setRotation(cubeTransform.getRotation().multiply(1, 0, 1));
		if(Keyboard.isKeyDown(Keyboard.KEY_B)) cubeTransform.setRotation(cubeTransform.getRotation().multiply(1, 1, 0));
		
//		staticBody.setRotation(cubeTransform.getRotation());
//		ellipseBody.setRotation(cubeTransform.getRotation());
//		cubeTransform2.setRotation(cubeTransform.getRotation());
		
		if(targetRadius == null || ((CollisionEllipse) ellipseBody.getBodies().get(0)).getRadius().abs().subtract(targetRadius.abs()).lessThen(0.001f)) {
			targetRadius = ((CollisionEllipse) ellipseBody.getBodies().get(0)).getRadius(); //.random(10).add(0.1f);
			radiusChangeRate = targetRadius.subtract(((CollisionEllipse) ellipseBody.getBodies().get(0)).getRadius()).divide(120);
		} else {
			((CollisionEllipse) ellipseBody.getBodies().get(0)).setRadius(((CollisionEllipse) ellipseBody.getBodies().get(0)).getRadius().add(radiusChangeRate));
		}
		

	}
	
	private static void render() {
		// Collision Point Transform
		Transform cpTransform = sphereTransform.clone();
		if(ellipseBody.getIntersection() != null) ;
//			cpTransform.setTranslation(staticBody.getPosition().add(ellipseBody.getIntersection().getPoint()));
		else if(Keyboard.isKeyDown(Keyboard.KEY_X))
			ellipseBody.addForce(new Vector3f( sphereSpeed, 0, 0));
		
		if(F)
			cpTransform.setScale(new Vector3f(1000, 1, 1));
		
//		 Render Sphere
		sphereTransform.setScale(((CollisionEllipse) ellipseBody.getBodies().get(0)).getRadius());
		sphere.render(new PhysicsRenderProperties(sphereTransform, 
				ellipseBody.getIntersection() == null ? new Vector3f(0, 1, 0) : new Vector3f(1, 0, 0),
			false), camera);
		
//		Vector3f p0 = ellipseBody.getPosition();
//		Vector3f p1 = ellipseBody.getPosition().add(ellipseBody.getVelocity().normalize().multiply(25));
		
//		p0 = p0.subtract(staticBody.getPosition()).rotate(staticBody.getRotation()).add(staticBody.getPosition());
//		p1 = p1.subtract(staticBody.getPosition()).rotate(staticBody.getRotation()).add(staticBody.getPosition());
		
//		for(int i = 0; i < 100; i += 1) {
//			Transform lineTransform = new Transform(p1.subtract(p0).divide(100).multiply(i).add(p0), new Vector3f(), new Vector3f(0.1f));
//			sphere.render(new PhysicsRenderProperties(lineTransform, new Vector3f(1, i/100.0f, 0), false), camera);
//		}
			
		// Render Main Cube
//		cube.render(new PhysicsRenderProperties(cubeTransform, new Vector3f(1, .5f, 0), !R_CTRL), camera);
		cube2.render(new PhysicsRenderProperties(cubeTransform2, new Vector3f(0.1f), !R_CTRL), camera);
		
		if(!R_CTRL) {
//			Transform trans = cubeTransform.clone();
//			trans.setScale(new Vector3f(1.0001f));
//			cube.render(new PhysicsRenderProperties(trans, new Vector3f(1, 1, 1), false), camera);
			
			Transform trans2 = cubeTransform2.clone();
			trans2.setScale(cubeTransform2.getScale().add(-0.001f));
			cube2.render(new PhysicsRenderProperties(trans2, new Vector3f(1, 1, 1), false), camera);
		}
		
//		if(!R_SHIFT)
//			octreeRender.render(new PhysicsRenderProperties(cubeTransform, new Vector3f(0, 0, .75f), false, true), camera);
		
//		 Lock-in Data
//		ellipseBody.setPosition(new Vector3f(1.985207, 0.0, 0.0));
//		ellipseBody.setRotation(new Vector3f(0.0, 0.0, -51.074936)); 
		sphereTransform.setTranslation(ellipseBody.getPosition()); 
		sphereTransform.setRotation(ellipseBody.getRotation());
	}
	
	public void raycastTest() {
// FEILDS --------------------------------------
		
//		private static ArrayList<Raycast> raycasts, raycastRenders;
//		private static ArrayList<PhysicsPlaneRender> collidedPlane;
//		private static ArrayList<PhysicsCubeRender> collidedAABB;
//		private static int rayI, rayJ;
//		private static long startTime = -1;
		
//	INIT ------------------------------------------
		
//		raycasts = new ArrayList<>();
//		raycastRenders = new ArrayList<>();
//		collidedAABB = new ArrayList<>(); 
//		collidedPlane = new ArrayList<>();
//		
//		raycasts.add(new Raycast(new Vector3f(), staticBody.getPosition()));
//		physicsEngine.add(raycasts.get(raycasts.size() - 1));
		
//	UPDATE -----------------------------------------	
		
//		ListIterator<Raycast> list = raycasts.listIterator();
//		while(list.hasNext()) {
//			if(startTime == -1)
//				startTime = System.currentTimeMillis();
//			Raycast ray = list.next();
//			
//			if(ray.getIntersection() != null || ray.getStartPosition().distance(ray.getPosition()) > 10) {
//				physicsEngine.remove(ray);
////				if(ray.getIntersection() == null) {
////					raycastRenders.clear();
//					raycastRenders.add(ray);
////				}
//				
//				list.remove();
////				list.add(new Raycast(ray.getStartPosition(), ray.getEndPosition()));
//				
//				rayJ += 5;
//				
//				if(rayI > 180) {
//					System.out.println("Done");
//					long change = System.currentTimeMillis() - startTime;
//					System.out.println(change / 1000.0);
//					System.out.println(raycastRenders.size() > 0);
//					
//					break;
//				}
//				
//				if(rayJ > 360) {
//					rayI += 5;
//					rayJ = 0;
//				}
//				
//				float sin_s = (float) Math.sin(Math.toRadians(rayI));
//				float sin_t = (float) Math.sin(Math.toRadians(rayJ));
//				float cos_s = (float) Math.cos(Math.toRadians(rayI));
//				float cos_t = (float) Math.cos(Math.toRadians(rayJ));
//				
//				list.add(new Raycast( new Vector3f(
//							cos_s * sin_t * 5,
//							sin_s * sin_t * 5,
//							        cos_t * 5
//						).add(staticBody.getPosition()),
//						
//						staticBody.getPosition())
//					);
//				
//				physicsEngine.add(raycasts.get(raycasts.size() - 1));
//			}
//		}
//		
////		if(raycastRenders.size() > 0) {
////			Raycast ray = raycastRenders.get(raycastRenders.size() - 1);
////			CollisionSphere cSphere = new CollisionSphere(0.01f, ray.getStartPosition());
////			
////			for(Model r : collidedAABB)
////				r.cleanUp();
////			collidedAABB.clear();
////			for(AABB aabb : staticBody.getMesh().getOctree().collect(cSphere, staticBody.getPosition(), 
////					ray.getEndPosition().subtract(ray.getStartPosition()), true)) {
////				
////				collidedAABB.add(new PhysicsCubeRender(aabb.getCenter(), aabb.getRadius()));
////				collidedAABB.get(collidedAABB.size() - 1).setShader(physicsShader);
////			}
////			
////			for(Model r : collidedPlane)
////				r.cleanUp();
////			collidedPlane.clear();
////			HashSet<Triangle> results = staticBody.getMesh().getOctree().collect(cSphere, staticBody.getPosition(), 
////					ray.getEndPosition().subtract(ray.getStartPosition()));
////			for(Triangle tri : results) {
////				collidedPlane.add(new PhysicsPlaneRender(tri.getA(), tri.getB(), tri.getC()));
////				collidedPlane.get(collidedPlane.size() - 1).setShader(physicsShader);
////			}
////		}
	
//	 RENDER -----------------------------------------
		
//		if(rayI > 180) {
//		for(Raycast raycast : raycastRenders) {
//			if(raycast != null) {
//				Vector3f p0 = raycast.getStartPosition();
//				Vector3f p1 = raycast.getIntersection() == null ? raycast.getEndPosition() : raycast.getIntersection().getPoint();
//				
////				p0 = p0.subtract(staticBody.getPosition()).rotate(staticBody.getRotation()).add(staticBody.getPosition());
////				p1 = p1.subtract(staticBody.getPosition()).rotate(staticBody.getRotation()).add(staticBody.getPosition());
//				
//				for(int i = 99; i < 100; i ++) {
//					Transform lineTransform = new Transform(p1.subtract(p0).divide(100).multiply(i).add(p0), new Vector3f(), new Vector3f(1));
////					sphere.render(new PhysicsRenderProperties(lineTransform, 
////							raycast.getIntersection() == null ? new Vector3f(1, 0, 0) : new Vector3f(1, 1, 0), false), camera);
//				}
//			}
//		}
//	}
	
//	else if(raycastRenders.size() > 0) {
////		float i = 0; for(Model r : collidedAABB) {
////			java.awt.Color color = java.awt.Color.getHSBColor((i ++ / collidedAABB.size()), .5f, 1);
////			r.render(new PhysicsRenderProperties(cubeTransform, new Vector3f(color.getRed(), color.getGreen(), color.getBlue()).divide(255), true), camera);
////		}
////		
////		Transform cubeTransformClone = cubeTransform.clone();
////		cubeTransformClone.setScale(cubeTransformClone.getScale().add(0.0001f));
////		
////		i = 0; for(Model r : collidedPlane) {
////			java.awt.Color color = java.awt.Color.getHSBColor((i ++ / collidedPlane.size()), .5f, 1);
////			r.render(new PhysicsRenderProperties(cubeTransformClone, new Vector3f(color.getRed(), color.getGreen(), color.getBlue()).divide(255), true), camera);
////		}
//		
//		Raycast raycast = raycastRenders.get(raycastRenders.size() - 1);
//		if(raycast != null) {
//			Vector3f p0 = raycast.getStartPosition();
//			Vector3f p1 = raycast.getIntersection() == null ? raycast.getEndPosition() : raycast.getIntersection().getPoint();
//			
//			p0 = p0.subtract(staticBody.getPosition()).rotate(staticBody.getRotation()).add(staticBody.getPosition());
//			p1 = p1.subtract(staticBody.getPosition()).rotate(staticBody.getRotation()).add(staticBody.getPosition());
//			
//			for(int j = 0; j < 100; j ++) {
//				Transform lineTransform = new Transform(p1.subtract(p0).divide(100).multiply(j).add(p0), new Vector3f(), new Vector3f(1));
//				sphere.render(new PhysicsRenderProperties(lineTransform, 
//						raycast.getIntersection() == null ? new Vector3f(1, 0, 0) : new Vector3f(1, 1, 0), false), camera);
//			}
//		}
//	}
	
	}
}