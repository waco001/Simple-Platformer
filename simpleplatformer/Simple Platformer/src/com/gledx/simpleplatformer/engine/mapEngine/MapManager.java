package com.gledx.simpleplatformer.engine.mapEngine;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MapManager {
	private Map currentMap;
	public void render(){
		currentMap.render();
	}
	public Map loadMap(String filename){
		Map returnMap = null;
		try
		{
			FileInputStream fileIn = new FileInputStream(System.getProperty("user.dir") + "/map/" + filename);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			returnMap = (Map) in.readObject();
			in.close();
			fileIn.close();
		}catch(IOException i)
		{
			i.printStackTrace();
		}catch(ClassNotFoundException c)
		{
			System.out.println("Employee class not found");
			c.printStackTrace();
		}
		return returnMap;

	}

	public void saveMap(Map mapData, String filename){

		try
		{
			FileOutputStream fileOut =
					new FileOutputStream(System.getProperty("user.dir") + "/map/" + filename);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(mapData);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in /tmp/employee.ser");
		}catch(IOException i)
		{
			i.printStackTrace();
		}
		finally{

		}

	}
}
