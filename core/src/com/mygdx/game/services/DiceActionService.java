package com.mygdx.game.services;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.mygdx.game.model.entities.Dice;
import com.mygdx.game.model.entities.DiceSpot;
import com.mygdx.game.view.actions.ArcToAction;
import com.mygdx.game.view.definitions.MyActions;

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


    public void addPopAction(Dice dice, int value) {
        SequenceAction sequenceAction = Actions.sequence(
                Actions.scaleTo(1.3F, 1.3F, 0.15F),
                MyActions.updateDiceContent(dice, value),
                Actions.scaleTo(1, 1, 0.15F));

        ActionService.getInstance().addAction(dice.getView(), sequenceAction);
    }

    public void addRollIntoAction(Dice dice, DiceSpot spot) {
        float duration = 1F;

        Vector2 endPosition = spot.getView().getPosition();
        Vector2 offset = new Vector2(0, 800);

        ArcToAction arcToAction = MyActions.arcTo(endPosition, offset,
                ArcToAction.BezierPoints.Anchor.start, duration, Interpolation.pow2);

        ParallelAction rollInAction = Actions.parallel(
                arcToAction,
                Actions.scaleTo(1, 1, duration),
                MyActions.rotateTo(-720, duration, Interpolation.pow2Out));


        SequenceAction sequenceAction = Actions.sequence(
                Actions.touchable(Touchable.disabled),
                rollInAction,
                Actions.touchable(Touchable.enabled));


        ActionService.getInstance().addAction(dice.getView(), sequenceAction);
    }

    public void addWaitAction(Dice dice, float waitTime) {
        ActionService.getInstance().addAction(dice.getView(), MyActions.wait(waitTime));
    }

    public void reset(Dice dice) {
        ActionService.getInstance().reset(dice.getView());
    }

    public void addReturnAction(Dice dice) {
        Vector2 position = dice.getSpot().getView().getPosition();

        Action moveBack = Actions.moveTo(position.x, position.y, 0.7F, Interpolation.pow2Out);
        ActionService.getInstance().addAction(dice.getView(), moveBack);
    }
}
