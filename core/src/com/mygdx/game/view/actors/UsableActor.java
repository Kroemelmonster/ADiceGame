package com.mygdx.game.view.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.mygdx.game.model.entities.Usable;
import lombok.Getter;

public class UsableActor extends Image {
    @Getter
    private Usable usable;

    public UsableActor(Usable usable, Skin skin) {
        super();
        this.usable = usable;
        this.setWidth(200);
        this.setHeight(200);
        this.setX(usable.getX() * 210);
        this.setY(usable.getY() * 210);

        Style style = skin.get(Style.class);
        this.setDrawable(style.background);
    }

    public void enableDragOver(boolean usable) {
        if (usable) {
            this.setColor(Color.GREEN);
        } else {
            this.setColor(Color.RED);
        }
    }

    public void clearDragOver() {
        this.setColor(Color.WHITE);
    }

    private static class Style {
        private Drawable background;
    }
}
