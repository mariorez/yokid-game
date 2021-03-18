package org.seariver.yokid.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

import static com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP;

public class Yokid extends BaseActor {

    public static final float MOVE_X_FACTOR = 5f;
    public static final float ANIMATION_FRAME_DURATION = 0.08f;

    private final Animation<TextureRegion> animation;
    private Sprite yokidSprite;
    private float stateTime;

    private enum Direction {LEFT, RIGHT}

    private Direction facing = Direction.RIGHT;

    public Yokid(float x, float y, Stage stage) {

        super(x, y, stage);

        yokidSprite = loadSprite("yokid-walk-sheet.png");

        Texture texture = yokidSprite.getTexture();
        int tileWidth = texture.getWidth() / 4;
        int tileHeight = texture.getHeight();

        TextureRegion[][] regions = TextureRegion.split(texture, tileWidth, tileHeight);
        Array<TextureRegion> textureArray = new Array<>();
        for (int col = 0; col < 4; col++) {
            textureArray.add(regions[0][col]);
        }

        animation = new Animation<>(ANIMATION_FRAME_DURATION, textureArray, LOOP);
        TextureRegion region = animation.getKeyFrame(stateTime);

        yokidSprite.setRegion(region);
        yokidSprite.setSize(tileWidth, tileHeight);
        setSize(tileWidth, tileHeight);
    }

    @Override
    public void act(float delta) {

        yokidSprite.setRegion(animation.getKeyFrame(0));

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            setX(getX() - MOVE_X_FACTOR);
            yokidSprite.setRegion(animation.getKeyFrame(stateTime += delta));
            facing = Direction.LEFT;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            setX(getX() + MOVE_X_FACTOR);
            yokidSprite.setRegion(animation.getKeyFrame(stateTime += delta));
            facing = Direction.RIGHT;
        }

        yokidSprite.flip((facing == Direction.LEFT), false);

        alignCamera();
        boundToWorld();

        super.act(delta);
    }
}
