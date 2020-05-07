//package screens;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.InputAdapter;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.Texture;
//import com.gamelibGDX.DigDoug.DigDoug;
//
//public class MainScreen implements Screen{
//
//    private static final int EXIT_BUTTON_WIDTH = 250;
//    private static final int EXIT_BUTTON_HEIGHT = 120;
//    private static final int PLAY_BUTTON_WIDTH = 300;
//    private static final int PLAY_BUTTON_HEIGHT = 120;
//    private static final int EXIT_BUTTON_Y = 100;
//    private static final int PLAY_BUTTON_Y = 230;
//    private static final int LOGO_WIDTH = 400;
//    private static final int LOGO_HEIGHT = 250;
//    private static final int LOGO_Y = 450;
//
//    final DigDoug game;
//
//    Texture playButtonActive;
//    Texture playButtonInactive;
//    Texture exitButtonActive;
//    Texture exitButtonInactive;
//    Texture logo;
//    Texture menu;
//
//    public MainScreen (final DigDoug game) {
//        this.game = game;
//        playButtonActive = new Texture("play_button_active.png");
//        playButtonInactive = new Texture("play_button_inactive.png");
//        exitButtonActive = new Texture("exit_button_active.png");
//        exitButtonInactive = new Texture("exit_button_inactive.png");
//        logo = new Texture("logo.png");
//        menu = new Texture("logo.png");
//
//        final MainScreen mainMenuScreen = this;
//
//        Gdx.input.setInputProcessor(new InputAdapter() {
//
//            @Override
//            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//                //Exit button
//                int x = DigDoug.WIDTH / 2 - EXIT_BUTTON_WIDTH / 2;
//                if (game.gCam.getInputInGameWorld().x < x + EXIT_BUTTON_WIDTH && game.gCam.getInputInGameWorld().x > x && DigDoug.HEIGHT - game.gCam.getInputInGameWorld().y < EXIT_BUTTON_Y + EXIT_BUTTON_HEIGHT && DigDoug.HEIGHT - game.gCam.getInputInGameWorld().y > EXIT_BUTTON_Y) {
//                    mainMenuScreen.dispose();
//                    Gdx.app.exit();
//                }
//
//                //Play game button
//                x = DigDoug.WIDTH / 2 - PLAY_BUTTON_WIDTH / 2;
//                if (game.gCam.getInputInGameWorld().x < x + PLAY_BUTTON_WIDTH && game.gCam.getInputInGameWorld().x > x && DigDoug.HEIGHT - game.gCam.getInputInGameWorld().y < PLAY_BUTTON_Y + PLAY_BUTTON_HEIGHT && DigDoug.HEIGHT - game.gCam.getInputInGameWorld().y > PLAY_BUTTON_Y) {
//                    mainMenuScreen.dispose();
//                    game.setScreen(new MainScreen(game));
//                }
//
//                return super.touchUp(screenX, screenY, pointer, button);
//            }
//
//        });
//    }
//
//    @Override
//    public void show () {
//
//    }
//
//    @Override
//    public void render (float delta) {
//        Gdx.gl.glClearColor(0.15f, 0.15f, 0.3f, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        game.batch.begin();
//
//
//        int x = DigDoug.WIDTH / 2 - EXIT_BUTTON_WIDTH / 2;
//        if (game.gCam.getInputInGameWorld().x < x + EXIT_BUTTON_WIDTH && game.gCam.getInputInGameWorld().x > x && DigDoug.HEIGHT - game.gCam.getInputInGameWorld().y < EXIT_BUTTON_Y + EXIT_BUTTON_HEIGHT && DigDoug.HEIGHT - game.gCam.getInputInGameWorld().y > EXIT_BUTTON_Y) {
//            game.batch.draw(exitButtonActive, x, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
//        } else {
//            game.batch.draw(exitButtonInactive, x, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
//        }
//
//        x = DigDoug.WIDTH / 2 - PLAY_BUTTON_WIDTH / 2;
//        if (game.gCam.getInputInGameWorld().x < x + PLAY_BUTTON_WIDTH && game.gCam.getInputInGameWorld().x > x && DigDoug.HEIGHT - game.gCam.getInputInGameWorld().y < PLAY_BUTTON_Y + PLAY_BUTTON_HEIGHT && DigDoug.HEIGHT - game.gCam.getInputInGameWorld().y > PLAY_BUTTON_Y) {
//            game.batch.draw(playButtonActive, x, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
//        } else {
//            game.batch.draw(playButtonInactive, x, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
//        }
//
//
//        game.batch.draw(logo, DigDoug.WIDTH / 2 - LOGO_WIDTH / 2, LOGO_Y, LOGO_WIDTH, LOGO_HEIGHT);
//        game.batch.draw(playButtonInactive, DigDoug.WIDTH / 2 - playButtonInactive.getWidth() / 2, 300, playButtonInactive.getWidth(), playButtonInactive.getHeight());
//
//        game.batch.end();
//    }
//
//    @Override
//    public void resize (int width, int height) {
//
//    }
//
//    @Override
//    public void pause() {}
//
//    @Override
//    public void resume() {}
//
//    @Override
//    public void hide() {}
//
//    @Override
//    public void dispose() {
//        Gdx.input.setInputProcessor(null);
//    }
//}
