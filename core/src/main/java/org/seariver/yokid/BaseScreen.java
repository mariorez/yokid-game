package org.seariver.yokid;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class BaseScreen implements Screen, InputProcessor {

    protected Stage mainStage;

    public BaseScreen() {
        mainStage = new Stage();
        initialize();
    }

    public abstract void initialize();

    public abstract void update(float deltaTime);

    /**
     * Game-loop:
     * (1) process input (discrete handled by listener; continuous in update)
     * (2) update game logic
     * (3) render the graphics
     */
    public void render(float deltaTime) {
        // limit amount of time that can pass while window is being dragged
        deltaTime = Math.min(deltaTime, 1 / 30f);

        // act methods
        mainStage.act(deltaTime);

        // defined by user
        update(deltaTime);

        // clear the screen
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // draw the graphics
        mainStage.draw();
    }

    // methods required by Screen interface
    public void resize(int width, int height) {
    }

    public void pause() {
    }

    public void resume() {
    }

    public void dispose() {
    }

    /**
     * Called when this becomes the active screen in a Game.
     * Set up InputMultiplexer here, in case screen is reactivated at a later time.
     */
    public void show() {
        InputMultiplexer inputProcessor = (InputMultiplexer) Gdx.input.getInputProcessor();
        inputProcessor.addProcessor(this);
        inputProcessor.addProcessor(mainStage);
    }

    /**
     * Called when this is no longer the active screen in a Game.
     * Screen class and Stages no longer process input.
     * Other InputProcessors must be removed manually.
     */
    public void hide() {
        InputMultiplexer inputProcessor = (InputMultiplexer) Gdx.input.getInputProcessor();
        inputProcessor.removeProcessor(this);
        inputProcessor.removeProcessor(mainStage);
    }

    // methods required by InputProcessor interface
    public boolean keyDown(int keycode) {
        return false;
    }

    public boolean keyUp(int keycode) {
        return false;
    }

    public boolean keyTyped(char character) {
        return false;
    }

    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }
}
