package engineTester;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

import model.RawModel;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.Render;
import renderEngine.StaticShader;

public class MainGameLoop {
	public static void main(String[] args) {
		try {
			DisplayManager.createDisplay();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Loader loader = new Loader();
		Render render = new Render();
		StaticShader shader = new StaticShader();
		
		float[] vertices = {
				-0.5f,  0.5f, 0, //V0
				-0.5f, -0.5f, 0, //V1
				 0.5f, -0.5f, 0, //V2
				 0.5f,  0.5f, 0  //V3
		};
		int[] indices = {
				0,1,3, //top left triangle (V0,V1,V3)
				3,1,2 //bottom right triangle (V3,V1,V2)
		};
		RawModel model = loader.loadToVAO(vertices);
		
		while(!Display.isCloseRequested()) {
			render.prepare();
			shader.start();
			// game logic
			render.render(model);
			shader.stop();
			DisplayManager.updateDisplay();
		}
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}
}
