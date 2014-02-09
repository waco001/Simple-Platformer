package com.gledx.thegreatcube;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3d;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslated;
import static org.lwjgl.opengl.GL11.glVertex2d;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

public class Player {
	public double x, y, xspeed, yspeed;
	public double acc=0.23;
	public double deacc=0.18;
	public double maxvspeed=6.5;
	public double maxhspeed=5;
	public int jumps=2;
	public double _maxvspeed=5.5;
	public double _maxhspeed=5;
	public int dj=2;
	public double _acc=0.23;
	public double _deacc=0.34;
	public boolean Left=false;
	public boolean Right=false;
	public boolean Up=false;
	public boolean Down=false;
	public double h;
	public boolean Object_Right = false;
	public boolean Object_Left = false;
	public boolean Object_Down = false;
	public double lowestObject = 32;
	public Player(){
		x = 100;
		y = 300;
		xspeed = 1.0;
		yspeed = 5.0;
	}
	public void update(){
		//System.out.println(getBounds().getHeight() + y);
		checkCollision();
		System.out.println(x + " " + y);
		x += xspeed;

		y -= yspeed;
		yspeed += 0.4;
		if(y <= 32 ){
			yspeed = 0;
			y = 32;
			if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
				yspeed -= 10;
		}else if(Object_Down == true && getBounds().getY() <= lowestObject){
			y = lowestObject;
			if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
				yspeed -= 10;
		}
		
		if(!Keyboard.isKeyDown(Keyboard.KEY_A) && xspeed < 0)
			xspeed *= 0.9;
		if(Keyboard.isKeyDown(Keyboard.KEY_A))
			xspeed = Math.max(-5, xspeed-1);
		if(!Keyboard.isKeyDown(Keyboard.KEY_D) && xspeed > 0)
			xspeed *= 0.9;
		if(Keyboard.isKeyDown(Keyboard.KEY_D))
			xspeed = Math.min(5, xspeed+1);

		if(x <= 0)
			x = 634;
		if(x >= 640)
			x = 0;
	}
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 32, 32);
	}
	public void draw(){
		glPushMatrix();
		glTranslated(x, y, 0);

		glBegin(GL_QUADS);
		glColor3d(1.0, 0.2, 0.5);
		glVertex2d(0, 0);

		glVertex2d(32, 0);

		glVertex2d(32, 32);

		glVertex2d(0, 32);
		glEnd();
		glPopMatrix();

	}
	public void checkCollision(){	
		{
			Point A1 = new Point(getBounds().getX(), getBounds().getY() + getBounds().getHeight()); //Our Sprite
			Point A2 = new Point(getBounds().getX() + getBounds().getWidth(), getBounds().getY());
			Point B1; // Other Sprite
			Point B2;
			
			for(Tile t : MapEngine.tileMap){
				B1 = new Point(t.getBounds().getX(), t.getBounds().getY() + t.getBounds().getHeight());
				B2 = new Point(t.getBounds().getX() + t.getBounds().getWidth(), t.getBounds().getY());
				
				if(B1.getY() <= A1.getY()){
					if(A1.getX() <= B1.getX()){
						if(A2.getX() >= B1.getX()){
							Object_Down = true;
							lowestObject = t.getBounds().getY() + t.getBounds().getHeight();
							System.out.println("OBJECT");
						}
					}
					if(A1.getX() <= B2.getX()){
						if(A2.getX() >= B2.getX()){
							Object_Down = true;
							lowestObject = t.getBounds().getY()+ t.getBounds().getHeight();
							System.out.println("OBJECT");

						}
					}
				}else{Object_Down = false; lowestObject = 32; System.out.println("NO OBJECT");}
				
				
			}
		}
	}
}