package com.gledx.simpleplatformer.gameobjects;

import com.gledx.simpleplatformer.engine.GameObject;

public class Wall extends GameObject{

	public Wall(int i, int j) {
		init(i, j, 1.0f, 0.2f, 0.45f, 8, 8);
	}

}
