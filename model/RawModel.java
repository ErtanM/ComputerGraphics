package model;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import model.RawModel;





public class RawModel {
	private int vaoID; 
	private int vetexCount;
	
//constructor
	public RawModel(int vaoID, int vertexCount) {
		int vaoID = createVAO();
		bindIndicesBuffer(indices);
		storeDataInAttributeList(0,3, positions);
		//store 2 size texture cords in position 1 
		storeDataInAttributeList(1,2, textureCoords); 
		unbindVAO();
		return new RawModel (vaoID, indices.length);

	}
	public int getVaoID() {
		return vaoID;
	}
	
	public int getVetexCount() {
		return vetexCount;
	}
	public int getVetexCount1() {
		// TODO Auto-generated method stub
		return 0;
	}

}
