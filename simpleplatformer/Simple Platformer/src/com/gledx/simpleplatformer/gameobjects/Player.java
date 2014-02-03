package com.gledx.simpleplatformer.gameobjects;

import java.util.Map;

import org.lwjgl.input.Keyboard;

import com.gledx.simpleplatformer.engine.Camera;
import com.gledx.simpleplatformer.engine.GameObject;

public class Player extends GameObject{

	private int blockSpeed = 16;
	private boolean moveLeft = false;
	private boolean moveRight = false;
	private boolean moveUp = false;
	private boolean moveDown = false;

	public Player(int i, int j) {
		// TODO Auto-generated constructor stub
		init(i, j, 0.1f, 1f, 0.25f, 8, 8);
	}

	@Override
	public void update(){
		if(moveLeft == true){
			if(canMoveLeft()){
				loc.x -= blockSpeed;
				Camera.translate_x += blockSpeed;
			}
		}
		if(moveDown == true){
			if(canMoveDown()){
				loc.y += blockSpeed;
				Camera.translate_y -= blockSpeed;
			}
		}
		if(moveRight == true){
			if(canMoveRight()){
				loc.x += blockSpeed;
				Camera.translate_x -= blockSpeed;
			}
		}
		if(moveUp == true){
			if(canMoveUp()){
				loc.y -= blockSpeed;
				Camera.translate_y += blockSpeed;
			}
		}
	}


	public void getInput() {
		// TODO Auto-generated method stub
		while (Keyboard.next()) {
			if(Keyboard.isKeyDown(Keyboard.KEY_A)){
				moveLeft = true;
			}
			else{
				moveLeft = false;
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_S)){
				moveDown = true;
			}
			else{
				moveDown = false;
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_D)){
				moveRight = true;
			}
			else{
				moveRight = false;
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_W)){
				moveUp = true;
			}
			else{
				moveUp = false;
			}
		}
	}
	private boolean canMoveLeft(){
		if(loc.x - 8 < 0)
			return false;
		return true;
	}
	private boolean canMoveRight(){
		if(loc.x + 8> 800)
			return false;
		return true;
	}
	private boolean canMoveUp(){
		if(loc.y - 8< 0)
			return false;
		return true;
	}
	private boolean canMoveDown(){
		if(loc.y + 8> 800)
			return false;
		return true;
	}
}
