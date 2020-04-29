package com.gamelibGDX.DigDoug.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.gamelibGDX.DigDoug.entities.Player;
import com.gamelibGDX.DigDoug.tools.CollisionRect;
import com.gamelibGDX.DigDoug.world.custommap.CustomGameMapData;
import com.gamelibGDX.DigDoug.world.custommap.CustomGameMapLoader;

import java.util.ArrayList;

public class CustomGameMap extends GameMap {
	
	String id;
	String name;
	int[][][] map;
	
	private TextureRegion[][] tiles;
	
	public CustomGameMap () {
		CustomGameMapData data = CustomGameMapLoader.generateRandomMap("bruh", "DigDoug");
		this.id = data.id;
		this.name = data.name;
		this.map = data.map;
		
		tiles = TextureRegion.split(new Texture("C:\\Users\\Logan\\Documents\\GitHub\\DigDoug\\core\\assets\\tiles.png"), TileType.TILE_SIZE, TileType.TILE_SIZE);
	}
	
	@Override
	public void render(OrthographicCamera camera, SpriteBatch batch) {
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		
		for (int layer = 0; layer < getLayers(); layer++) {
			for (int row = 0; row < getHeight(); row++) {
				for (int col = 0; col < getWidth(); col++) {
					TileType type = this.getTileTypeByCoordinate(layer, col, row);
					if (type != null)
						batch.draw(tiles[0][type.getId() - 1], col * TileType.TILE_SIZE, row * TileType.TILE_SIZE);
				}
			}
		}
		
		super.render(camera, batch);
		batch.end();
	}

	@Override
	public void update(float delta) {
		super.update(delta);
	}

	@Override
	public void dispose() {}
	
	@Override
	public TileType getTileTypeByLocation(int layer, float x, float y) {
		return this.getTileTypeByCoordinate(layer, (int) (x / TileType.TILE_SIZE), getHeight() - (int) (y / TileType.TILE_SIZE) - 1);
	}
	
	@Override
	public TileType getTileTypeByCoordinate(int layer, int col, int row) {
		if (col < 0 || col >= getWidth() || row < 0 || row >= getHeight())
			return null;
		
		return TileType.getTileTypeById(map[layer][getHeight() - row - 1][col]);
	}

	@Override
	public int getWidth() {
		return map[0][0].length;
	}

	@Override
	public int getHeight() {
		return map[0].length;
	}

	@Override
	public int getLayers() {
		return map.length;
	}

}
