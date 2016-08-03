package com.GameName.Cube;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

import com.GameName.Cube.Collision.DefaultCubeCollisionBox;
import com.GameName.Cube.Collision.ICubeCollisionBox;
import com.GameName.Cube.Render.DefaultCubeRender;
import com.GameName.Cube.Render.ICubeRender;
import com.GameName.Registry.Registries.CubeRegistry;
import com.GameName.RenderEngine.Models.SBModel.SBModelLoader;
import com.GameName.RenderEngine.Textures.Texture;
import com.GameName.RenderEngine.Textures.Texture2D;
import com.GameName.RenderEngine.Textures.TextureMap;
import com.GameName.RenderEngine.Util.RenderProperties;
import com.GameName.Util.Side;
import com.GameName.Util.Vectors.Vector2f;

public class Cube {
	private static DefaultCubeRender defaultCubeRender;
	private static final BufferedImage DEFAULT_TEXTURE;
	private static final TextureMap DEFUALT_TEXTURE_SHEET;
	private static int nextId;
	
	static {
		try {
			defaultCubeRender = new DefaultCubeRender(SBModelLoader.loadSBM(new File("res/models/TexturedCube.sbm")));
		} catch(IOException e) { e.printStackTrace(); }
		
		DEFUALT_TEXTURE_SHEET = new TextureMap();
		DEFAULT_TEXTURE = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		
		int i = 0;
		for(int x = 0; x < DEFAULT_TEXTURE.getWidth(); x ++) {
		for(int y = 0; y < DEFAULT_TEXTURE.getHeight(); y ++) {
			DEFAULT_TEXTURE.setRGB(x, y, ((++ i) + (x%2)) % 2 == 0 ? Color.BLACK.getRGB() : Color.ORANGE.getRGB());
		}}
		
		try {
			ImageIO.write(DEFAULT_TEXTURE, "PNG", new File("C:\\Users\\Joshua\\Desktop\\DefaultTexture.png"));
		} catch(IOException e) { e.printStackTrace(); }
	}
	
	private String name;
	private String displayName;
	private int id;
	
//	private Material material;
	private ICubeRender render;
	private ICubeCollisionBox collisionBox;
	private RenderProperties renderProperties;
	private TextureMap textureSheet;
	
	/** Texture Colors: Frame */
	private Texture[] texture;
	private int frames;

	private ArrayList<Vector2f[]> texturePositions;
	private File textureLocation;
	
	private boolean isLightSorce;
	private float lightValue;
	private float[] lightColor;
	
	private boolean isSolid;
	private boolean isLiquid;
	private boolean isOpaque;
	private boolean isVisable;
	private float opacity;
	
	protected Cube(String name) {
		this.name = name;
		setDisplayName(name);
		
		setOpaque(true);
		setLiquid(false);
		setVisable(true);
		setOpacity(1f);
		
		setLightSorce(false);
		setLightValue(0f);
		
		setCollisionBox(getCollisionBox());
//		setMaterial(Materials.Stone);
		setRender(getDefaultRender());
		setTextureSheet(getDefaultTextureSheet());
//		setRenderProperties(de); //getDefaultRenderProperties()
		
		loadExtraInfo();
		texture = loadTextures();
	}

