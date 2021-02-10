package org.seariver.yokid.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import org.seariver.yokid.YokidGame;

public class MainScreen implements Screen {

    private final YokidGame game;
    private OrthographicCamera camera;
    private Texture yokidStand;

    public MainScreen(final YokidGame game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, YokidGame.WIDTH, YokidGame.HEIGHT);
        yokidStand = new Texture(Gdx.files.internal("yokid-front.png"));
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {

        // clear screen
        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();
        // draw graphics
        game.getBatch().setProjectionMatrix(camera.combined);
        game.getBatch().begin();
        game.getBatch().draw(yokidStand, 0, 0);
        game.getBatch().end();

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            game.setScreen(new OpenScreen(game));
        }
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
    }

    @Override
    public void dispose() {
        yokidStand.dispose();
        game.getBatch().dispose();
    }
}
