package com.gledx.thegreatcube.gameobjects;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;

import java.awt.Point;

import com.gledx.thegreatcube.Sprite;

public abstract class GameObject {
	protected Point loc;
	protected Sprite spr;
	protected boolean debug = false;
	public GameObject(int x, int y, float r, float g, float b){
		this.loc = new Point();
		this.loc.x = x;
		this.loc.y = y;
		this.spr = new Sprite(x, y, r, g, b);
	}
	public void render(){
		glPushMatrix();
		{
			//glTranslatef(this.loc.x, this.loc.y, 0);
			spr.render();
		}
		glPopMatrix();
	}
}
