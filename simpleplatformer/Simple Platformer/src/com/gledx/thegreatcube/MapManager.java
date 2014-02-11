package com.gledx.thegreatcube;

import org.lwjgl.util.Rectangle;

public class MapManager {
	public static final int MAP_X = 40; //In tiles
	public static final int MAP_Y = 30;
	public static final int MAP_TILE_SIZE = 16;
	Rectangle viewport;
	public static final int[][] map = new int[MAP_X][MAP_Y];

	public MapManager(){
		viewport = new Rectangle(0, 0, tileToPixel(MAP_X), tileToPixel(MAP_Y));
	}
	public static void render(){
		Sprite spr;
		for(int x = 0; x <= (MAP_X-1); x++){
			for(int y = 0; y <= (MAP_Y-1); y++){
				switch(map[x][y]){
				case 1:
					spr = new Sprite(x, y, 0.5f, 0.5f, 0.5f);
					spr.render();
					break;
				case 0:
				default:
					spr = new Sprite(x, y, 1.0f, 1.0f, 1.0f);
					spr.render();
					break;
				}
			}
		}
	}
	public static void loadMap(){ //Int array is put to 0 if not set...
		for(int x = 0; x <= (MAP_X-1); x++){
			map[x][0] = 1;
		}
		for(int y = 0; y <= (MAP_Y-1); y++){
			map[0][y] = 1;
		}
		for(int x = 0; x <= (MAP_X-1); x++){
			map[x][MAP_Y-1] = 1;
		}
		for(int y = 0; y <= (MAP_Y-1); y++){
			map[MAP_X-1][y] = 1;
		}
	}

	public static int pixelToTile(int x){
		return (x / MAP_TILE_SIZE);
	}
	public static int tileToPixel(int x){
		return (x * MAP_TILE_SIZE);
	}
	public static boolean isBlockType(int x, int y, int blockType){
		if(map[x][y] == blockType)
			return true;
		return false;
	}

}