	/**
	 * 	Loads all extra information about this cube
	 */	
	private void loadExtraInfo() {
		File extraInfo = new File("res/textures/cubes/info/" + name + ".tag");
		texturePositions = new ArrayList<>();
		
		//TODO: Add animated Textures	 -- Needs testing
		//TODO: Add texture sheet loader -- Needs testing
		
		textureLocation = null; 
		frames = 0;
		
		if(!extraInfo.exists()) {
			textureLocation = new File("res/textures/cubes/" + name + ".png");
			frames = 1; texturePositions.add(new Vector2f[] {new Vector2f(), new Vector2f(1)});
			
			return;
		}
		
		try {
//			ArrayList<TagGroup> info = TagFileIO.read(TagFileIO.getInputStream(extraInfo));
			
			Scanner scan = new Scanner(new File("res/textures/cubes/info/" + name + ".txt"));
			while(scan.hasNextFloat()) {
				texturePositions.add(new Vector2f[] {
					new Vector2f(scan.nextFloat(), scan.nextFloat()), // Positions
					new Vector2f(scan.nextFloat(), scan.nextFloat()), // Size
				});
			} scan.close();
			
//			for(TagGroup group : info) {
//				if(group.getIdTag().getInfo().equals("textureData")) {
//					
//				} else if(group.getIdTag().getInfo().equals("textureSheet")) {
//					
//					if(group.containsTag("sheetName")) {
//						textureLocation = new File("res/textures/cubes/" + 
//							(String) group.getTagByName("sheetName").getInfo() + ".png");
//					}
//					
//				} else if(group.getIdTag().getInfo().equals("textureRenderInfo")) {
//					
//					
//				} else if(group.getIdTag().getInfo().equals("textureAnimation")) {
//					
//				}
//			}
			
			if(textureLocation == null) textureLocation = new File("res/textures/cubes/" + name + ".png");
			frames = texturePositions.size();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	/**
	 * 	Loads the textures for this cube (CubesFaces, AnimationFrames, ex.)
	 */	
	private Texture[] loadTextures() { 
		try {
			Texture2D[] textures = new Texture2D[frames];
			BufferedImage fullTexture = ImageIO.read(textureLocation);
			if(fullTexture == null) throw new IOException("Texture == NULL");

			for(int frame = 0; frame < frames; frame ++) {
				Vector2f pos = texturePositions.get(frame)[0];
				Vector2f size = texturePositions.get(frame)[1].multiply(fullTexture.getWidth(), fullTexture.getHeight());
				
				textures[frame] = new Texture2D(
					fullTexture.getSubimage((int) pos.getX(), (int) pos.getY(), (int) size.getX(), (int) size.getY()));
			}
			
			return textures;
			
		} catch(IOException e) {
			System.err.println("The texture for " + name + " was not found or successfully loaded");
			Texture2D[] textures = new Texture2D[frames];
			
			for(int frame = 0; frame < frames; frame ++) {
			for(int i = 0; i < Side.values().length; i ++) {
				textures[frame] = new Texture2D(DEFAULT_TEXTURE);
			}}
			
			return textures;
		}
	}
	
	/**
	 * 	Returns the default CollisionBox
	 */		
	private ICubeCollisionBox getCollisionBox() {
		return new DefaultCubeCollisionBox();
	}
	
	/**
	 *  Generates the default render for a Cube
	 */
	private static ICubeRender getDefaultRender() {
		return defaultCubeRender;
	}
	
	/**
	 *  Returns the default TextureSheet for a Cube
	 */
	public static TextureMap getDefaultTextureSheet() {
		return DEFUALT_TEXTURE_SHEET;
	}
	
	/**
	 * 	Registers the cube with a unique ID
	 */	
	public void concludeInit() {		
		setId(nextId ++);
	}
		
	
	/**
	 * 	Returns the cube's basic information as a String
	 */	
	public String toString() {
		return name + " [Id=" + id + ", DisplayName=" + displayName + "]";
	} 
	
	/**
	 * Returns the name of this cube
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the name that this cube displays in game
	 * @param metadata The metadata of the cube	
	 */
	public String getDisplayName(int metadata) {
		return displayName;
	}

	/**
	 * Returns the id of this cube
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns all the possible textures of this cube <br>
	 * 			Frame, Face
	 */
	public Texture[] getTextures() {
		return texture;
	}

	/**
	 * Returns whether this cube emits light
	 * @param metadata The metadata of the cube	
	 */
	public boolean isLightSorce(int metadata) {
		return isLightSorce;
	}

	/**
	 * Returns the intensity of the light this cube emits
	 * @param metadata The metadata of the cube	
	 */
	public float getLightValue(int metadata) {
		return lightValue;
	}

	/**
	 * Returns the light color this cube emits
	 * @param metadata The metadata of the cube	
	 */
	public float[] getLightColor(int metadata) {
		return lightColor;
	}

	/**
	 * Returns if this cube is opaque
	 * @param metadata The metadata of the cube	
	 */
	public boolean isOpaque(int metadata) {
		return isOpaque;
	}
	
	/**
	 * Returns if this cube can be collided with
	 * @param metadata The metadata of the cube	
	 */
	public boolean isSolid(int metadata) {
		return isSolid;
	}
	
	/**
	 * Returns if this cube is a liquid
	 * @param metadata The metadata of the cube	
	 */
	public boolean isLiquid(int metadata) {
		return isLiquid;
	}

	/**
	 * Returns if this cube can be rendered
	 * @param metadata The metadata of the cube	
	 */
	public boolean isVisable(int metadata) {
		return isVisable;
	}

	/**
	 * Returns the opacity of this cube
	 * @param metadata The metadata of the cube	
	 */
	public float getOpacity(int metadata) {
		return opacity;
	}
	
	/**
	 * Returns the number of Frames this cube has	
	 */
	public int getFrames() {
		return frames;
	}
	
	/**
	 * Returns the Frame ID from metadata
	 * @param metadata The metadata of the cube
	 */
	public int getFrameFromMetadata(int metadata) {
		return 0;
	}
	
	/**
	 * Returns the CollisionBox for this cube
	 * @param metadata The metadata of the cube	
	 */
	public ICubeCollisionBox getCollisionBox(int metadata) {
		return collisionBox;
	}
	
	/**
	 * Returns the render for this cube
	 * @param metadata The metadata of the cube
	 */
	public ICubeRender getRender(int metadata) {
		return render;
	}
	
	/**
	 * Returns the TextureSheet for this cube
	 * @param metadata The metadata of the cube
	 */
	public TextureMap getTextureSheet(int metadata) {
		return textureSheet;
	}
	
	/**
	 * Returns the RenderProperties for this cube
	 * @param metadata The metadata of the cube
	 */
	public RenderProperties getRenderProperties(int metadata) {
		return renderProperties;
	}
	
	/**
	 * Returns the Material for this cube
	 * @param metadata The metadata of the cube
	 */
//	public Material getMaterial(int metadata) {
//		return material;
//	}
	
	/**
	 * 	Sets whether or not this cube emits light
	 */	
	protected void setLightSorce(boolean isLightSorce) {
		this.isLightSorce = isLightSorce;
	}

	/**
	 * 	Sets the intensity of the light that this cube emits
	 */	
	protected void setLightValue(float lightValue) {
		this.lightValue = lightValue;
	}

	/**
	 * 	Sets the color of light that this cube will emit 
	 */	
	protected void setLightColor(float[] lightColor) {
		this.lightColor = lightColor;
	}

	/**
	 * 	Sets whether or not this cube is opaque
	 */	
	protected void setOpaque(boolean isOpaque) {
		this.isOpaque = isOpaque;
	}
	
	/**
	 * 	Sets whether or not this cube is solid (Used for Physics)
	 */	
	protected void setSolid(boolean isSolid) {
		this.isSolid = isSolid;
	}
	
	
	/**
	 * 	Sets whether or not this cube is a liquid (Used for Physics)
	 */	
	protected void setLiquid(boolean isLiquid) {
		this.isLiquid = isLiquid;
	}

	/**
	 * 	Sets whether or not this cube should be rendered
	 */	
	protected void setVisable(boolean isVisable) {
		this.isVisable = isVisable;
	}
	
	/**
	 * 	Sets the Opacity for this cube
	 */	
	protected void setOpacity(float opacity) {
		this.opacity = opacity;
	}
	
	/**
	 * 	Sets the name that will be displayed in game for this cube
	 */	
	protected void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	/**
	 * 	Sets the CollisionBox for this cube
	 */	
	protected void setCollisionBox(ICubeCollisionBox collisionBox) {
		this.collisionBox = collisionBox;
	}

	/**
	 *  Sets the Render for this cube
	 */
	protected void setRender(ICubeRender render) {
		this.render = render;
	}
	
	/**
	 *  Sets the Texture Sheet for this cube
	 */
	protected void setTextureSheet(TextureMap textureSheet) {
		this.textureSheet = textureSheet;
	}
	
	/**
	 *  Sets the RenderProperties for this cube
	 */
	protected void setRenderProperties(RenderProperties renderProperties) {
		this.renderProperties = renderProperties;
	}
	
	/**
	 *  Sets the Material for this cube
	 */
//	protected void setMaterial(Material material) {
//		this.material = material;
//	}
	
	/**
	 * 	Sets the ID of this cube
	 */	
	private void setId(int id) {
		this.id = id;
	}

	/**
	 * 	Returns a cube based on its ID
	 * 	If the ID is -1 it returns NULL
	 */	
	public static Cube getCubeByID(int id) {
		if(id == -1) return null;
		return CubeRegistry.getCubes()[id];
	}
	
	/**
	 * 	Returns a cube array based on a set of id's
	 */	
	public static Cube[] getCubesByID(int... ids) {
		Cube[] cubes = new Cube[ids.length];
		
		for(int i = 0; i < ids.length; i ++) {
			cubes[i] = getCubeByID(ids[i]);
		}
		
		return cubes;
	}

	/**
	 * 	Returns an array of all cubes
	 */	
	public static Cube[] getCubes() {
		return CubeRegistry.getCubes();
	}
		
	public static void cleanUp() {
		
	}
}
