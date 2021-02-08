package org.seariver.yokid.screen;

import org.seariver.yokid.BaseActor;
import org.seariver.yokid.BaseScreen;

public class OpenScreen extends BaseScreen {

    @Override
    public void initialize() {
        BaseActor openTheme = new BaseActor(0, 0, mainStage);
        openTheme.loadTexture("open-screen.png");
    }

    @Override
    public void update(float deltaTime) {
    }
}
