package com.mygdx.game.view.actors;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.services.RenderService;

public abstract class AbstractDiceActor extends Group {
    protected Image background;
    protected Image border;

    private static Style style;

    public AbstractDiceActor() {
        super();
        createStyle();
        Skin skin = RenderService.getInstance().getSkin();
        setWidth(style.size);
        setHeight(style.size);
        setOrigin(Align.center);

        this.background = addSubImage(style.background);
        this.border = addSubImage(style.border);
    }

    private static void createStyle() {
        if (style == null) {
            style = RenderService.getInstance().getSkin().get(Style.class);
        }
    }

    public static float getSize() {
        createStyle();
        return style.size;
    }

    public void setCenterPosition(float x, float y) {
        setPosition(x - getWidth() / 2, y - getHeight() / 2);
    }

    protected Image addSubImage(Drawable drawable) {
        Image image;
        if (drawable == null) {
            image = new Image();
        } else {
            image = new Image(drawable);
        }
        image.setWidth(style.size);
        image.setHeight(style.size);
        this.addActor(image);
        return image;
    }

    private static class Style {
        private Drawable background;
        private Drawable border;
        private float size;
    }
}
