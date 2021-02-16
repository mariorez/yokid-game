package org.seariver.yokid.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.HashMap;
import java.util.Map;


public class BaseActor extends Actor {

    private Sprite currentSprite;
    private Map<String, Sprite> textureMap;

    public BaseActor(float x, float y, Stage stage) {
        super();
        setPosition(x, y);
        stage.addActor(this);
        textureMap = new HashMap<>();
    }

    public void loadSprite(String path) {
        if (textureMap.containsKey(path)) {
            currentSprite = textureMap.get(path);
        } else {
            currentSprite = new Sprite(new Texture(Gdx.files.internal(path)));
            textureMap.put(path, currentSprite);
        }

        setSize(currentSprite.getWidth(), currentSprite.getHeight());
    }

    @Override
    public void act(float delta) {
        currentSprite.setPosition(getX(), getY());
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (currentSprite != null) {
            currentSprite.draw(batch);
        }

        super.draw(batch, parentAlpha);
    }
}
