package world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import custommap.CustomMapData;
import custommap.CustomMapLoader;

public class CustomGameMap extends GameMap{

    String id;
    String name;
    int[][][] map;

    private SpriteBatch batch;
    private TextureRegion[][] tiles;

    public CustomGameMap (){
        CustomMapData data = CustomMapLoader.loadMap("basic", "DigDoug");
        this.id = data.id;
        this.name = data.name;
        this.map = data.map;

        batch = new SpriteBatch();
        tiles = TextureRegion.split(new Texture("tiles.png"), TileType.TILE_SIZE, TileType.TILE_SIZE);
    }

    @Override
    public void render(OrthographicCamera camera) {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void dispose() {

    }

    @Override
    public TileType getTileTypeByLocation(int layer, float x, float y) {
        return this.getTileTypeByCoordinate(layer, (int) (x / TileType.TILE_SIZE), getHeight() - (int) (y / TileType.TILE_SIZE) - 1);
    }

    @Override
    public TileType getTileTypeByCoordinate(int layer, int col, int row) {
        if (col < 0 || col >= getWidth() || row < 0 || row >= getHeight()) {
        return null;
    }
        return TileType.getTileTypeById(map[layer][getHeight() - row - 1][col]);
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getLayers() {
        return 0;
    }
}
