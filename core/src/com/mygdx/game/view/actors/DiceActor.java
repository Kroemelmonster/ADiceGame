package com.mygdx.game.view.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.model.entities.Dice;
import com.mygdx.game.services.DraggableService;
import com.mygdx.game.services.RenderService;
import com.mygdx.game.view.render.Draggable;
import lombok.Getter;

public class DiceActor extends AbstractDiceActor implements Draggable {
    @Getter
    private Dice model;
    private Style style;
    private Image content;
    @Getter
    private float originalPositionY;
    @Getter
    private float originalPositionX;

    public DiceActor(Dice dice) {
        super();
        model = dice;
        model.setView(this);
        Skin skin = RenderService.getInstance().getSkin();
        style = skin.get(Style.class);
        border.setColor(Color.OLIVE);
        content = addSubImage(null);
        content.setColor(style.contentColor);


        updateContent(dice.getValue());

        DraggableService.getInstance().addDraggableDiceListener(this);
    }

    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        originalPositionX = getX();
        originalPositionY = getY();
    }

    @Override
    public Actor getDraggableActor() {
        return this;
    }

    public void updateContent(int value) {
        Skin skin = RenderService.getInstance().getSkin();
        content.setDrawable(skin, style.dicePrefix + value);
    }

    private static class Style {
        private String dicePrefix;
        private Color contentColor;
    }
}
