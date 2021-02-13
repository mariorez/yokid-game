package org.seariver.yokid.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.HashMap;
import java.util.Map;


public class BaseActor extends Actor {

    private Texture currentTexture;
    private Map<String, Texture> textureMap;

    public BaseActor(float x, float y, Stage stage) {
        super();
        setPosition(x, y);
        stage.addActor(this);
        textureMap = new HashMap<>();
    }

    public Texture getImage() {
        return currentTexture;
    }

    public void setImage(String path) {
        if (textureMap.containsKey(path)) {
            currentTexture = textureMap.get(path);
            setSize(currentTexture.getWidth(), currentTexture.getHeight());
            return;
        }
        currentTexture = new Texture(Gdx.files.internal(path));
        textureMap.put(path, currentTexture);
        setSize(currentTexture.getWidth(), currentTexture.getHeight());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (getImage() != null) batch.draw(getImage(), getX(), getY());
        super.draw(batch, parentAlpha);
    }
}
