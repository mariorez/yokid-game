package org.seariver.yokid.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import org.seariver.yokid.BaseActor;
import org.seariver.yokid.BaseScreen;
import org.seariver.yokid.YokidGame;

public class OpenScreen extends BaseScreen {

    @Override
    public void initialize() {
        BaseActor openTheme = new BaseActor(0, 0, mainStage);
        openTheme.loadTexture("open-screen.png");
    }

    @Override
    public void update(float deltaTime) {
    }

    public boolean keyDown(int keyCode) {

        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            YokidGame.setActiveScreen(new AnimationScreen());
        }

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }

        return false;
    }
}
