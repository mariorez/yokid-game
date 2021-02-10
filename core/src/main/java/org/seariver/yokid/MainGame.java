package org.seariver.yokid;

import org.seariver.yokid.screen.OpenScreen;

public class MainGame extends BaseGame {

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    @Override
    public void create() {
        super.create();
        setActiveScreen(new OpenScreen());
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
