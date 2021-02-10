package org.seariver.yokid.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class BaseActor extends Actor {

    private TextureRegion textureRegion;

    public BaseActor(float x, float y, Stage stage) {
        super();
        setPosition(x, y);
        stage.addActor(this);
    }

    public TextureRegion getImage() {
        return textureRegion;
    }

    public void setImage(String path) {
        Texture texture = new Texture(Gdx.files.internal(path));
        textureRegion = new TextureRegion(texture);
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
