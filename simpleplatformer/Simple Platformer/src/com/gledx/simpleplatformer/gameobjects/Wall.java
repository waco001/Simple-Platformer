package com.gledx.simpleplatformer.gameobjects;

import com.gledx.simpleplatformer.engine.GameObject;

public class Wall extends GameObject{

	public Wall(int i, int j) {
		init(i, j, 0.0f, 0.8f, 1.45f, 16, 16);
	}

}
