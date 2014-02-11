package com.gledx.thegreatcube;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2i;

public class Sprite {
	private float r;
	private float g;
	private float b;
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = MapManager.tileToPixel(x);
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = MapManager.tileToPixel(y);
	}

	public Sprite(int x, int y, float r, float g, float b) {
		this.x = MapManager.tileToPixel(x);
		this.y = MapManager.tileToPixel(y);
		this.r = r;
		this.g = g;
		this.b = b;
		
	}

	
	public void render(){
		glBegin(GL_QUADS);
		{
			glColor3f(r, g, b);
			glVertex2i(x , y);
			glVertex2i(x , y + MapManager.MAP_TILE_SIZE);
			glVertex2i(x + MapManager.MAP_TILE_SIZE, y + MapManager.MAP_TILE_SIZE);
			glVertex2i(x + MapManager.MAP_TILE_SIZE, y);
		}
		glEnd();
		
	}
}
