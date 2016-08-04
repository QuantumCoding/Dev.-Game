package com.GameName.RenderEngine.Instancing;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;

import com.GameName.RenderEngine.RenderEngine;
import com.GameName.RenderEngine.Instancing.Testing.TestInstanceRender;
import com.GameName.RenderEngine.Instancing.Testing.TestInstanceRenderProperties;
import com.GameName.RenderEngine.Instancing.Testing.TestInstanceRenderer;
import com.GameName.RenderEngine.Instancing.Testing.TestInstanceShader;
import com.GameName.RenderEngine.Models.SBModel.SBModel;
import com.GameName.RenderEngine.Models.SBModel.SBModelLoader;
import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.RenderEngine.Textures.Texture2D;
import com.GameName.RenderEngine.Util.Camera;
import com.GameName.RenderEngine.Window.Window;
import com.GameName.Util.Vectors.Vector3f;

public class InstanceTestRunner {
	public static void main(String... args) throws LWJGLException, IOException {
		Window window = new Window();
		window.setFPS(120);
		window.initDisplay(600,600);
		
		RenderEngine renderEngine = new RenderEngine();
		Camera camera = new Camera(70, (float)window.getWidth() / (float)window.getHeight(), 0.3f, 1000);
		
		TestInstanceShader instanceShader = new TestInstanceShader();
		TestInstanceRenderer instanceRenderer = (TestInstanceRenderer) instanceShader.getRenderer();

		renderEngine.addRenderer(instanceRenderer);
		
		Texture2D spectraTexture = new Texture2D(ImageIO.read(new File("res/models/cubeTexture.png")));
		SBModel cubeModel = SBModelLoader.loadSBM(new File("res/models/TexturedCube.sbm"));
		TestInstanceRender cubeRender = new TestInstanceRender(instanceShader, cubeModel.getModelData());
		cubeModel.setTexture(spectraTexture);
		cubeModel.setShader(instanceShader);
		
		Vector3f[] offsets = new Vector3f[1000];
		int length = 10; float spacing = 1.5f;
		for(int i = 0; i < offsets.length; i ++) {
//			transforms[i] = new Transform(
//					new Vector3f(-Math.random()*length, Math.random()*length, -Math.random()*length), 
//					new Vector3f(Math.random()*360, Math.random()*360, Math.random()*360), new Vector3f(1));
			
			offsets[i] = new Vector3f(i%length*2, (i/length)%length*2, i/(length*length)*2).multiply(spacing)
					.add(new Vector3f(-length, -length, -2 * length).multiply(spacing).add(1.5f).subtract(0, 0, 20));
		}	
		
		double frameTimeAvg = 0.0;
		int frameAvgCounter = 0;
		
		instanceRenderer.setRenderBehind(true);
		while(!window.isCloseRequested()) {
			move(window, camera);
				
			for(Vector3f offset : offsets) {
				TestInstanceRenderProperties property = new TestInstanceRenderProperties(offset);
				cubeRender.render(property, camera);
			}
			
			spectraTexture.bind(0);			
			renderEngine.render(camera);

			window.update();
			
			if(frameAvgCounter >= 50) {
				frameTimeAvg /= (double) frameAvgCounter;
				window.setTitle("Instance Testing | FPS: " + (int)(1.0/frameTimeAvg) + "\t FrameTime: " + (float)frameTimeAvg);
				
				frameTimeAvg = 0.0;
				frameAvgCounter = 0;
			} else {
				frameTimeAvg += window.getFrameTime();
				frameAvgCounter ++;
			}			
		}
		
		cubeModel.cleanUp();
		instanceShader.cleanUp();
		
		window.destroy();
	}
	
	private static void move(Window window, Camera camera) {
		float speed = (float) (12 * window.getFrameTime());
		
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) camera.moveForward(speed);
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) camera.moveForward(-speed);
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) camera.moveRight(speed);
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) camera.moveRight(-speed);
		if(Keyboard.isKeyDown(Keyboard.KEY_Q)) camera.moveUp(speed);
		if(Keyboard.isKeyDown(Keyboard.KEY_Z)) camera.moveUp(-speed);

		if(Keyboard.isKeyDown(Keyboard.KEY_UP)) camera.rotX -= (speed*5);
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)) camera.rotX -= (-speed*5);
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) camera.rotY -= (speed*5);
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) camera.rotY -= (-speed*5);

		if(Keyboard.isKeyDown(Keyboard.KEY_R))  {
			camera.x = 0;
			camera.y = 0;
			camera.z = 0;
			
			camera.rotX = 0;
			camera.rotY = 0;
			camera.rotZ = 0;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_T))
			Shader.setSkyColor(new Vector3f(Math.random(), Math.random(), Math.random()));
	}
}
