package com.gledx.simpleplatformer.gameobjects;

import org.lwjgl.input.Keyboard;

import com.gledx.simpleplatformer.Main;
import com.gledx.simpleplatformer.engine.Camera;
import com.gledx.simpleplatformer.engine.GameObject;

public class Player extends GameObject{
	private int speed = 16;

	private boolean Left = false;
	private boolean Right = false;
	private boolean Up = false;
	private boolean Down = false;

	public Player(int i, int j) {
		// TODO Auto-generated constructor stub
		init(i, j, 1.0f, 0.1f, 0.25f);
	}

	@Override
	public void update(){

		if(!(Right && Left)){
			if(Right){
				loc.x += speed;
			}
			if(Left){
				loc.x -= speed;
			}

		}
		if(!(Down && Up)){
			if(Down){
				loc.y += speed;
			}
			if(Up){
				loc.y -= speed;
			}
		}

		Camera.translate_x = -1 * (loc.x) + Main.windowWidth/2;
		Camera.translate_y = -1 * (loc.y) + Main.windowWidth/2;
	
		System.out.println(loc.x + " " + loc.y);
		//Camera.translate_y = -1 * (loc.y);
	}


	public void getInput() {
		// TODO Auto-generated method stub
		while (Keyboard.next()) {
			if(Keyboard.isKeyDown(Keyboard.KEY_A)){
				//moveLeft = true;
				Left=true;
			}
			else{
				//moveLeft = false;
				Left=false;
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_S)){
				Down = true;
			}
			else{
				Down = false;
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_D)){
				//moveRight = true;
				Right=true;
			}
			else{
				//moveRight = false;
				Right=false;
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_W)){
				Up = true;
			}
			else{
				Up = false;
			}

		}
	}


}
