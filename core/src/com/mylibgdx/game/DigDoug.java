package com.mylibgdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import world.CustomGameMap;
import world.GameMap;

public class DigDoug extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	OrthographicCamera cam;

	GameMap gameMap;

	@Override
	public void create () {
		batch = new SpriteBatch();

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		cam = new OrthographicCamera();
		cam.setToOrtho(false,w,h);
		cam.update();

		gameMap = new   CustomGameMap();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		cam.update();
		gameMap.update(Gdx.graphics.getDeltaTime());
		gameMap.render(cam);
	}

	@Override
	public void dispose () {
		batch.dispose();
		gameMap.dispose();
	}
}
