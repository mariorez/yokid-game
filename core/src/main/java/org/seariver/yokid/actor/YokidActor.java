package org.seariver.yokid.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class YokidActor extends BaseActor {

    public YokidActor(float x, float y, Stage stage) {
        super(x, y, stage);
        setImage("yokid-front.png");
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            setImage("yokid-left.png");
            setX(getX() - 5);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            setImage("yokid-right.png");
            setX(getX() + 5);
        } else {
            setImage("yokid-front.png");
        }
    }
}
