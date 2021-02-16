package org.seariver.yokid.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Yokid extends BaseActor {

    public Yokid(float x, float y, Stage stage) {
        super(x, y, stage);
        loadSprite("yokid-front.png");
    }

    @Override
    public void act(float delta) {

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            loadSprite("yokid-left.png");
            setX(getX() - 5f);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            loadSprite("yokid-right.png");
            setX(getX() + 5f);
        } else {
            loadSprite("yokid-front.png");
        }

        super.act(delta);
    }
}
