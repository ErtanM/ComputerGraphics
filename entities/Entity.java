package entities;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import model.RawModel;
import model.TexturedModel;
import renderEngine.StaticShader;
import utilities.Mathematic;

public class Entity {
	
	private TexturedModel model;
	private Vector3f position;
	private float rotX, rotY, rotZ;
	private float scale;

	// constructor
	public Entity(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		this.model = model;
		this.position = position;
		this.rotX = rotX;
		this.rotY = rotY;
		this.rotZ = rotZ;
		this.scale = scale;
	}
	public void changePosition(float dx, float dy, float dz) { // translation
		this.position.x += dx;
		this.position.y += dy;
		this.position.z += dz;
	}
	public void rotateEntity(float dx, float dy, float dz) { // rotation
		this.rotX += dx;
		this.rotY += dy;
		this.rotZ += dz;
	}
	public TexturedModel getModel() {
		return model;
	}
	public void setModel(TexturedModel model) {
		this.model = model;
	}
	public Vector3f getPosition() {
		return position;
	}
	public void setPosition(Vector3f position) {
		this.position = position;
	}
	public float getRotX() {
		return rotX;
	}
	public void setRotX(float rotX) {
		this.rotX = rotX;
	}
	public float getRotY() {
		return rotY;
	}
	public void setRotY(float rotY) {
		this.rotY = rotY;
	}
	public float getRotZ() {
		return rotZ;
	}
	public void setRotZ(float rotZ) {
		this.rotZ = rotZ;
	}
	public float getScale() {
		return scale;
	}
	public void setScale(float scale) {
		this.scale = scale;
	}
	
		/* render function for entity */
		public void render(Entity entity, StaticShader shader){
		 	 TexturedModel model = entity.getModel();
		 	 RawModel rawModel = model.getRawModel();
			 GL30.glBindVertexArray(rawModel.getVaoID());
			 GL20.glEnableVertexAttribArray(0);
			 GL20.glEnableVertexAttribArray(1);
			 Matrix4f trasformationMatrix = Mathematic.createTransformation(entity.getPosition(), 
			 entity.getRotX(), entity.getRotY(), entity.getRotZ(), entity.getScale());
			 shader.loadTransformationMatrix(trasformationMatrix);
			 GL13.glActiveTexture(GL13.GL_TEXTURE0);
			 GL11.glBindTexture(GL11.GL_TEXTURE_2D, model.getTexture().getID());
			 GL11.glDrawElements(GL11.GL_TRIANGLES,rawModel.getVetexCount(),
			 GL11.GL_UNSIGNED_INT,0);
			 GL20.glDisableVertexAttribArray(0);
			 GL20.glDisableVertexAttribArray(1);
			 GL30.glBindVertexArray(0);
			 GL30.glBindVertexArray(1);

}

		
}
		
		