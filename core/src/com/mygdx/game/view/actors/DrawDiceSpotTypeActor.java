package com.mygdx.game.view.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class DrawDiceSpotTypeActor extends DiceSpotTypeLabelActor implements DiceSpotTypeActor {

    protected DrawDiceSpotTypeActor(DiceSpotActor spot, Skin skin) {
        super("W", skin);
        this.setColor(Color.BLACK);
    }

    public void updateContent(DiceSpotActor spot) {
        this.setText("W");
    }
}
