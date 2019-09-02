package com.mygdx.game.services;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.mygdx.game.model.entities.Dice;

public class DiceActionService {
    private static DiceActionService instance = null;

    private DiceActionService() {
    }

    public static DiceActionService getInstance() {
        if (instance == null) {
            instance = new DiceActionService();
        }
        return instance;
    }

    private Action createUpdateContentAction(Dice dice, int value) {
        return new Action() {
            @Override
            public boolean act(float delta) {
                dice.getView().updateContent(value);
                return true;
            }
        };
    }

    public void addPopAction(Dice dice, int value) {
        SequenceAction sequenceAction = new SequenceAction();
        sequenceAction.addAction(Actions.scaleTo(1.3F, 1.3F, 0.15F));
        sequenceAction.addAction(createUpdateContentAction(dice, value));
        sequenceAction.addAction(Actions.scaleTo(1, 1, 0.15F));

        ActionService.getInstance().addAction(dice.getView(), sequenceAction);
    }
}
