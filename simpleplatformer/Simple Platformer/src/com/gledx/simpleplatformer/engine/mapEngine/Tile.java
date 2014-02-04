package com.gledx.simpleplatformer.engine.mapEngine;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import com.gledx.simpleplatformer.engine.Point;

public class Tile {
	public Point point;
	public int width;
	public int height;
	public static enum tiletype { BLOCK_AIR, BLOCK_WALL, BLOCK_GROUND, BLOCK_LAVA }
	public tiletype tileType;
	public Tile(Point point1, int width, int height, tiletype type){
		tileType = type;
		this.width = width;
		this.height = height;
		this.point = point1;
	}
	public void render(){
		//DRY WAY
		float r, g, b;
		switch(tileType){
		case BLOCK_LAVA:
			r = 1.0f;
			g = 0.8f;
			b = 0.45f;
			break;
		case BLOCK_WALL:
			r = 0.0f;
			g = 0.8f;
			b = 1.45f;
			break;
		case BLOCK_GROUND:
			r = 0.0f;
			g = 1.0f;
			b = 0.0f;
			break;
		case BLOCK_AIR:
		default:
			r = 0.0f;
			g = 0.0f;
			b = 0.0f;
			break;
		}
		glBegin(GL_QUADS);
		{
			glColor3f(r, g, b);
			glVertex2f(point.getX(), point.getY());
			glVertex2f(point.getX(), point.getY() + height);
			glVertex2f(point.getX() + width, point.getY() + height);
			glVertex2f(point.getX() + width, point.getY());
		}
		glEnd();
	}

}
