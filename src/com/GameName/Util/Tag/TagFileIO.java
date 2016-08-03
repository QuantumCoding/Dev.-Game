package com.GameName.Util.Tag;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import com.GameName.Util.Vectors.Vector3f;

public class TagFileIO {
	public static OutputStream getOutputStream(File f) throws IOException {
		if(!f.getAbsolutePath().endsWith(".tag")) throw new IOException("DTG files must end with \".tag\"");
		return new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(f)));
	}
	
	public static InputStream getInputStream(File f) throws IOException {
		if(!f.getAbsolutePath().endsWith(".tag")) throw new IOException("DTG files must end with \".tag\"");
		return new BufferedInputStream(new GZIPInputStream(new FileInputStream(f)));
	}
	
	public static ArrayList<TagGroup> read(InputStream input) throws IOException {
		ArrayList<TagGroup> groups = new ArrayList<>();
		byte[] amountRaw = new byte[4]; input.read(amountRaw);
		
		for(int i = 0; i < byteToInt(amountRaw); i ++) {
			byte[] countRaw = new byte[4]; input.read(countRaw);
			ArrayList<Tag> tags = new ArrayList<>();
			Tag idTag = readTag(input);
			
			for(int j = 0; j < byteToInt(countRaw); j ++) {
				tags.add(readTag(input));
			}
			
			groups.add(new TagGroup(idTag, tags.toArray(new Tag[tags.size()])));
		}
		
		input.close();
		return groups;
	}
	
	private static Tag readTag(InputStream input) throws IOException {
		String name = readSection(input);
		char type = (char) ((byte) input.read());
		String unprossedInfo = readSection(input);
		return new Tag(name, processInfo(unprossedInfo, type));
	}
	
	private static String readSection(InputStream input) throws IOException {
		byte[] lengthRaw = new byte[4]; input.read(lengthRaw);
		int length = byteToInt(lengthRaw); 
		byte[] readRaw = new byte[length]; input.read(readRaw);
		return new String(readRaw);
	}
	
	public static void write(ArrayList<TagGroup> groups, OutputStream output) throws IOException  {
		output.write(intToByte(groups.size()));
		
		for(TagGroup group : groups) {
			output.write(intToByte(group.getTags().length));
			writeTag(group.getIdTag(), output);
			
			for(Tag tag : group.getTags()) {
				writeTag(tag, output);
			}
		}
		
		output.close();
	}
	
	private static void writeTag(Tag tag, OutputStream output) throws IOException {
		String tagStringName = DTGGenerator.generateTag(tag.getName());
		byte[] tagStringNameBytes = tagStringName.substring(1).getBytes();
		
		output.write(intToByte(tagStringNameBytes.length)); 
		output.write(tagStringNameBytes);
		
		String tagStringInfo = DTGGenerator.generateTag(tag.getInfo());
		byte[] tagStringInfoBytes = tagStringInfo.substring(1).getBytes();
		
		output.write(new byte[] {(byte) tagStringInfo.charAt(0)});
		output.write(intToByte(tagStringInfoBytes.length)); 
		output.write(tagStringInfoBytes);
	}
	
	private static byte[] intToByte(int in) {
		return new byte[] {
			(byte) (in & 0x000000FF), (byte) (in & 0x0000FF00),
			(byte) (in & 0x00FF0000), (byte) (in & 0xFF000000)
		};
	}
	
	private static int byteToInt(byte[] in) {
		if(in.length != 4) throw new IllegalArgumentException("Byte array must contain only 4 bytes");
		return in[0] << 0 | in[1] << 8 | in[2] << 16 | in[3] << 24;
	}
	
	private static Object processInfo(String in, char infoType) {
		if(in.isEmpty()) return null;
				
		switch(infoType) {
			case 'S': return in;
			
			case 'b': return Byte.parseByte(in);
			case 's': return Short.parseShort(in);
			case 'i': return Integer.parseInt(in);
			case 'l': return Long.parseLong(in);
			
			case 'f': return Float.parseFloat(in);
			case 'd': return Double.parseDouble(in);

			case 'c': return in.charAt(0);
			case 'B': return Boolean.parseBoolean(in);
						
			case 'A': return processArray(in);
			case 'V': return processVector(in);
			
			default: return null;
		}
	}
	
	private static Object processArray(String in) {
		char arrayType = in.charAt(0);
		in = in.substring(1, in.length());
		if(in.isEmpty()) return null;
		
		String[] elements = in.split(",");	
		switch(arrayType) {
			case 'S': return elements;
			
			case 'b': Byte[] arrayb = new Byte[elements.length]; 		for(int i = 0; i < elements.length; i ++) arrayb[i] = Byte.parseByte(elements[i]); return arrayb;
			case 's': Short[] arrays = new Short[elements.length]; 		for(int i = 0; i < elements.length; i ++) arrays[i] = Short.parseShort(elements[i]); return arrays;
			case 'i': Integer[] arrayi = new Integer[elements.length]; 	for(int i = 0; i < elements.length; i ++) arrayi[i] = Integer.parseInt(elements[i]); return arrayi;
			case 'l': Long[] arrayl = new Long[elements.length]; 		for(int i = 0; i < elements.length; i ++) arrayl[i] = Long.parseLong(elements[i]); return arrayl;
			
			case 'f': Float[] arrayf = new Float[elements.length]; 		for(int i = 0; i < elements.length; i ++) arrayf[i] = Float.parseFloat(elements[i]); return arrayf;  
			case 'd': Double[] arrayd = new Double[elements.length];	for(int i = 0; i < elements.length; i ++) arrayd[i] = Double.parseDouble(elements[i]); return arrayd;
			
			case 'c': Character[] arrayc = new Character[elements.length]; 	for(int i = 0; i < elements.length; i ++) arrayc[i] = in.charAt(0); return arrayc;  
			case 'B': Boolean[] arrayB = new Boolean[elements.length];		for(int i = 0; i < elements.length; i ++) arrayB[i] = Boolean.parseBoolean(elements[i]); return arrayB;
			
			default: return null;
		}
	}
	
	private static Object processVector(String in) {	
		if(in.isEmpty()) return null;
		
		String[] numbers = in.split(",");		
		return new Vector3f(Float.parseFloat(numbers[0]), Float.parseFloat(numbers[1]), Float.parseFloat(numbers[2]));
	}
}
