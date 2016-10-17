package com.GameName.PhysicsEngine;

import java.io.IOException;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;

import com.GameName.PhysicsEngine.Bodies.MovingBody;
import com.GameName.PhysicsEngine.Bodies.StaticBody;
import com.GameName.PhysicsEngine.Detection.CollisionEllipse;
import com.GameName.PhysicsEngine.Detection.CollisionMesh;
import com.GameName.PhysicsEngine.Detection.CollisionMeshLoader;
import com.GameName.PhysicsEngine.Render.PhysicsRenderProperties;
import com.GameName.PhysicsEngine.Render.PhysicsRenderer;
import com.GameName.PhysicsEngine.Render.PhysicsShader;
import com.GameName.PhysicsEngine.Render.Octree.OctreeRender;
import com.GameName.PhysicsEngine.Render.Sphere.SphereRender;
import com.GameName.RenderEngine.RenderEngine;
import com.GameName.RenderEngine.Models.Model;
import com.GameName.RenderEngine.Models.ModelLoader;
import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.RenderEngine.Util.Camera;
import com.GameName.RenderEngine.Util.RenderStructs.Transform;
import com.GameName.RenderEngine.Window.Window;
import com.GameName.Util.Vectors.Vector3f;

public class PhysicsTestRunner {
	public static void main(String[] args) throws IOException, LWJGLException {
		Window window = new Window();
		window.setFPS(120);
		window.initDisplay(600,600);
		
		PhysicsEngine physicsEngine = new PhysicsEngine();
		
		RenderEngine renderEngine = new RenderEngine();
		Camera camera = new Camera(70, (float)window.getWidth() / (float)window.getHeight(), 0.3f, 1000);
		
		PhysicsShader physicsShader = new PhysicsShader();
		PhysicsRenderer physicsRenderer = (PhysicsRenderer) physicsShader.getRenderer();

		renderEngine.addRenderer(physicsRenderer);
		
		Transform sphereTransform = new Transform();
		CollisionEllipse collisionEllipse = new CollisionEllipse(new Vector3f(1, 1, 1));
		SphereRender sphere = new SphereRender(collisionEllipse, 30);
		sphere.setShader(physicsShader);
		
		SphereRender sphereCenter = new SphereRender(new CollisionEllipse(new Vector3f(0.01f)), 15);
		sphereCenter.setShader(physicsShader);
		
		Transform cubeTransform = new Transform(); cubeTransform.translate(new Vector3f(5, 0, 0));
		CollisionMesh collisionMesh = CollisionMeshLoader.loadObj("res/models/cylinder.obj");//DefaultCube //cylinder 
		Model cube = new Model(ModelLoader.loadOBJ("res/models/cylinder.obj"));
		cube.setShader(physicsShader);
		
		OctreeRender octreeRender = new OctreeRender(collisionMesh.getOctree());
		octreeRender.setShader(physicsShader);
		

		MovingBody ellipseBody = new MovingBody(collisionEllipse);
		StaticBody staticBody = new StaticBody(collisionMesh);
		
		physicsEngine.add(staticBody);
		physicsEngine.add(ellipseBody);
		
		staticBody.setPosition(cubeTransform.getTranslation());
		
		
		
		double frameTimeAvg = 0.0;
		int frameAvgCounter = 0;
		
		camera.x = 2.5f;
		camera.z = 7;
		
		boolean R_SHIFT = false, R_SHIFT_TOGGLE = false;
		boolean R_CTRL = false, R_CTRL_TOGGLE = false;
		
		while(!window.isCloseRequested()) {
			
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
			
			float sphereSpeed = (float) ((Keyboard.isKeyDown(Keyboard.KEY_I) ? 2 : (Keyboard.isKeyDown(Keyboard.KEY_O) ? 0.25f : 1)) * window.getFrameTime());
			
			if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD7)) ellipseBody.addVelocity(new Vector3f(0,  sphereSpeed, 0)); 
			if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD1)) ellipseBody.addVelocity(new Vector3f(0, -sphereSpeed, 0));
			
			if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD4)) ellipseBody.addVelocity(new Vector3f(-sphereSpeed, 0, 0)); 
			if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD6)) ellipseBody.addVelocity(new Vector3f( sphereSpeed, 0, 0)); 
                                                                                             
			if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD5)) ellipseBody.addVelocity(new Vector3f(0, 0,  sphereSpeed)); 
			if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD8)) ellipseBody.addVelocity(new Vector3f(0, 0, -sphereSpeed)); 
			
			float speed = (float) ((Keyboard.isKeyDown(Keyboard.KEY_SPACE) ? 24 : (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) ? 1 : 6)) * window.getFrameTime());
			
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
			}
			
			if(Keyboard.isKeyDown(Keyboard.KEY_T))
				Shader.setSkyColor(new Vector3f(Math.random(), Math.random(), Math.random()));
			
			sphere.render(new PhysicsRenderProperties(sphereTransform, 
					!ellipseBody.isIntersecting() ? new Vector3f(0, 1, 0) : new Vector3f(1, 0, 0),
				false), camera);
			
			sphereCenter.render(new PhysicsRenderProperties(sphereTransform, new Vector3f(.75, 0, .75), false), camera);
			
			
			cube.render(new PhysicsRenderProperties(cubeTransform, new Vector3f(1, .5f, 0), !R_CTRL), camera);
			
			if(!R_CTRL) {
				Transform trans = cubeTransform.clone();
				trans.setScale(new Vector3f(1.0001f));
				
				cube.render(new PhysicsRenderProperties(trans, new Vector3f(1, 1, 1), false), camera);
			}
			
			if(!R_SHIFT)
				octreeRender.render(new PhysicsRenderProperties(cubeTransform, new Vector3f(0, 0, .75f), false, true), camera);
			
			sphereTransform.setTranslation(ellipseBody.getPosition());
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
}
