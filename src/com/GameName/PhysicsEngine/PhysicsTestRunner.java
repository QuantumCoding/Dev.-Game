package com.GameName.PhysicsEngine;

import java.awt.Component;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatter;

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
		CollisionEllipse collisionEllipse = new CollisionEllipse(new Vector3f(1, 1, 1)); //Vector3f.random(2).add(0.5f));//
		SphereRender sphere = new SphereRender(collisionEllipse, 30);
		sphere.setShader(physicsShader);
		
		SphereRender sphereCenter = new SphereRender(new CollisionEllipse(new Vector3f(0.01f)), 15);
		sphereCenter.setShader(physicsShader);
		
		Transform cubeTransform = new Transform(); cubeTransform.translate(new Vector3f(5, 0, 0));
		cubeTransform.setRotation(new Vector3f(45, 0, 70));//45, 150, 70));
		
		CollisionMesh collisionMesh = CollisionMeshLoader.loadObj("res/models/DefaultCube.obj");//DefaultCube //cylinder 
		Model cube = new Model(ModelLoader.loadOBJ("res/models/DefaultCube.obj"));
		cube.setShader(physicsShader);
		
		OctreeRender octreeRender = new OctreeRender(collisionMesh.getOctree());
		octreeRender.setShader(physicsShader);
		

		MovingBody ellipseBody = new MovingBody(collisionEllipse);
		StaticBody staticBody = new StaticBody(collisionMesh);
		
		physicsEngine.add(staticBody);
		physicsEngine.add(ellipseBody);
		
		staticBody.setPosition(cubeTransform.getTranslation());
		staticBody.setRotation(cubeTransform.getRotation());
		
		Transform globalTransfrom = new Transform();
		globalTransfrom.setScale(collisionEllipse.getRadius().clone());
		TransfromEditor editor = new TransfromEditor(globalTransfrom);
		
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
			
			float sphereSpeed = (float) ((Keyboard.isKeyDown(Keyboard.KEY_O) ? 2 : (Keyboard.isKeyDown(Keyboard.KEY_U) ? 0.25f : 1)) * window.getFrameTime());
			
			if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD7)) ellipseBody.addVelocity(new Vector3f(0,  sphereSpeed, 0)); 
			if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD1)) ellipseBody.addVelocity(new Vector3f(0, -sphereSpeed, 0));
			
			if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD4)) ellipseBody.addVelocity(new Vector3f(-sphereSpeed, 0, 0)); 
			if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD6)) ellipseBody.addVelocity(new Vector3f( sphereSpeed, 0, 0)); 
                                                                                             
			if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD5)) ellipseBody.addVelocity(new Vector3f(0, 0,  sphereSpeed)); 
			if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD8)) ellipseBody.addVelocity(new Vector3f(0, 0, -sphereSpeed)); 
			
			float rotationShereSpeed = (float) ((Keyboard.isKeyDown(Keyboard.KEY_O) ? 60 : (Keyboard.isKeyDown(Keyboard.KEY_O) ? 15 : 30)) * window.getFrameTime());
			
			if(Keyboard.isKeyDown(Keyboard.KEY_Y)) ellipseBody.addRotation(new Vector3f(0,  rotationShereSpeed, 0)); 
			if(Keyboard.isKeyDown(Keyboard.KEY_H)) ellipseBody.addRotation(new Vector3f(0, -rotationShereSpeed, 0));
			
			if(Keyboard.isKeyDown(Keyboard.KEY_I)) ellipseBody.addRotation(new Vector3f(-rotationShereSpeed, 0, 0)); 
			if(Keyboard.isKeyDown(Keyboard.KEY_K)) ellipseBody.addRotation(new Vector3f( rotationShereSpeed, 0, 0)); 
                                                                                             
			if(Keyboard.isKeyDown(Keyboard.KEY_J)) ellipseBody.addRotation(new Vector3f(0, 0,  rotationShereSpeed)); 
			if(Keyboard.isKeyDown(Keyboard.KEY_L)) ellipseBody.addRotation(new Vector3f(0, 0, -rotationShereSpeed)); 
			
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
				ellipseBody.setRotation(new Vector3f());
			}
			
			// Collision Point Transform
			Transform cpTransform = sphereTransform.clone();
			if(ellipseBody.getIntersection() != null) 
				cpTransform.setTranslation(staticBody.getPosition().add(ellipseBody.getIntersection().getPoint()));
			
			sphereCenter.render(new PhysicsRenderProperties(cpTransform, new Vector3f(.75, 0, .75), false), camera);
			sphere.render(new PhysicsRenderProperties(sphereTransform, 
					ellipseBody.getIntersection() == null ? new Vector3f(0, 1, 0) : new Vector3f(1, 0, 0),
				false), camera);
			
			
			cube.render(new PhysicsRenderProperties(cubeTransform, new Vector3f(1, .5f, 0), !R_CTRL), camera);
			
			if(!R_CTRL) {
				Transform trans = cubeTransform.clone();
				trans.setScale(new Vector3f(1.0001f));
				
				cube.render(new PhysicsRenderProperties(trans, new Vector3f(1, 1, 1), false), camera);
			}
			
			if(!R_SHIFT)
				octreeRender.render(new PhysicsRenderProperties(cubeTransform, new Vector3f(0, 0, .75f), false, true), camera);
			
			sphereTransform.setTranslation(ellipseBody.getPosition());
			sphereTransform.setRotation(ellipseBody.getRotation());
			physicsEngine.simulate(1.0f);
			
			physicsShader.bind();
			physicsShader.loadGlobalTranslation(globalTransfrom.getTranslation());
			physicsShader.loadGlobalRotation(globalTransfrom.getRotation().toRadians());
