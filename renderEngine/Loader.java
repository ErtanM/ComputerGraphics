package renderEngine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.newdawn.slick.opengl.TextureLoader;

import model.RawModel;
import model.Texture;

public class Loader {
	private List<Integer> vaos = new ArrayList<Integer>();
	private List<Integer> vbos = new ArrayList<Integer>();

public RawModel loadToVAO(float[] positions) {
		int vaoID = createVAO();  
		storeDataInAttributeList(0, positions);
		unbindVAO();
		return new RawModel (vaoID, positions.length/3);
} 

//1.	Create method createVAO() to create new empty VAO, that return the unique identifier of this VAO ( vaoID):

private int createVAO() {
		int vaoID = GL30.glGenVertexArrays();//create new empty VAO  
		vaos.add(vaoID);//add ID to the list of ID’s
		GL30.glBindVertexArray(vaoID);//activate VAO by binding it
		return vaoID;//return unique ID of the created VAO
}

//2.	Create a method, to story data in the one of the attribute list of the VAO:

private void storeDataInAttributeList (int attributeNumber, float[] data) {
	int vboID = GL15.glGenBuffers();//create an empty vbo buffer, to put 	the data
	vbos.add(vboID);//store vbo ID in the vbos list
	GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboID);//bind the vbo buffer 	and specify the type
	FloatBuffer buffer = storeDataInFloatBuffer(data);//story data into 	VBO
	GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
//create the pointer to the buffer with parameters: how many are the attributes(attributeNumber),how many point has every vertex - 3,type float,is there are normalized - false,the distance until the data - 0,begun from - 0.//
	GL20.glVertexAttribPointer(attributeNumber, 3, GL11.GL_FLOAT,false, 0,0);
	GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);//clear buffer
}

private FloatBuffer storeDataInFloatBuffer(float[] data) {
		FloatBuffer buffer =BufferUtils.createFloatBuffer(data.length);
		buffer.put(data);
		buffer.flip();
		return buffer;
	}

private void unbindVAO() {
		GL30.glBindVertexArray(0);//fill with 0, to clear
} 


public void cleanUp() {
	for(int vao:vaos) {
		GL30.glDeleteVertexArrays(vao);
	}
	
	for(int vbo:vbos) {
		GL15.glDeleteBuffers(vbo);
		}
	}
private void bindIndicesBuffer(int[] indices) {
	int vboID = GL15.glGenBuffers(); /*create a empty buffer*/
	vbos.add(vboID);
	GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, vboID);
	IntBuffer buffer = storeDataInIntBuffer(indices);
	GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
}	
private IntBuffer storeDataInIntBuffer(int[] data) {
	IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
	buffer.put(data);
	buffer.flip();
	return buffer;	
}

	public int loadTexture(String fileName){
		Texture texture = null;
		try {
	 		texture = (Texture) TextureLoader.getTexture("PNG", 
	 			new FileInputStream ("img/"+fileName+".png"));
	 	} catch (FileNotFoundException e) {
	 		
	 	} catch (IOException e){
	 		e.printStackTrace();
	 	}
	 	
	 	int textureID = texture.getTextureID();
	 	textures.add(textureID);
	 	return textureID;
	 }





}

