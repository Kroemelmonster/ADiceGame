package com.mygdx.game.view.actors;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;

public class DiceSpotTypeLabelActor extends Label {

    protected DiceSpotTypeLabelActor(CharSequence text, Skin skin) {
        super(text, skin);
        this.setWidth(AbstractDiceActor.getSize());
        this.setAlignment(Align.center);
    }

    public Actor getActor() {
        return this;
    }
}
