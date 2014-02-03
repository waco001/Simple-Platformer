package com.gledx.simpleplatformer.engine;

import org.lwjgl.opengl.GL11;



public class Tile{

	private float r;
	private float g;
	private float b;
	private int x;
	private int y;

	public Tile(float r, float g, float b, int x, int y){
		this.r = r;
		this.g = g;
		this.b = b;
		this.x = x;
		this.y = y;
	}
	public void render(){
		GL11.glColor3f(r, g, b);
		// draw quad
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2i(x, y + Map.tileSize);
		GL11.glVertex2i(x, y);
		GL11.glVertex2i(x + Map.tileSize, y);
		GL11.glVertex2i(x + Map.tileSize, y + Map.tileSize);

		GL11.glEnd();
		
	}

}
