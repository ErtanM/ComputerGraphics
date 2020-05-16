package renderEngine;

import org.lwjgl.util.vector.Matrix4f;

public class StaticShader extends ShaderProgram {
	private static final String VERTEX_FILE = "src/shaders/vetexShader.txt";
	private static final String FRAGMENT_FILE = "src/shaders/fragmentShader.txt";

	public StaticShader() {
		super(VERTEX_FILE, FRAGMENT_FILE);}

	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");}

	@Override
	protected void getAllUniformLocations() {
		// TODO Auto-generated method stub
		
	}

	public void loadTransformationMatrix(Matrix4f trasformationMatrix) {
		// TODO Auto-generated method stub
		
	}
}

