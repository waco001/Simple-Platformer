package com.gledx.thegreatcube;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;


import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;


public class Main {
	public static Player player;
	public static void main(String args[]) throws Exception{
		System.setProperty("org.lwjgl.librarypath",System.getProperty("user.dir") + "/lib/");
		Display.setDisplayMode(new DisplayMode(640, 480));
		Display.create();
		Display.sync(60);
		Display.setVSyncEnabled(true);
		player = new Player();
		MapEngine.loadMap();
		while(!(Display.isCloseRequested())){
			//Game Code Goes Here
			setCamera();
			MapEngine.render();
			player.draw();
			player.update();
			Display.update();
	
		}
		Display.destroy();

	}
	public static void setCamera(){
		//Clear Screen
		glClear(GL_COLOR_BUFFER_BIT);
		//set up matrix
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 640, 0, 480, -1, 1);

		//Modify modelview matrix
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();

	}

}
