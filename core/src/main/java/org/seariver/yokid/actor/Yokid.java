package org.seariver.yokid.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

public class Yokid extends BaseActor {

    public static final float MOVE_X_FACTOR = 5f;
    private final Animation<TextureRegion> animation;
    private Sprite yokidSprite;
    private float stateTime;

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

        animation = new Animation(0.08f, textureArray, Animation.PlayMode.LOOP);

        TextureRegion region = animation.getKeyFrame(stateTime);
        yokidSprite.setRegion(region);
        yokidSprite.setSize(tileWidth, tileHeight);
    }

    @Override
    public void act(float delta) {

        stateTime += delta;

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            setX(getX() - MOVE_X_FACTOR);
            yokidSprite.setRegion(animation.getKeyFrame(stateTime));
            yokidSprite.flip(true, false);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            setX(getX() + MOVE_X_FACTOR);
            yokidSprite.setRegion(animation.getKeyFrame(stateTime));
            yokidSprite.flip(false, false);
        }

        super.act(delta);
    }
}
