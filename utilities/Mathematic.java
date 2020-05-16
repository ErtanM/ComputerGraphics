package utilities;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

public class Mathematic {
	
	public static Matrix4f createTransformation(Vector3f translation, //translation
										float rx, float ry, float rz, // rotation
										float scale) { //scale
		Matrix4f matrix = new Matrix4f(); //create a new empty matrix
		matrix.setIdentity();//set this matrix to the identity matrix
		Matrix4f.translate(translation, matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(rx), new Vector3f(1,0,0), matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(ry), new Vector3f(0,1,0), matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(rz), new Vector3f(0,0,1), matrix, matrix);
		Matrix4f.scale(new Vector3f(scale, scale, scale), matrix, matrix);
		return matrix;
	}
}
