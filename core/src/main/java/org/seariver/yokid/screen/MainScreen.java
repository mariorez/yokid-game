package org.seariver.yokid.screen;

import com.badlogic.gdx.Input;
import org.seariver.yokid.MainGame;
import org.seariver.yokid.actor.YokidActor;

public class MainScreen extends BaseScreen {

    private YokidActor yokidActor;

    @Override
    public void initialize() {
        yokidActor = new YokidActor(0, 0, mainStage);
    }

    @Override
    public void update(float deltaTime) {
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.ESCAPE) {
            MainGame.setActiveScreen(new OpenScreen());
        }
        return false;
    }
}
