package com.gamelibGDX.DigDoug;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Game;

import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.gamelibGDX.DigDoug.tools.GameCamera;
import com.gamelibGDX.DigDoug.world.CustomGameMap;
import com.gamelibGDX.DigDoug.world.GameMap;


public class DigDoug extends Game {

    public static final int WIDTH = 480;
    public static final int HEIGHT = 720;
    private StretchViewport viewport;
    public SpriteBatch batch;

    GameMap gameMap;
	Music music;
    OrthographicCamera cam;

    float deltaX, deltaY;
    
	@Override
	public void create() {

	    music = Gdx.audio.newMusic(Gdx.files.internal("D_O_U_G.mp3"));
	    music.setLooping(true);
	    music.play();

		batch = new SpriteBatch();
		
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();


        cam = new OrthographicCamera();
        cam.setToOrtho(false,w,h);
        cam.update();

        gameMap = new CustomGameMap();

	}

    @Override
	public void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        cam.update();
        gameMap.update(Gdx.graphics.getDeltaTime());
        gameMap.render(cam, batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		gameMap.dispose();
		music.dispose();
	}

}


