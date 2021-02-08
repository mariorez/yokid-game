package org.seariver.yokid.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import org.seariver.yokid.BaseScreen;
import org.seariver.yokid.YokidGame;
import org.seariver.yokid.actor.Yokid;

import static org.seariver.yokid.BaseActor.setWorldBounds;

public class AnimationScreen extends BaseScreen {

    @Override
    public void initialize() {
        new Yokid(100, 100, mainStage);
        setWorldBounds(YokidGame.WIDTH, YokidGame.HEIGHT);
    }

    @Override
    public void update(float deltaTime) {
    }

    @Override
    public boolean keyDown(int keyCode) {

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            YokidGame.setActiveScreen(new OpenScreen());
        }

        return false;
    }
}
