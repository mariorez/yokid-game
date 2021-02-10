package org.seariver.yokid.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import org.seariver.yokid.MainGame;
import org.seariver.yokid.actor.BaseActor;


public class OpenScreen extends BaseScreen {

    @Override
    public void initialize() {
        BaseActor actor = new BaseActor(0, 0, mainStage);
        actor.setImage("open-screen.png");
    }

    @Override
    public void update(float deltaTime) {
        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            MainGame.setActiveScreen(new MainScreen());
        }
    }
}
