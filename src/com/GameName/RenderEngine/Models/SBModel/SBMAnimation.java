package com.GameName.RenderEngine.Models.SBModel;

import java.util.ArrayList;
import java.util.HashMap;

import org.lwjgl.util.vector.Matrix4f;

import com.GameName.RenderEngine.Util.RenderStructs.Transform;
import com.GameName.Util.Vectors.Vector3f;
import com.GameName.Util.Vectors.Vector4f;

public class SBMAnimation {
	private ArrayList<HashMap<Integer, Transform>> frames;
	private String name;
	
	public SBMAnimation(String name) {
		this.name = name;
		frames = new ArrayList<>();
	}
	
	public void addFrame(HashMap<Integer, Transform> frame) {
		frames.add(frame);
	}
	
	public ArrayList<Bone> applyFrame(int frame, ArrayList<Bone> bones) {
		for(Integer boneIndex : frames.get(frame).keySet()) {
			bones.get(boneIndex).translate(frames.get(frame).get(boneIndex).getTranslation());
			bones.get(boneIndex).rotate(frames.get(frame).get(boneIndex).getRotation());
			bones.get(boneIndex).scale(frames.get(frame).get(boneIndex).getScale());
		}
		
		return bones;
	}
	
	public int getFrameCount() { return frames.size(); }	
	public String getName() { return name; }
	
	public static SBMAnimation combinedAnimations(String name, AnimationCombinationHandels handel, boolean avgResult, SBMAnimation... animations) {
		SBMAnimation animationFinal = new SBMAnimation(name);
		
		int max = handel == AnimationCombinationHandels.Crop ? Integer.MAX_VALUE - 1 : 0;
		for(SBMAnimation animation : animations) {
			System.out.println(animation.name + ": " + animation.getFrameCount());
			
			if(handel == AnimationCombinationHandels.Crop) {
				if(animation.getFrameCount() < max) {
					max = animation.getFrameCount();
				}
			} else {
				if(animation.getFrameCount() > max) {
					max = animation.getFrameCount();
				}
			}
		}
		
		if(handel == AnimationCombinationHandels.Sync) {
			for(int i = 0; i < animations.length; i ++) {
				if(animations[i].getFrameCount() < max) {
					animations[i] = incressFrameResolution(Math.round((float)max / (float)animations[i].getFrameCount()), 
							animations[i], animations[i].getName() + "+");
				}
			}
		}
		
		if(handel == AnimationCombinationHandels.Stitch_Filp) {
			max *= 2;
		
		} else if(handel == AnimationCombinationHandels.Loop) {
			int result = animations[0].getFrameCount(); 
			for(SBMAnimation animation : animations) {
				if(animation == animations[0]) continue;				
				result = lcm(result, animation.getFrameCount());
			} max = result;
			System.out.println(max);
		}
		
		for(int i = 0; i < max; i++) {
			HashMap<Integer, Transform> frame = new HashMap<>();
			
			for(SBMAnimation animation : animations) {
				if(i >= animation.getFrameCount() && handel == AnimationCombinationHandels.None) 
					continue;
				
				int index = i % animation.getFrameCount();
				if(handel == AnimationCombinationHandels.Stitch_Filp) {
					if(i % (animation.getFrameCount() * 2) >= animation.getFrameCount()) {
						index = animation.getFrameCount() - (index+1);
					}
				}
				
				HashMap<Integer, Transform> animationFrame = animation.frames.get(index);
				
				for(Integer bone : animationFrame.keySet()) {
					if(!frame.containsKey(bone))
						frame.put(bone, new Transform().reset());
					frame.get(bone).transformBy(animationFrame.get(bone));
				}
			}

			if(avgResult) {
				for(Integer bone : frame.keySet())
					frame.get(bone).weight(1.0f / (float)animations.length);
			}
			
			animationFinal.addFrame(frame);
		}
		
		System.out.println("FINAL -> " + animationFinal.getName() + ": " + animationFinal.getFrameCount() + "\n");
		return animationFinal;
	}
	
	private static int lcm(int a, int b) {
	    return a * (b / gcd(a, b));
	}

	private static int gcd(int a, int b) {
	    while (b > 0){
	        int temp = b;
	        b = a % b;
	        a = temp;
	    }
	    
	    return a;
	}
	
