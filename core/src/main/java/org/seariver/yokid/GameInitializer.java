package org.seariver.yokid;

import org.seariver.yokid.screen.OpenScreen;

public class GameInitializer extends BaseGame {

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    @Override
    public void create() {
        super.create();
        activateDebug();
        setActiveScreen(new OpenScreen());
    }
}
