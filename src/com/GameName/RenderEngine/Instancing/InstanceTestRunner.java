package com.GameName.RenderEngine.Instancing;

import java.awt.Color;
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
import com.GameName.RenderEngine.Util.RenderStructs.Transform;
import com.GameName.RenderEngine.Window.Window;
import com.GameName.Util.Vectors.Vector3f;

public class InstanceTestRunner {
	public static void main(String... args) throws LWJGLException, IOException {
		Window window = new Window();
		window.setFPS(120000);
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
		
		TestInstanceRenderProperties[] offsets = new TestInstanceRenderProperties[25000];
//		int length = 100; float spacing = 1.5f;
		for(int i = 0; i < offsets.length; i ++) {
			Color c = Color.getHSBColor((float) i / (float) offsets.length * 360.0f, 1, 1);
//			offsets[i] = new TestInstanceRenderProperties(
//					new Vector3f(-Math.random()*length, Math.random()*length, -Math.random()*length), 
//					new Vector3f(1f));
			
			offsets[i] = new TestInstanceRenderProperties(new Transform(
					new Vector3f(Math.cos(Math.toRadians(i % 360)), 1, Math.sin(Math.toRadians(i % 360)))
						.multiply(new Vector3f(Math.sin(i / 1000.0f), 1, Math.cos(i / 1000.0f)).multiply(i/500.0f)), 
						
						new Vector3f(i / 100.0f), new Vector3f(1)),
					new Vector3f(c.getRed(), c.getGreen(), c.getBlue()).divide(255));
			
//			offsets[i] = new TestInstanceRenderProperties(
//					new Vector3f(i%length*2, (i/length)%length*2, i/(length*length)*2).multiply(spacing)
//					.add(new Vector3f(-length, -length, -2 * length).multiply(spacing).add(1.5f).subtract(0, 0, 20)),
//					new Vector3f(0.75f));	
					//new Vector3f(i % 100 / 100.0f, i / 100.0f % 100 / 100.0f, i / 1000.0f / 10.0f));
		}	
		
		double frameTimeAvg = 0.0;
		int frameAvgCounter = 0;
//		int i = 0;
		
		camera.z = -50;
		camera.rotY = 180;
		camera.y = 25;
		
//		boolean reverse = false;
		
		instanceRenderer.setRenderBehind(true);
		while(!window.isCloseRequested()) {
			move(window, camera);
			
//			i += reverse ? 200 : -200;
//			if(Math.abs(i) > offsets.length) reverse = !reverse;
//			i %= offsets.length;
//			int index = 0;
			for(TestInstanceRenderProperties offset : offsets) {
//				TestInstanceRenderProperties property = new TestInstanceRenderProperties(offset);

//				int j = i + index ++; //j %= offsets.length;
				
//				if(offset.getTransform().getTranslation().lessThenOrEqual(0, -.1f, 0)) continue;
//				offset.getTransform().setRotation(offset.getTransform().getRotation().add(10f));
				
//				offset.getTransform().setTranslation(
//						new Vector3f(Math.cos(Math.toRadians(j % 360)), 1, Math.sin(Math.toRadians(j % 360)))
//						.multiply(new Vector3f(Math.sin(j / 1000.0f), 1, Math.cos(j / 1000.0f)).multiply(j/500.0f)));
				
				if(offset.getTransform().getTranslation().anyLessThenOrEqual(-1000, -.01f, -1000)) continue;
					
				cubeRender.render(offset, camera);
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
		float speed = (float) ((Keyboard.isKeyDown(Keyboard.KEY_SPACE) ? 120 : 12) * window.getFrameTime());
		
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) camera.moveForward(speed);
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) camera.moveForward(-speed);
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) camera.moveRight(speed);
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) camera.moveRight(-speed);
		if(Keyboard.isKeyDown(Keyboard.KEY_Q)) camera.moveUp(speed);
		if(Keyboard.isKeyDown(Keyboard.KEY_Z)) camera.moveUp(-speed);

		if(Keyboard.isKeyDown(Keyboard.KEY_UP)) camera.rotX -= (speed/(Keyboard.isKeyDown(Keyboard.KEY_SPACE) ? 10 : 1)*5);
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)) camera.rotX -= (-speed/(Keyboard.isKeyDown(Keyboard.KEY_SPACE) ? 10 : 1)*5);
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) camera.rotY -= (speed/(Keyboard.isKeyDown(Keyboard.KEY_SPACE) ? 10 : 1)*5);
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) camera.rotY -= (-speed/(Keyboard.isKeyDown(Keyboard.KEY_SPACE) ? 10 : 1)*5);

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
