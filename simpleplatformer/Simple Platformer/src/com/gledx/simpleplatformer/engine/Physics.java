package com.gledx.simpleplatformer.engine;

import java.awt.Rectangle;

public class Physics {
	public static boolean isCollision(GameObject go1, GameObject go2){
		Rectangle r1 = new Rectangle((int)go1.getX(), (int)go1.getsSx(), (int)go1.getY(), (int)go1.getSy());
		Rectangle r2 = new Rectangle((int)go2.getX(), (int)go2.getsSx(), (int)go2.getY(), (int)go2.getSy());

		return r1.intersects(r2);
	}
}
	