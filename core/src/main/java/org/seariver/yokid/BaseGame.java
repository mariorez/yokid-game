package org.seariver.yokid;

import com.badlogic.gdx.Game;
import org.seariver.yokid.screen.BaseScreen;

public abstract class BaseGame extends Game {

    private static BaseGame game;

    public BaseGame() {
        game = this;
    }

    /**
     * Used to switch screens while game is running.
     * Method is static to simplify usage.
     */
    public static void setActiveScreen(BaseScreen screen) {
        game.setScreen(screen);
    }
}
