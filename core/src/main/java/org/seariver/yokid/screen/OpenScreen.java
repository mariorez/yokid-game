package org.seariver.yokid.screen;

import com.badlogic.gdx.Input;
import org.seariver.yokid.GameInitializer;
import org.seariver.yokid.actor.BaseActor;

public class OpenScreen extends BaseScreen {

    @Override
    public void initialize() {
        BaseActor open = new BaseActor(0, 0, mainStage);
        open.loadSprite("open-screen.png");
    }

    @Override
    public void update(float deltaTime) {
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.ENTER) {
            GameInitializer.setActiveScreen(new MainScreen());
        }
        return false;
    }
}
