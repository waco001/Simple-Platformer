package com.gledx.simpleplatformer.engine;

import static org.lwjgl.opengl.GL11.*;

import java.awt.Color;

public class Sprite {
	private float r;

	private float g;

	public float getSx() {
		return sx;
	}

	public void setSx(float sx) {
		this.sx = sx;
	}

	public float getSy() {
		return sy;
	}

	public void setSy(float sy) {
		this.sy = sy;
	}
	private float b;
	public Sprite(float r, float g, float b, float sx, float sy) {
		super();
		this.r = r;
		this.g = g;
		this.b = b;
		this.sx = sx;
		this.sy = sy;
	}
	public Sprite(Color c, int sx2, int sy2) {
		// TODO Auto-generated constructor stub
		this.r = c.getRed();
		this.g = c.getGreen();
		this.b = c.getBlue();
		this.sx = sx2;
		this.sy = sy2;
	}
	private float sx;
	private float sy;
	
	public void render(){
		glBegin(GL_QUADS);
		{
			glColor3f(r, g, b);
			glVertex2f(0,0);
			glVertex2f(0, sy);
			glVertex2f(sx,sy);
			glVertex2f(sx, 0);
		}
		glEnd();
		
	}
}
