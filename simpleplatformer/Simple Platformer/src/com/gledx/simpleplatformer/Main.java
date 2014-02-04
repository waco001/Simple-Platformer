package com.gledx.simpleplatformer;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import com.gledx.simpleplatformer.engine.Camera;
import com.gledx.simpleplatformer.game.Game;

public class Main {
	private static Game game;
	private static int targetFPS = 15;
	public static int windowWidth = 800;
	public static int windowHeight = 800;
	enum gamestate { GAME_LOADING, GAME_PLAY, GAME_EXIT };
	gamestate gameState;
	public static void main(String[] args){
		System.setProperty("org.lwjgl.librarypath",System.getProperty("user.dir") + "/lib/");
		initDisplay();
		initGL();
		initGame();
		gameloop();
		cleanup();

	}
	private static void initGame() {
		// TODO Auto-generated method stub
		game = new Game();
		Keyboard.enableRepeatEvents(true); //Hold down keys

	}
	private static void cleanup() {
		// TODO Auto-generated method stub
		Display.destroy();
		Keyboard.destroy();
	}
	private static void gameloop(){
		while(Display.isCloseRequested() != true){
			getInput();
			update();
			render();
		}
		System.exit(0);
	}

	private static void update() {
		// TODO Auto-generated method stub
		game.update();

	}
	private static void getInput() {
		// TODO Auto-generated method stub
		game.getInput();

	}
	private static void render() {
		// TODO Auto-generated method stub
		
		glClear(GL_COLOR_BUFFER_BIT);
		// Put another matrix, a clone of the current one, on the matrix stack.
		glPushMatrix();
		Camera.translate();
		//Draw
		game.render();
		// Dispose of the translations on the matrix.
		glPopMatrix();
		Display.update();
		Display.sync(targetFPS);
	}
	private static void initGL(){
		// Set-up an orthographic presentation where (0, 0) is the upper-left corner and (640, 480) is the bottom right one.
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, windowWidth, windowHeight, 0, -1, 1);
		glMatrixMode(GL_MODELVIEW);

		glDisable(GL_DEPTH_TEST);

		glClearColor(1, 1, 1, 0);
	}
	private static void initDisplay(){
		try {
			//Display.setDisplayMode(new DisplayMode(Map.roundToMultiple(windowWidth, Map.tileSize),Map.roundToMultiple(windowHeight, Map.tileSize)));
			Display.setTitle("The Great Cube");
			Display.setDisplayMode(new DisplayMode(windowWidth, windowHeight));
			Display.setResizable(true);
			Display.create();
			Display.setVSyncEnabled(true);
			Keyboard.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
