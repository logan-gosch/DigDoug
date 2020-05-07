package com.gamelibGDX.DigDoug.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.gamelibGDX.DigDoug.tools.CollisionRect;
import com.gamelibGDX.DigDoug.world.GameMap;
import com.gamelibGDX.DigDoug.world.TileType;
import com.gamelibGDX.DigDoug.world.custommap.CustomGameMapLoader;


public class Player extends Entity {

	private static final int JUMP_VELOCITY = 5;
	public static final int WIDTH = 14;
	public static final int HEIGHT = 32;
	private static final int SPEED = 80;

	public CollisionRect rect;
	Texture image;

	public Player (float x, float y, GameMap map) {

		super(x, y, EntityType.PLAYER, map);

		image = new Texture("DOUG.gif");

		this.rect = new CollisionRect(x, y, WIDTH, HEIGHT);
	}
	
	@Override
	public void update(float deltaTime, float gravity) {
		if (Gdx.input.isKeyPressed(Keys.SPACE) && grounded)
			this.velocityY += JUMP_VELOCITY * getWeight();
		else if (Gdx.input.isKeyPressed(Keys.SPACE) && !grounded && this.velocityY > 0)
			this.velocityY += JUMP_VELOCITY * getWeight() * deltaTime;
		
		super.update(deltaTime, gravity);//Apply gravity
		
		if (Gdx.input.isKeyPressed(Keys.LEFT))
			moveX(-SPEED * deltaTime);

		if (Gdx.input.isKeyPressed(Keys.RIGHT))
			moveX(SPEED * deltaTime);

		rect.move(getX(), getY());

		/**
		 * Gets a tile at its coordinate within the map at a specified layer.
		 * @param layer
		 * @param col
		 * @param row
		 * @return
		 */

		if(map.doesRectCollideWithMap(pos.x, pos.y, getWidth(), getHeight()) && Gdx.input.isKeyJustPressed(Keys.DOWN))
		{

		}
	}

	protected void moveX (float amount) {
		float newX = pos.x + amount;
		if (!map.doesRectCollideWithMap(newX, pos.y, getWidth(), getHeight())) {
			this.pos.x = newX;
		}
	}

	protected void moveY (float amount) {
		float newY = pos.x + amount;
		if (!map.doesRectCollideWithMap(newY, pos.x, getWidth(), getHeight()))
			this.pos.x = newY;
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
	}

	public CollisionRect getCollisionRect(){
		return rect;
	}

}
