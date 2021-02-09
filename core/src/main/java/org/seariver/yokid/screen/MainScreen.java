package org.seariver.yokid.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import org.seariver.yokid.YokidGame;

public class MainScreen implements Screen {

    private Game game;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Texture yokidStand;

    public MainScreen(Game game) {
        this.game = game;
        camera = new OrthographicCamera();
        batch = new SpriteBatch();
    }

    @Override
    public void show() {
        camera.setToOrtho(false, YokidGame.WIDTH, YokidGame.HEIGHT);
        yokidStand = new Texture(Gdx.files.internal("yokid-front.png"));
    }

    @Override
    public void render(float delta) {

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            game.setScreen(new OpenScreen(game));
            return;
        }

        // clear screen
        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();
        // draw graphics
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(yokidStand, 0, 0);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        game = null;
        camera = null;
        batch = null;
        yokidStand = null;
    }
}
