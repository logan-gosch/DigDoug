package com.gamelibGDX.DigDoug.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.gamelibGDX.DigDoug.tools.CollisionRect;
import com.gamelibGDX.DigDoug.world.GameMap;

public class Player extends Entity {
	
	private static final int SPEED = 80;
	private static final int JUMP_VELOCITY = 5;
	public static final int WIDTH = 14;
	public static final int HEIGHT = 32;

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

		if (Gdx.input.isKeyPressed(Keys.DOWN))
			moveY(SPEED * deltaTime);

		rect.move(getX(), getY());
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
	}

	public CollisionRect getCollisionRect(){
		return rect;
	}

}
