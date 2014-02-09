package com.gledx.thegreatcube;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glVertex2d;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;


public class Tile {
	public int size;
	public double x;
	public double y;
	private static final int BLOCK_EMPTY = 0;
	private static final int BLOCK_RED = 1;
	private static final int BLOCK_BLUE = 2;
	private static final int BLOCK_GREEN = 3;

	private float r;
	private float g;
	private float b;

	public int currentBlock;
	public Tile(double x, double y, int type){
		this.x = x;
		this.y = y;
		this.size = 32;
		this.currentBlock = type;
	}
	public void render(){
		setRGB();
		glPushMatrix();
		glColor3f(r, g, b);
		{
			glBegin(GL_QUADS);
			glVertex2d(x, y);
			glVertex2d(x + size, y);
			glVertex2d(x + size, y + size);
			glVertex2d(x, y + size);
			glEnd();
		}
		glPopMatrix();
	}
	public void setRGB(){
		switch(currentBlock){
		case 0:
			this.r = 0.0f;
			this.g = 0.0f;
			this.b = 0.0f;
			break;
		case 1:
			this.r = 1.0f;
			this.g = 0.0f;
			this.b = 0.0f;
			break;
		case 2: 
			this.r = 0.0f;
			this.g = 0.0f;
			this.b = 1.0f;	
			break;
		case 3:
			this.r = 0.0f;
			this.g = 1.0f;
			this.b = 0.0f;
		}
	}
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 32, 32);
	}
}
