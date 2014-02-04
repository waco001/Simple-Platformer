package com.gledx.simpleplatformer.engine.mapEngine;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MapManager {
	private Map currentMap;
	public void render(){
		currentMap.render();
	}
	public Map loadMap(String filePath){

		return currentMap;

	}
	public void saveMap(Map mapData, String filename){
		try{
			// Serialize data object to a file
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir") + "/map/" + filename));
			out.writeObject(mapData);
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally
		{

		}
	}
}