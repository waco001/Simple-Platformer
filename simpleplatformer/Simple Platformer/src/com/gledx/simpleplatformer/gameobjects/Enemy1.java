package com.gledx.simpleplatformer.gameobjects;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;
import java.util.Random;

import java.awt.Color;
import java.awt.Point;

import com.gledx.simpleplatformer.engine.GameObject;
import com.gledx.simpleplatformer.engine.Sprite;

public class Enemy1 extends GameObject{

	protected Point coords;
	protected Sprite spr;
	private int newx;
	private int newy;
	public Enemy1(int i, int j) {
		init(i, j, 0.0f, 0.8f, 1.45f, 16, 16);
	}
	
	public void init(int x, int y, Color c, int sx, int sy){
		coords = new Point(x, y);
		spr = new Sprite(c, sx, sy);
	}
	public float getX() {
		return this.coords.x;
	}
	public void setX(int x) {
		this.coords.x = x;
	}
	public float getY() {
		return this.coords.y;
	}
	public void setY(int y) {
		this.coords.y = y;
	}

	public float getSy() {
		return spr.getSy();
	}
	
	public float getsSx() {
		return spr.getSx();
	}

	public void update(){
		Random randomGenerator = new Random();
		int newx = randomGenerator.nextInt(10);
		int newxsign= randomGenerator.nextInt(2);
		if (newxsign==1){
			newx=newx; }
		if (newxsign==0)
		{newx=-newx;}
		coords.x+=newx;
		
	}
	public void render(){
		glPushMatrix();
		{
			glTranslatef(this.coords.x, this.coords.y, 0);
			spr.render();
		}
		glPopMatrix();
		System.out.print(loc.x + " ");
		System.out.println(loc.y);
	}
}
