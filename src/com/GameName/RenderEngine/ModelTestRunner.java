package com.GameName.RenderEngine;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;

import com.GameName.RenderEngine.Lights.Light;
import com.GameName.RenderEngine.Models.Model;
import com.GameName.RenderEngine.Models.ModelLoader;
import com.GameName.RenderEngine.Models.SBModel.SBModel;
import com.GameName.RenderEngine.Models.SBModel.SBModelLoader;
import com.GameName.RenderEngine.Shaders.DefaultRenderProperties;
import com.GameName.RenderEngine.Shaders.DefaultRenderer;
import com.GameName.RenderEngine.Shaders.DefaultShader;
import com.GameName.RenderEngine.Shaders.Shader;
import com.GameName.RenderEngine.Textures.Texture2D;
import com.GameName.RenderEngine.Util.Camera;
import com.GameName.RenderEngine.Util.RenderStructs.Transform;
import com.GameName.RenderEngine.Window.Window;
import com.GameName.Util.Vectors.Vector3f;

public class ModelTestRunner {
	public static void main(String... args) throws LWJGLException, IOException {
		Window window = new Window();
		window.setFPS(120);
		window.initDisplay(600,600);
		
		RenderEngine renderEngine = new RenderEngine();
		Camera camera = new Camera(70, (float)window.getWidth() / (float)window.getHeight(), 0.3f, 1000);
		
		DefaultShader defaultShader = new DefaultShader();
		DefaultRenderer defaultRenderer = (DefaultRenderer) defaultShader.getRenderer();//new DefaultRenderer(defaultShader);

		renderEngine.addRenderer(defaultRenderer);
		
		Texture2D texture = new Texture2D(ImageIO.read(new File("res/models/StairModel.png")));
		Texture2D spectraTexture = new Texture2D(ImageIO.read(new File("res/models/spectra.png")));
		Texture2D goldTexture = new Texture2D(ImageIO.read(new File("res/models/Gold.png")));
		
		Model stairModel = new Model(ModelLoader.loadOBJ("res/models/StairModel.obj"));
		stairModel.setShader(defaultShader);
		stairModel.setTexture(texture);
		
		Model stairModelShadow = new Model(ModelLoader.loadOBJ("res/models/StairModel.obj"));
		stairModelShadow.setShader(defaultShader);
		stairModelShadow.setTexture(texture);
		
		SBModel cubeModel = SBModelLoader.loadSBM(new File("res/models/TexturedCube.sbm"));
		cubeModel.setTexture(spectraTexture);
		cubeModel.setShader(defaultShader);
		
		SBModel sphereModel = SBModelLoader.loadSBM(new File("res/models/TexturedSphere.sbm"));
		sphereModel.setTexture(goldTexture);
		sphereModel.setShader(defaultShader);
		
		Transform[] transforms = new Transform[2000];
		int length = 100;
		for(int i = 0; i < transforms.length; i ++) {
			transforms[i] = new Transform(
					new Vector3f(-Math.random()*length, Math.random()*length, -Math.random()*length), 
					new Vector3f(Math.random()*360, Math.random()*360, Math.random()*360), new Vector3f(1));
			
//			transforms[i] = new Transform(new Vector3f(i%length*2, (i/length)%length*2, i/(length*length)*2).add(0, 0, -20), 
//					new Vector3f(), new Vector3f(1));
		}	
		
		ArrayList<Light> lights = new ArrayList<>();//    0.25, 0.75, 1
		lights.add(new Light(new Vector3f(0, 0, 0), new Vector3f(1), new Vector3f(1, 0.01, 0.002)));
		lights.add(new Light(new Vector3f(0, 0, -100), new Vector3f(0.75, 0.75, 0.2)));
		
//		HashMap<String, SBMAnimation> animations = SBMAnimationLoader.loadSBMAnimation(new File("res/models/TestAnimations.sbma"));
//		cubeModel.addAnimation(animations.get("Shrink/Grow"));
//		cubeModel.addAnimation(animations.get("Shift"));
//		cubeModel.addAnimation(animations.get("Swipe"));
		
//		SBMAnimation shiftFliped = SBMAnimation.combinedAnimations("ShiftFliped", AnimationCombinationHandels.Stitch_Filp, 
//				false, animations.get("Shift"), animations.get("Shift"));
//		cubeModel.addAnimation(shiftFliped);
//		
//		SBMAnimation highResSwipe = SBMAnimation.incressFrameResolution(90, animations.get("Swipe"), "High Res. Swipe");
//		cubeModel.addAnimation(highResSwipe);
//		
//		SBMAnimation flipingShrink = SBMAnimation.combinedAnimations("FlipingScale", AnimationCombinationHandels.Stitch_Filp, true,
//				animations.get("Shrink/Grow"), animations.get("Shrink/Grow"));
//		flipingShrink = SBMAnimation.incressFrameResolution(5, flipingShrink, "FlipingScale High Res.");
//		cubeModel.addAnimation(flipingShrink);
//		
//		SBMAnimation fullAnimation = SBMAnimation.combinedAnimations("Full Animation", AnimationCombinationHandels.Sync, false,
//				cubeModel.getAnimations().toArray(new SBMAnimation[cubeModel.getAnimations().size()]));		
//		cubeModel.addAnimation(fullAnimation);
//		sphereModel.addAnimation(fullAnimation);
		
//		cubeModel.preloadAnimation(flipingShrink);
//		cubeModel.preloadAnimation(highResSwipe);
//		cubeModel.preloadAnimation(fullAnimation);
//		sphereModel.preloadAnimation(fullAnimation);
		
//		camera.rotY = 180;
//		camera.z = 30;
//		defaultRenderer.setRenderBehind(true);
		
		double frameTimeAvg = 0.0;
		int frameAvgCounter = 0;
		float counter = 0;		
		int multiplier = 1;
		
		while(!window.isCloseRequested()) {
			
			if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD0)) multiplier = 1;
			if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD1)) multiplier = 2;
			if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD2)) multiplier = 5;
			if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD3)) multiplier = 10;
			if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD4)) multiplier = 50;
			if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD5)) multiplier = 100;
			
			counter += 1f/5f * multiplier;
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
			
			lights.get(0).setPosition(new Vector3f(camera.getX(), camera.getY(), camera.getZ()));
				
