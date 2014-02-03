package com.gledx.simpleplatformer.engine;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Color;

public abstract class GameObject {
	protected Point loc;
	protected int velocityX;
	protected int velocityY;
	protected Sprite spr;
	protected Rectangle hitBox;

	public void init(int x, int y, float r, float g, float b, int sx, int sy){
		loc = new Point(x, y);
		spr = new Sprite(r, g, b, sx, sy);
	}
	public void init(int x, int y, Color c, int sx, int sy){
		loc = new Point(x, y);
		spr = new Sprite(c, sx, sy);
	}
	public float getX() {
		return this.loc.x;
	}
	public void setX(int x) {
		this.loc.x = x;
	}
	public float getY() {
		return this.loc.y;
	}
	public void setY(int y) {
		this.loc.y = y;
	}

	public float getSy() {
		return spr.getSy();
	}
	
	public float getsSx() {
		return spr.getSx();
	}
	
	public void update(){

	}
	public void render(){
		glPushMatrix();
		{
			glTranslatef(this.loc.x, this.loc.y, 0);
			spr.render();
		}
		glPopMatrix();
		System.out.print(loc.x + " ");
		System.out.println(loc.y);
	}
}
