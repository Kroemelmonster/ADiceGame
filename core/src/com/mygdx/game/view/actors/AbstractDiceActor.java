package com.mygdx.game.view.actors;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.services.RenderService;

public abstract class AbstractDiceActor extends Group {
    protected Group innerGroup;

    protected Image background;
    protected Image border;

    private static Style style;

    public AbstractDiceActor() {
        super();
        createStyle();
        innerGroup = new Group();
        innerGroup.setTouchable(Touchable.disabled);
        addActor(innerGroup);

        setWidth(style.size);
        setHeight(style.size);
        setOrigin(Align.center);

        background = addSubImage(style.background);
        border = addSubImage(style.border);
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
        addSubActor(image);
        return image;
    }

    protected void addSubActor(Actor actor) {
        innerGroup.addActor(actor);
    }

    private static class Style {
        private Drawable background;
        private Drawable border;
        private float size;
    }
}
