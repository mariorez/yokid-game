package org.seariver.yokid.actor;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import org.seariver.yokid.BaseActor;

import static com.badlogic.gdx.Gdx.input;

public class Yokid extends BaseActor {

    private Animation stand;
    private Animation left;
    private Animation right;

    public Yokid(float x, float y, Stage stage) {

        super(x, y, stage);

        stand = loadTexture("yokid-front.png");
        left = loadTexture("yokid-left.png");
        right = loadTexture("yokid-right.png");

        setAcceleration(800);
        setMaxSpeed(110);
        setDeceleration(800);
        setBoundaryRectangle();
    }

    @Override
    public void act(float deltaTime) {
        super.act(deltaTime);

        if (input.isKeyPressed(Input.Keys.LEFT)) {
            setAnimation(left);
            accelerateAtAngle(180);
        }

        if (input.isKeyPressed(Input.Keys.RIGHT)) {
            setAnimation(right);
            accelerateAtAngle(0);
        }

        if (!isMoving()) {
            setAnimation(stand);
        }

        boundToWorld();
        applyPhysics(deltaTime);
    }
}
