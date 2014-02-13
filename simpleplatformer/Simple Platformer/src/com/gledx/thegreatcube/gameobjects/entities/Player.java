package com.gledx.thegreatcube.gameobjects.entities;

import org.lwjgl.input.Keyboard;

import com.gledx.thegreatcube.Camera;
import com.gledx.thegreatcube.MapManager;
import com.gledx.thegreatcube.gameobjects.GameObject;

public class Player extends GameObject{
	private static final int startingX = 0;
	private static final int startingY = 1;
	private double xspeed;
	private double yspeed;
	private boolean left, right, canjump = false;
	public Player() {
		super(startingX, startingY, 0.8f, 0.1f, 0.1f);
		debug = true;
	}
	public void update(){
		{ //NEEDED
			loc.x += xspeed;
			loc.y -= yspeed;

			yspeed += 0.1;

			spr.setX(loc.x);
			spr.setY(loc.y);

			if(left == true){
				loc.x -= 1;
				Camera.translate_x += 1;
			}
			if(right == true){
				loc.x += 1;
				Camera.translate_x -= 1;
			}



			if(loc.y <= 0){
				loc.y = 1;
				canjump = true;
			}
			if(loc.x <= 0){
				loc.x = 1;
			}
			if(loc.x >= 40)
				loc.x = 39;
			if(loc.y >= 30)
				loc.y = 29;
			if(loc.y <= 1)
				yspeed = 0;
			System.out.println(loc.x + " " + loc.y);
		}
		while(Keyboard.next()){

			if(Keyboard.isKeyDown(Keyboard.KEY_SPACE) && MapManager.isBlockType(loc.x, loc.y - 1, 1)){
				yspeed -= 2;
			}

			if(Keyboard.isKeyDown(Keyboard.KEY_A)){
				if(!(MapManager.isBlockType(loc.x-1, loc.y, 1))){
					left = true;
				}

			}
			else{
				left = false;
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_D)){
				if(!(MapManager.isBlockType(loc.x+1, loc.y, 1))){
					right = true;
				}
			}
			else{
				right = false;
			}
		}
	}
}

