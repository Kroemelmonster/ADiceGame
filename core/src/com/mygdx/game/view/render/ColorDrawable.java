package com.mygdx.game.view.render;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable;
import com.mygdx.game.view.services.Assets;
import lombok.Getter;
import lombok.Setter;

public class ColorDrawable extends BaseDrawable {
    @Getter
    @Setter
    private Color color;

    public ColorDrawable(Color color) {
        this.color = color;
    }

    @Override
    public void draw(Batch batch, float x, float y, float width, float height) {
        batch.setColor(color);
        batch.draw(Assets.WHITE, x, y, width, height);
    }
}