	/**
	 * 	None = Combines all animations together with no modification to the length of and animation <p>
	 * 	Sync = Delays shorter animations to match the length of the Longest Animation <p>
	 *	Crop = Crops down all animations to match the length of the Shortest Animation <p>
	 *	Stitch = Stitches together shorter animations to match the length of the Longest animation <p>
	 *	Stitch_Flip = Stitches together shorter animations Back to Front to match the length of the Longest Animation <p> 
	 *	Loop = Repeats all animations until they end at the same time
	 */
	public static enum AnimationCombinationHandels {
		None, Sync, Crop, Stitch, Stitch_Filp, Loop;
	}
	
	public static SBMAnimation incressFrameResolution(int interpalationAmount, SBMAnimation animation, String name) {
		SBMAnimation finalAnimation = new SBMAnimation(name);
		
		for(int frameIndex = 0; frameIndex < animation.getFrameCount() - 1; frameIndex++) {
			HashMap<Integer, Transform> currentFrame = animation.frames.get(frameIndex);
			HashMap<Integer, Transform> nextFrame = animation.frames.get(frameIndex + 1);
			
			for(int i = 0; i < interpalationAmount; i++) {
				HashMap<Integer, Transform> frame = new HashMap<>();
				
				for(Integer bone : currentFrame.keySet()) {
					Vector3f transformAmount = nextFrame.get(bone).getTranslation().subtract(
							currentFrame.get(bone).getTranslation()).divide(interpalationAmount);
					
					Vector3f rotationAmount = nextFrame.get(bone).getRotation().subtract(
							currentFrame.get(bone).getRotation()).divide(interpalationAmount);
					
					Vector3f scaleAmount = nextFrame.get(bone).getScale().subtract(
							currentFrame.get(bone).getScale()).divide(interpalationAmount);
					
					if(!frame.containsKey(bone))
						frame.put(bone, new Transform().reset());
					
					frame.get(bone).translate(transformAmount.multiply(i).add(currentFrame.get(bone).getTranslation()));
					frame.get(bone).rotate(rotationAmount.multiply(i).add(currentFrame.get(bone).getRotation()));
					frame.get(bone).scale(scaleAmount.multiply(i).add(currentFrame.get(bone).getScale()));
				}
				
				finalAnimation.addFrame(frame);
			}
		}
		
		finalAnimation.addFrame(animation.frames.get(animation.getFrameCount() - 1));
		return finalAnimation;
	}
	
/* ============================================================================================================================= */
/* =================================================== Bone ==================================================================== */	
/* ============================================================================================================================= */
	
	public static class Bone {
		private HashMap<Integer, Float> verticeWeights;
		private Transform transform;		
		private Bone parent;
		
		public Bone() {
			this(null);
		}
		
		public Bone(Bone parent) {
			verticeWeights = new HashMap<>();
			transform = new Transform();
			this.parent = parent;
		}

		public void setParent(Bone parent) { 
			this.parent = parent;
		}
		
		public void addVertice(int index, float weight) {
			verticeWeights.put(index, weight);
		}

		public float getWeight(int index) { return verticeWeights.get(index); }
		public Transform getTransform() { return transform; }
		
		public Vector3f getTranslation() { return transform.getTranslation(); }
		public Vector3f getRotation() { return transform.getRotation(); }
		public Vector3f getScale() { return transform.getScale(); }

		public void translate(Vector3f amount) { transform.translate(amount); }
		public void rotate(Vector3f amount) { transform.rotate(amount); }
		public void scale(Vector3f amount) { transform.scale(amount); }

		public void setTranslation(Vector3f translation) { transform.setTranslation(translation); }
		public void setRotation(Vector3f rotation) { transform.setRotation(rotation); }
		public void setScale(Vector3f scale) { transform.setScale(scale); }
		
		public float[] applyTransfrom(float[] vertices) {
			if(parent != null) 
				transform.transformBy(parent.getTransform());
			
			float[] result = new float[vertices.length];
			for(int i = 0; i < vertices.length; i+=3) {
				float weight = verticeWeights.containsKey(i / 3) ? verticeWeights.get(i / 3) : 0;

				Transform weightedTransform = transform.clone().weight(weight);
				if(!verticeWeights.containsKey(i / 3)) weightedTransform.setScale(new Vector3f(1));
				Vector4f vertice = new Vector4f(vertices[i + 0], vertices[i + 1], vertices[i + 2], 1);
				vertice = new Vector4f(Matrix4f.transform(weightedTransform.getTransformMatrix(), vertice.toLWJGL(), null));
				
				result[i + 0] = vertice.x;
				result[i + 1] = vertice.y;
				result[i + 2] = vertice.z;
			}
			
			
			transform.reset().setScale(new Vector3f(1));
			return result;
		}

		public HashMap<Integer, Float> getVerticeWeights() {
			return verticeWeights;
		}
	}
}
