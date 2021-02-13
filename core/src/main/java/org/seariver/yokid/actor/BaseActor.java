package org.seariver.yokid.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class BaseActor extends Actor {

    private Texture texture;

    public BaseActor(float x, float y, Stage stage) {
        super();
        setPosition(x, y);
        stage.addActor(this);
    }

    public Texture getImage() {
        return texture;
    }

    public void setImage(String path) {
        texture = new Texture(Gdx.files.internal(path));
        setSize(texture.getWidth(), texture.getHeight());
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
