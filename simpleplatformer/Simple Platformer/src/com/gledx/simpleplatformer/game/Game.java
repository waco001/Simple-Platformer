package com.gledx.simpleplatformer.game;

import java.util.ArrayList;

import com.gledx.simpleplatformer.Main;
import com.gledx.simpleplatformer.engine.GameObject;
import com.gledx.simpleplatformer.gameobjects.Player;
import com.gledx.simpleplatformer.gameobjects.Wall;

public class Game {
	public static ArrayList<GameObject> objects;
	public static Player player;
	public static Wall wall;
	public static Wall wall2;
	public static Wall wall3;
	public Game(){
		objects = new ArrayList<GameObject>();
		player = new Player(Main.windowWidth/2, Main.windowHeight/2); //TEMP!
		wall= new Wall(400,408);
		wall2= new Wall(392,408);
		wall3= new Wall(408,408);
		objects.add(player);
		objects.add(wall);
		objects.add(wall2);
		objects.add(wall3);
	}
	public void getInput(){
		player.getInput();
	}
	public void update(){
		//System.out.println(Map.map1.length);
		for(GameObject go : objects)
			go.update();
	}
	public void render(){
		for(GameObject go : objects)
			go.render();
		//Camera.translate();


	}
}