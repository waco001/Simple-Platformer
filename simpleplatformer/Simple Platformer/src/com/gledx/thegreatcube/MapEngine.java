package com.gledx.thegreatcube;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3d;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2d;

import java.util.ArrayList;

@SuppressWarnings("unused")

public class MapEngine {
	//Temp tiles
	
	
	public static ArrayList<Tile> tileMap = new ArrayList<Tile>();
	
	//Position
	public double x;
	public double y;

	public static void render(){
		drawBackground();
		{
			//Render all Tiles
			for(Tile t : tileMap){
				t.render();
			}
		}
	}

	private static void drawBackground() {
		// TODO Auto-generated method stub
		
		
		glPushMatrix();

		glBegin(GL_QUADS);

		glColor3d(0.7, 0.8, 0.9);
		glVertex2d(0,0);
		glVertex2d(640, 0);

		glColor3d(0.5, 0.6, 1.0);
		glVertex2d(640,480);
		glVertex2d(0, 480);

		glEnd();
		//Draw Ground
		
		glBegin(GL_QUADS);
		glColor3d(0.6, 0.2, 0.1);
		glVertex2d(0, 0);
		glVertex2d(640, 0);
		glVertex2d(640, 32);
		glVertex2d(0, 32);
		glEnd();
		
		//Draw Grass
		
		glBegin(GL_QUADS);
		glColor3d(0.2, 0.8, 0.2);
		glVertex2d(0, 25);
		glVertex2d(640, 25);
		glVertex2d(640, 32);
		glVertex2d(0, 32);
		glEnd();
		glPopMatrix();
	}
	public static void loadMap(){
		tileMap.add(new Tile(50, 32, 1));
		tileMap.add(new Tile(82, 32, 1));
		tileMap.add(new Tile(82, 64, 1));
	}
	// Translation along the x-axis
	public static float translate_x = 0;	//<-- If we wanted it to not align with player
	public static float translate_y = 0;	//<-- If we wanted it to not align with player
	public static void translate(){
		glTranslatef(translate_x, translate_y, 0);
	}
}
