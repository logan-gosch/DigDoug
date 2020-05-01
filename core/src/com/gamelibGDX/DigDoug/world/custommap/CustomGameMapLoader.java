package com.gamelibGDX.DigDoug.world.custommap;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

import com.gamelibGDX.DigDoug.world.TileType;

public class CustomGameMapLoader {

	private static final int SIZE = 50;
	
	public static CustomGameMapData generateRandomMap (String id, String name) {
		CustomGameMapData mapData = new CustomGameMapData();
		mapData.id = id;
		mapData.name = id;
		mapData.map = new int[2][SIZE][SIZE];
		
		Random random = new Random();
		
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				mapData.map[0][row][col] = TileType.SKY.getId();
				
				if (row > SIZE - 25) {
					mapData.map[1][row][col] = TileType.DIRT.getId();
				} else if (row > SIZE - 26) {
					mapData.map[1][row][col] = TileType.GRASS.getId();
				} else {
					if (random.nextInt(50) == 0)//1 chance out of 50 of being a cloud
						mapData.map[1][row][col] = TileType.CLOUD.getId();
				}
			}
		}
		
		return mapData;
	}
	
}
