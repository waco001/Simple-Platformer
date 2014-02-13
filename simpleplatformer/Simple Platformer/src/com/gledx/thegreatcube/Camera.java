package com.gledx.thegreatcube;

import static org.lwjgl.opengl.GL11.glTranslatef;

import org.lwjgl.util.Rectangle;

public class Camera {
	Rectangle viewport = new Rectangle(0, 0, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
	public static int translate_x = 0;
	public static void render(){
		glTranslatef(MapManager.tileToPixel(translate_x), 0, 0);
		translate_x = 0;
	}
}
