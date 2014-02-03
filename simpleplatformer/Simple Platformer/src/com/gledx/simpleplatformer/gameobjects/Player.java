package com.gledx.simpleplatformer.gameobjects;

import java.util.Map;

import org.lwjgl.input.Keyboard;

import com.gledx.simpleplatformer.engine.Camera;
import com.gledx.simpleplatformer.engine.GameObject;

public class Player extends GameObject{

	private double acc=0.23;
	private double deacc=0.18;
    private double maxvspeed=6.5;
    private double maxhspeed=5;
    private double _maxvspeed=5.5;
    private double _maxhspeed=5;
    private double _acc=0.23;
    private double _deacc=0.34;
    private double h=0;
    private int dir=0;
    //private int jumps=2;
    
	private boolean Left = false;
	private boolean Right = false;
	private boolean Up = false;
	private boolean Down = false;

	public Player(int i, int j) {
		// TODO Auto-generated constructor stub
		init(i, j, 1.0f, 0.1f, 0.25f, 8, 8);
	}

	@Override
	public void update(){
		//if(moveLeft == true){
		//	if(canMoveLeft()){
				//loc.x -= acc;
				////Camera.translate_x += blockSpeed;
		//	}
		//}
		//if(moveDown == true){
		//	if(canMoveDown()){
		//		loc.y += acc;
				////Camera.translate_y -= blockSpeed;
		//	}
		//}
	//	if(moveRight == true){
		//	if(canMoveRight()){
			//	loc.x += acc;
				////Camera.translate_x -= blockSpeed;
			//}
		//}
		//if(moveUp == true){
		//	if(canMoveUp()){
			//	loc.y -= acc;
				////Camera.translate_y += blockSpeed;
			//}
		//}

		loc.x+=h;
		
			if ((Left==true) && (Right==false) )//|| (Right=true) && (Left=false))
			{
				h-=_acc;
				loc.x+=h;
			}
			
			if((Right==true) && (Left==false))	
			{
				h+=_acc;
				loc.x+=h;	
				
			}
			if((Left==true)&& (Right==true) || ((Left==false) && (Right==false)))
			{
				
				if (h>0){
			        h-=_deacc;
			        h=Math.max(h,0);}
			    if (h<0){
			        h+=_deacc;
			        h=Math.min(h,0);}
			}
			
		if (loc.x+1>800)
		{loc.x=1;}
		if (loc.x-1<0)
		{loc.x=799;}
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
				//moveDown = true;
			}
			else{
				//moveDown = false;
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
				//moveUp = true;
			}
			else{
				//moveUp = false;
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
