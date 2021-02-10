package org.seariver.yokid.screen;

import com.badlogic.gdx.Gdx;
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
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            MainGame.setActiveScreen(new OpenScreen());
        }
    }
}