package model;

public class Texture {
	private int textureID;

	public Texture(int textureID) {
		this.textureID = textureID;
	}
	public int getTextureID() {
		return textureID;
	}
	
	public class TexturedModel {
		private RawModel rawModel;
		private Texture texture;

		public TexturedModel(RawModel rawModel, Texture texture) {
			this.rawModel = rawModel;
			this.texture = texture;
		}
		public RawModel getRawModel() {
			return rawModel;
		}
		public Texture getTexture() {
			return texture;
		}
	}

}

