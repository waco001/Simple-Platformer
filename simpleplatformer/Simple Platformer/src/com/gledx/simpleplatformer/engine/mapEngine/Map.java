package com.gledx.simpleplatformer.engine.mapEngine;

import java.io.Serializable;
import java.util.ArrayList;

public class Map implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<Tile> mapData;
	public Map(){
		
	}
	public void setData(ArrayList<Tile> mapData){
		this.mapData = mapData;
		
	}
	public void render(){
		for(Tile i : mapData){
			i.render();
		}
	}

}
	