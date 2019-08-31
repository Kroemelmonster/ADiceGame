package com.mygdx.game.view.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.mygdx.game.view.render.ColorDrawable;

public class Panel extends Group {
    private ColorDrawable background;

    public Panel() {
        setTouchable(Touchable.childrenOnly);
    }

    public void draw(Batch batch, float parentAlpha) {
        if (background != null) {
            background.draw(batch, getX(), getY(), getWidth(), getHeight());
        }
        super.draw(batch, parentAlpha);
    }

    public void setBackgroundColor(Color backgroundColor) {
        if (this.background == null) {
            this.background = new ColorDrawable(backgroundColor);
        } else {
            this.background.setColor(backgroundColor);
        }

    }
}
