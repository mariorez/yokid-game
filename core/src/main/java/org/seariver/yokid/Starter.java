package org.seariver.yokid;

import org.seariver.yokid.screen.OpenScreen;

public class Starter extends BaseGame {

    @Override
    public void create() {
        super.create();
        setActiveScreen(new OpenScreen());
    }
}
