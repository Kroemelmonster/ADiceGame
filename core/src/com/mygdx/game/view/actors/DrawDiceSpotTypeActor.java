package com.mygdx.game.view.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.controller.DrawDiceController;

public class DrawDiceSpotTypeActor extends DiceSpotTypeLabelActor implements DiceSpotTypeActor {

    protected DrawDiceSpotTypeActor(DiceSpotActor spot, Skin skin) {
        super(" ", skin);
        this.setColor(Color.BLACK);
    }

    public void updateContent(DiceSpotActor spot) {
        int index = DrawDiceController.getInstance().getIndex(spot);
        this.setText(index + 1);
    }
}
