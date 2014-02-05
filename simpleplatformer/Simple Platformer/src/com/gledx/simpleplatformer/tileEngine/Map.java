package com.gledx.simpleplatformer.tileEngine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.gledx.simpleplatformer.engine.Point;


public class Map {

	public static int tileSize = 16;
	public static int[][] map1 = {
		{0, 0, 1, 1}
	};

	public static int[][] currentMap;
	//private static Tile[] map = {new Tile(1.0f, 0.0f, 0.0f, 0, 0), new Tile(0.0f, 1.0f, 0.0f, 16, 16), new Tile(0.0f, 0.0f, 1.0f, 32, 32)};
	//private static ArrayList<Tile> map = new ArrayList<Tile>();
	//private static int currentx = 0;
	//private static int currenty;

	public Map(){
	}

	public static void render(){
		for(int x = 0; x < currentMap.length; x++){
			for(int y = 0; y < currentMap[x].length; y++){
				getBlock(currentMap[x][y], y, x).render();
			}
		}
	}
	public static void loadMap() throws IOException{

		currentMap = map1;
	}

	private static Tile getBlock(int id, int x, int y){
		Tile tile;
		switch(id){
		case 0:
			tile = new Tile(0.0f, 0.0f, 0.0f, blockToPixel(x, y).getX(), blockToPixel(x, y).getY());
			return tile;
		case 1:
			tile = new Tile(0.0f, 0.0f, 1.0f, blockToPixel(x, y).getX(), blockToPixel(x, y).getY());
			return tile;
		case 2:
			tile = new Tile(0.0f, 1.0f, 0.0f, blockToPixel(x, y).getX(), blockToPixel(x, y).getY());
			return tile;
		case 3:
			tile = new Tile(1.0f, 0.0f, 0.0f, blockToPixel(x, y).getX(), blockToPixel(x, y).getY());
			return tile;
		default:
			return null;
		}
	}
	private static Point blockToPixel(int x, int y){
		Point point = new Point(0, 0);
		point.setX(x * 17);
		point.setY(y * 17);
		return point;
	}
	public static boolean isBlockAt(Point point){
		Point tempPoint = new Point(point.getX() / tileSize, point.getY() / tileSize);
		if(currentMap.length != tempPoint.getX()){
			if(currentMap[currentMap.length].length != tempPoint.getY()){
				return false;
			}
		}
		return true;
	}
}
