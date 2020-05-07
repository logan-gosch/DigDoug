package com.gdxgame.digdoug.world.custommap;

import com.gdxgame.digdoug.world.TileType;

import java.util.Random;


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

				if (row > SIZE - 2) {
					mapData.map[1][row][col] = TileType.BEDROCK.getId();
				} else if (row > SIZE - 25) {
					mapData.map[1][row][col] = TileType.DIRT.getId();
				} else if (row > SIZE - 25 && random.nextInt(10) == 0) {
					mapData.map[1][random.nextInt(10)][random.nextInt(10)] = TileType.CRYSTAL.getId();
				} else if (row > SIZE - 26) {
					mapData.map[1][row][col] = TileType.GRASS.getId();
				} else {
					// 1/5 chance of being a cloud
					if (random.nextInt(25) == 0)
						mapData.map[0][row][col] = TileType.CLOUD.getId();
				}
			}
		}
		
		return mapData;
	}
	
}
