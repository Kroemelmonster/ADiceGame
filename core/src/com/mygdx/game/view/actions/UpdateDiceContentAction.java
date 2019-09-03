package com.mygdx.game.view.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.mygdx.game.model.entities.Dice;
import lombok.Setter;

@Setter
public class UpdateDiceContentAction extends Action {
    private Dice dice;
    private int value;

    @Override
    public boolean act(float delta) {
        dice.getView().updateContent(value);
        return true;
    }
}
