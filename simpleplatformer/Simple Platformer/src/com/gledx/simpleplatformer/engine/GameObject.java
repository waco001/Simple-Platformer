package com.gledx.simpleplatformer.engine;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;

import java.awt.Point;

public abstract class GameObject {
	protected Point loc;
	protected int velocityX;
	protected int velocityY;
	protected Sprite spr;
	public static final int tile_size = 16;

	public void init(int x, int y, float r, float g, float b){
		loc = new Point(x, y);
		spr = new Sprite(r, g, b, tile_size, tile_size);
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

	}
}