//			for(Light light : lights) {
//				if(light == lights.get(0)) continue;
//				float offset = 360f/(float)lights.size() * lights.indexOf(light);
//				light.setPosition(new Vector3f(Math.cos(Math.toRadians(counter+offset)%360) * 100, 
//						Math.sin(Math.toRadians(counter+offset * 3)%360) * 5, 
//						Math.sin(Math.toRadians(counter+offset)%360) * 100 - 100));
//				
//				Transform transform2 = new Transform(light.getPosition(), new Vector3f(), new Vector3f(2));
//				RenderProperties property = new RenderProperties(transform2, 50, 1, 0);
//				sphereModel.render(property, camera);
//			}
			
//			SBMAnimation animation = flipingShrink; //cubeModel.getAnimations().get(2);
//			cubeModel.applyAnimation(animation, (int)(counter%animation.getFrameCount()));		
//			cubeModel.applyBonesTransforms();
			
			int swap = 0;
			for(Transform transform2 : transforms) {
				DefaultRenderProperties property = new DefaultRenderProperties(transform2, 10, 1, 0);
				if(swap%3 == 0)
					sphereModel.render(property, camera);	// All
				else if(swap%3 == 1)
					stairModel.render(property, camera);	// Debug
				else if(swap%3 == 2)
					cubeModel.render(property, camera);		// Run
				
				swap ++;
			}
			
			defaultShader.bind();
			defaultShader.loadLights(lights);	
			
			renderEngine.render(camera);

			window.update();
			
			if(frameAvgCounter >= 50 && counter > -1) {
				frameTimeAvg /= (double) frameAvgCounter;
				window.setTitle("Model Testing | FPS: " + (int)(1.0/frameTimeAvg) + "\t FrameTime: " + (float)frameTimeAvg);
				
				frameTimeAvg = 0.0;
				frameAvgCounter = 0;
			} else {
				frameTimeAvg += window.getFrameTime();
				frameAvgCounter ++;
			}			
		}
		
		cubeModel.cleanUp();
		sphereModel.cleanUp();
		stairModel.cleanUp();
		stairModelShadow.cleanUp();
		
		defaultShader.cleanUp();
		
		window.destroy();
	}
}
