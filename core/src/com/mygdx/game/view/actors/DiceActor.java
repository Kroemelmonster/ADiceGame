package com.mygdx.game.view.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.DependencyInjection;
import com.mygdx.game.model.entities.Dice;
import com.mygdx.game.view.actions.ArcToAction;
import com.mygdx.game.view.render.Draggable;
import com.mygdx.game.view.services.DraggableService;
import com.mygdx.game.view.services.RenderService;
import lombok.Getter;

import java.util.Observable;
import java.util.Observer;

public class DiceActor extends AbstractDiceActor implements Observer, Draggable {
    private Style style;
    private Image content;
    @Getter
    private Dice dice;
    @Getter
    private float originalPositionY;
    @Getter
    private float originalPositionX;

    private DraggableService draggableService = DependencyInjection.getDraggableService();
    private RenderService renderService = DependencyInjection.getRenderService();

    public DiceActor(Dice dice) {
        super();
        this.dice = dice;
        Skin skin = renderService.getSkin();
        this.style = skin.get(Style.class);
        this.border.setColor(Color.OLIVE);
        this.content = addSubImage(null);
        this.content.setColor(style.contentColor);


        updateContent();

        dice.addObserver(this);

        draggableService.addDraggableDiceListener(this);
    }

    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        this.originalPositionX = this.getX();
        this.originalPositionY = this.getY();
    }

    @Override
    public Actor getDraggableActor() {
        return this;
    }

    @Override
    public void update(Observable observable, Object o) {
        Dice.Change whatGotChanged = (Dice.Change) o;
        switch (whatGotChanged) {
            case number:
                updateContent();
                break;
            case dispose:
                dispose();
                break;
            case active:
                updateActive();
                break;
        }
    }

    private void updateContent() {
        Skin skin = renderService.getSkin();
        this.content.setDrawable(skin, style.dicePrefix + dice.getNumber());
    }

    private void updateActive() {
        if (dice.isActive()) {
            this.setTouchable(Touchable.enabled);
        } else {
            this.setTouchable(Touchable.disabled);
        }
    }

    private void dispose() {
        ArcToAction arcToAction = new ArcToAction();
        arcToAction.setPosition(500, 50);
        arcToAction.setDuration(1F);
        arcToAction.setAlignment(1);
        arcToAction.setInterpolation(Interpolation.pow2);
        this.addAction(arcToAction);
    }

    public void updateNumber(Dice dice) {
        Skin skin = renderService.getSkin();
        content.setDrawable(skin, style.dicePrefix + dice.getNumber());
    }

    private static class Style {
        private String dicePrefix;
        private Color contentColor;
    }
}
