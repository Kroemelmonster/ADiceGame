package com.mygdx.game.view.definitions;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;
import com.mygdx.game.model.entities.Dice;
import com.mygdx.game.view.actions.ArcToAction;
import com.mygdx.game.view.actions.MyRotateToAction;
import com.mygdx.game.view.actions.UpdateDiceContentAction;
import com.mygdx.game.view.actions.WaitAction;

public class MyActions {
    static public <T extends Action> T action(Class<T> type) {
        Pool<T> pool = Pools.get(type);
        T action = pool.obtain();
        action.setPool(pool);
        return action;
    }

    static public MyRotateToAction rotateTo(float rotation, float duration, Interpolation interpolation) {
        MyRotateToAction action = action(MyRotateToAction.class);
        action.setRotation(rotation);
        action.setDuration(duration);
        action.setInterpolation(interpolation);
        return action;
    }

    static public ArcToAction arcTo(Vector2 endPosition, Vector2 offset, ArcToAction.BezierPoints.Anchor anchor,
                                    float duration, Interpolation interpolation) {
        ArcToAction action = action(ArcToAction.class);
        action.setPosition(endPosition.x, endPosition.y);
        action.addPoint(offset, anchor);
        action.setDuration(duration);
        action.setInterpolation(interpolation);
        return action;
    }

    static public UpdateDiceContentAction updateDiceContent(Dice dice, int value) {
        UpdateDiceContentAction action = action(UpdateDiceContentAction.class);
        action.setDice(dice);
        action.setValue(value);
        return action;
    }

    static public WaitAction wait(float duration) {
        WaitAction action = action(WaitAction.class);
        action.setDuration(duration);
        return action;
    }
}
