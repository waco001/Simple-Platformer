package com.gledx.simpleplatformer.engine;

import java.util.ArrayList;

public class Map {
	ArrayList<Tile> mapData;
	public void loadMap(String data){
		
	}
	public void render(){
		for(Tile i : mapData){
			i.render();
		}
	}
}
	