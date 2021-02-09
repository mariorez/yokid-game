package org.seariver.yokid;

import com.badlogic.gdx.Game;
import org.seariver.yokid.screen.OpenScreen;

public class YokidGame extends Game {

    public static int WIDTH = 1280;
    public static int HEIGHT = 720;

    @Override
    public void create() {
        setScreen(new OpenScreen(this));
    }
}
