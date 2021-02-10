package org.seariver.yokid.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FillViewport;
import org.seariver.yokid.MainGame;

public abstract class BaseScreen implements Screen {

    protected Stage mainStage;

    public BaseScreen() {
        mainStage = new Stage(new FillViewport(MainGame.WIDTH, MainGame.HEIGHT));
        initialize();
    }

    public abstract void initialize();

    public abstract void update(float deltaTime);

    @Override
    public void render(float deltaTime) {
        // act methods
        mainStage.act(deltaTime);

        // user defined
        update(deltaTime);

        // clear screen
        ScreenUtils.clear(1, 1, 1, 1);

        // draw the graphics
        mainStage.draw();
    }

    @Override
    public void show() {
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
        mainStage.dispose();
    }
}
