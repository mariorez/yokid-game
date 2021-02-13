package org.seariver.yokid;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import org.seariver.yokid.screen.BaseScreen;

import static com.badlogic.gdx.Application.LOG_DEBUG;

public abstract class BaseGame extends Game {

    private static final String TAG = BaseGame.class.getSimpleName();
    private static BaseGame game;
    private String lastScreen = "";
    private String currentScreen = "";
    protected boolean activateDebug = false;

    public BaseGame() {
        game = this;
    }

    /**
     * Called when game is initialized,
     * after Gdx.input and other objects have been initialized.
     */
    @Override
    public void create() {
        // prepare for multiple classes/stages/actors to receive discrete input
        InputMultiplexer im = new InputMultiplexer();
        Gdx.input.setInputProcessor(im);
    }

    @Override
    public void render() {
        debug("render: " + currentScreen, true);
        super.render();
    }

    @Override
    public void dispose() {
        debug("dispose: " + currentScreen, false);
        super.dispose();
    }

    @Override
    public void setScreen(Screen screen) {
        currentScreen = screen.getClass().getSimpleName();
        debug("set screen: " + currentScreen, false);
        super.setScreen(screen);
    }

    /**
     * Used to switch screens while game is running.
     * Method is static to simplify usage.
     */
    public static void setActiveScreen(BaseScreen screen) {
        game.setScreen(screen);
    }

    protected void activateDebug() {
        activateDebug = true;
        Gdx.app.setLogLevel(LOG_DEBUG);
    }

    private void debug(String message, boolean once) {
        if (activateDebug) {
            if (once) {
                if (currentScreen != lastScreen) {
                    Gdx.app.debug(TAG, message);
                    lastScreen = currentScreen;
                }
            } else {
                Gdx.app.debug(TAG, message);
            }
        }
    }
}
