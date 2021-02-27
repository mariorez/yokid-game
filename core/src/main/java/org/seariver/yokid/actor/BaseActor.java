package org.seariver.yokid.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.HashMap;
import java.util.Map;


public class BaseActor extends Group {

    private Sprite currentSprite;
    private Map<String, Sprite> textureMap;

    // stores size of game world for all actors
    private static Rectangle worldBounds;

    public BaseActor(float x, float y, Stage stage) {
        super();
        setPosition(x, y);
        stage.addActor(this);
        textureMap = new HashMap<>();
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

    public Sprite loadSprite(String path) {
        if (textureMap.containsKey(path)) {
            currentSprite = textureMap.get(path);
        } else {
            currentSprite = new Sprite(new Texture(Gdx.files.internal(path)));
            textureMap.put(path, currentSprite);
        }

        setSize(currentSprite.getWidth(), currentSprite.getHeight());

        return currentSprite;
    }

    /**
     * Set world dimensions for use by methods boundToWorld() and scrollTo().
     *
     * @param width  width of world
     * @param height height of world
     */
    public static void setWorldBounds(float width, float height) {
        worldBounds = new Rectangle(0, 0, width, height);
    }

    /**
     * If an edge of an object moves past the world bounds,
     * adjust its position to keep it completely on screen.
     */
    public void boundToWorld() {
        if (getX() < 0) setX(0);
        if (getY() < 0) setY(0);
        if (getX() + getWidth() > worldBounds.width) setX(worldBounds.width - getWidth());
        if (getY() + getHeight() > worldBounds.height) setY(worldBounds.height - getHeight());
    }

    /**
     * Center camera on this object, while keeping camera's range of view
     * (determined by screen size) completely within world bounds.
     */
    public void alignCamera() {
        Camera cam = this.getStage().getCamera();

        // center camera on actor
        cam.position.set(this.getX() + this.getOriginX(), this.getY() + this.getOriginY(), 0);

        // bound camera to layout
        cam.position.x = MathUtils.clamp(cam.position.x, cam.viewportWidth / 2, worldBounds.width - cam.viewportWidth / 2);
        cam.position.y = MathUtils.clamp(cam.position.y, cam.viewportHeight / 2, worldBounds.height - cam.viewportHeight / 2);
        cam.update();
    }
}