//			physicsShader.loadGlobalRotation(ellipseBody.getRotation().toRadians());
			physicsShader.loadGlobalScale(globalTransfrom.getScale());
			
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
		editor.dispose();
	}
	
	private static final class TransfromEditor extends JFrame {
		private static final long serialVersionUID = 1L;
		
		private static class VectorFormat extends DefaultFormatter {
			private static final long serialVersionUID = 1L;
			
			enum Property {
				Translation, Rotation, Scale;
			}
			
			private Transform value;
			private Property property;
			
			public VectorFormat(Transform value, Property property) {
				this.property = property;
				this.value = value;
				
				setOverwriteMode(false);
			}
			
			public Vector3f get() { return VectorFormat.get(value, property); }
			
			public static Vector3f get(Transform value, Property property) {
				switch(property) {
					default: 		  return null;
					
					case Scale: 	  return value.getScale();
					case Rotation: 	  return value.getRotation();
					case Translation: return value.getTranslation();
				}
			}
			
			public String valueToString(Object object) throws ParseException {
				return get().toString(); //String.format("%7s", get().toString());
			}
			
			public Object stringToValue(String string) throws ParseException {
				int errorOffset = 1;
				
				try {
					String[] split = string.trim().substring(1, string.trim().length() - 1).split(",");
					Vector3f value = get();
					
					value.setX(Float.parseFloat(split[0]));
					errorOffset += split[0].length() + 1;
					
					value.setY(Float.parseFloat(split[1]));
					errorOffset += split[1].length() + 1;
					
					value.setZ(Float.parseFloat(split[2]));
					errorOffset += split[2].length() + 1;
					
				} catch(NumberFormatException | IndexOutOfBoundsException e) {
					throw new ParseException("Parsing Error", errorOffset);
				}
					
				return null;
			}
		}
		
		public TransfromEditor(Transform transform) {
			SwingUtilities.invokeLater(() -> {
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				setLocationRelativeTo(null);
				super.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
				
				add(makePropertyPanel(transform, VectorFormat.Property.Translation));
				add(makePropertyPanel(transform, VectorFormat.Property.Rotation));
				add(makePropertyPanel(transform, VectorFormat.Property.Scale));
				
				pack();
				setVisible(true);
			});
		}
		
		private JPanel makePropertyPanel(Transform transform, VectorFormat.Property property) {
			JPanel panel = new JPanel();
			panel.setBorder(new EmptyBorder(2, 3, 2, 3));
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			
			JLabel label = new JLabel(property + ":  ");
			panel.add(label);
			Component comp = Box.createHorizontalStrut((int) (75 - label.getMinimumSize().getWidth()));
			
			panel.remove(label);
			panel.add(comp);
			panel.add(label);
			
			JFormattedTextField input = new JFormattedTextField(new VectorFormat(transform, property));
			input.addPropertyChangeListener("value", e -> input.setValue(VectorFormat.get(transform, property)));
			input.setColumns(15);
			panel.add(input);
			
			input.setHorizontalAlignment(JFormattedTextField.CENTER);
			
			return panel;
		}
	}
}
