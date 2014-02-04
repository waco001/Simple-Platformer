package com.gledx.simpleplatformer.game;

import java.util.ArrayList;

import com.gledx.simpleplatformer.Main;
import com.gledx.simpleplatformer.engine.GameObject;
import com.gledx.simpleplatformer.engine.Point;
import com.gledx.simpleplatformer.engine.mapEngine.Map;
import com.gledx.simpleplatformer.engine.mapEngine.MapManager;
import com.gledx.simpleplatformer.engine.mapEngine.Tile;
import com.gledx.simpleplatformer.gameobjects.Player;
import com.gledx.simpleplatformer.gameobjects.Wall;

public class Game {
	public static ArrayList<GameObject> objects;
	ArrayList<Tile> mapData;
	MapManager mapManager;
	public static Player player;
	public static Wall wall;
	public static Wall wall2;
	public static Wall wall3;




	Map map1;
	public Game(){
		objects = new ArrayList<GameObject>();
		player = new Player(Main.windowWidth/2, Main.windowHeight/2); //TEMP!
		mapData = new ArrayList<Tile>();
		mapManager = new MapManager();
		wall= new Wall(400,416);
		wall2= new Wall(386,416);
		wall3= new Wall(416,416);
		objects.add(player);
		objects.add(wall);
		objects.add(wall2);
		objects.add(wall3);
		map1 = new Map(mapData);
		map1.mapData.add(new Tile(new Point(50, 50), 32, 32, Tile.tiletype.BLOCK_WALL));
		map1.mapData.add(new Tile(new Point(82, 50), 32, 32, Tile.tiletype.BLOCK_GROUND));
		map1.mapData.add(new Tile(new Point(50, 82), 32, 32, Tile.tiletype.BLOCK_WALL));
		map1.mapData.add(new Tile(new Point(50, 104), 32, 32, Tile.tiletype.BLOCK_LAVA));
		mapManager.saveMap(map1, "testMap1.zme");// <--------- SERIALIZING CODE
		


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
