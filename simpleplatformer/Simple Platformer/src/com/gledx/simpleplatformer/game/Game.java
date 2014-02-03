package com.gledx.simpleplatformer.game;

import java.util.ArrayList;

import com.gledx.simpleplatformer.Main;
import com.gledx.simpleplatformer.engine.GameObject;
import com.gledx.simpleplatformer.gameobjects.Player;

public class Game {
	public static ArrayList<GameObject> objects;
	public static Player player;
	public Game(){
		objects = new ArrayList<GameObject>();
		player = new Player(Main.windowWidth/2, Main.windowHeight/2); //TEMP!
		objects.add(player);
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