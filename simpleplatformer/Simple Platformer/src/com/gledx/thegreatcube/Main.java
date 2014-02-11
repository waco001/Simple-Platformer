package com.gledx.thegreatcube;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import com.gledx.thegreatcube.gameobjects.entities.Player;


public class Main {
	public static int WINDOW_WIDTH;
	public static int WINDOW_HEIGHT;
	private static MapManager mapManager;
	public static Player player = new Player();

	public static void main(String args[]) throws Exception{
		init();
		Display.setDisplayMode(new DisplayMode(mapManager.tileToPixel(WINDOW_WIDTH), mapManager.tileToPixel(WINDOW_HEIGHT)));
		Display.setInitialBackground(0.5f, 1.0f, 1.0f);
		Display.sync(60);
		Display.setVSyncEnabled(true);
		Display.create();
		setCamera();
		while(!(Display.isCloseRequested())){
			//Game Code Goes Here
			{
				MapManager.render();
				player.render();
			}
			{
				player.update();
				Display.update();
				glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);  
			}
		}
		Display.destroy();

	}
	private static void init() {
		System.setProperty("org.lwjgl.librarypath",System.getProperty("user.dir") + "/lib/");
		mapManager  = new MapManager();
		WINDOW_WIDTH = 40;
		WINDOW_HEIGHT = 30;
		MapManager.loadMap();
		Keyboard.enableRepeatEvents(true);
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
