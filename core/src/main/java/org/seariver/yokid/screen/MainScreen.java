package org.seariver.yokid.screen;

import com.badlogic.gdx.Input;
import org.seariver.yokid.GameInitializer;
import org.seariver.yokid.actor.Yokid;

public class MainScreen extends BaseScreen {

    private Yokid yokid;

    @Override
    public void initialize() {
        yokid = new Yokid(100, 100, mainStage);
    }

    @Override
    public void update(float deltaTime) {
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.ESCAPE) {
            GameInitializer.setActiveScreen(new OpenScreen());
        }
        return false;
    }
}
