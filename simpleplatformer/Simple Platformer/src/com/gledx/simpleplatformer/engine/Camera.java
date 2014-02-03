package com.gledx.simpleplatformer.engine;

import static org.lwjgl.opengl.GL11.glTranslatef;

public class Camera {
	
	// Translation along the x-axis
	public static float translate_x = 0;	//<-- If we wanted it to not align with player
	public static float translate_y = 0;	//<-- If we wanted it to not align with player
	public static void translate(){
		glTranslatef(translate_x, translate_y, 0);
	}
	
}
