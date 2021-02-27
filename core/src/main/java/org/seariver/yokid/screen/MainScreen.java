package org.seariver.yokid.screen;

import com.badlogic.gdx.Input;
import org.seariver.yokid.GameInitializer;
import org.seariver.yokid.actor.BaseActor;
import org.seariver.yokid.actor.Yokid;

public class MainScreen extends BaseScreen {

    private Yokid yokid;

    @Override
    public void initialize() {
        BaseActor background = new BaseActor(0, 0, mainStage);
        background.loadSprite("main-background.png");
        BaseActor.setWorldBounds(background.getWidth(), background.getHeight());

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
