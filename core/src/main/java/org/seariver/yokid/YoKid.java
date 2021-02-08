package org.seariver.yokid;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class YoKid extends Game {

    SpriteBatch batch;
    Texture openScreen;

    @Override
    public void create() {
        batch = new SpriteBatch();
        openScreen = new Texture(Gdx.files.internal("open-screen.png"));
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(openScreen, 0, 0);
        batch.end();
    }
}
