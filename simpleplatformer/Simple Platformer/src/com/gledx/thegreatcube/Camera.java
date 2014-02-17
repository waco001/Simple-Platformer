package com.gledx.thegreatcube;

import static org.lwjgl.opengl.GL11.glTranslatef;

import org.lwjgl.util.Rectangle;

public class Camera {
	Rectangle viewport = new Rectangle(0, 0, MapManager.tileToPixel(Main.WINDOW_WIDTH), MapManager.tileToPixel(Main.WINDOW_HEIGHT));
	public static int translate_x = 0;
	public static int translate_y = 0;
	public static void render(){
		glTranslatef(MapManager.tileToPixel(translate_x), MapManager.tileToPixel(translate_y), 0);
		translate_y = 0;
		translate_x = 0;
	}
}
