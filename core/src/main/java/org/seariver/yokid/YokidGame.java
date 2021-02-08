package org.seariver.yokid;

import org.seariver.yokid.screen.OpenScreen;

public class YokidGame extends BaseGame {

    public static int WIDTH = 1280;
    public static int HEIGHT = 720;

    @Override
    public void create() {
        super.create();
        setActiveScreen(new OpenScreen());
    }
}
