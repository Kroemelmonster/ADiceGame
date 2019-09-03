package com.mygdx.game.services;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.actions.TemporalAction;
import com.badlogic.gdx.utils.Array;

public class ActionService {
    private static ActionService instance = null;

    private ActionService() {
    }

    public static ActionService getInstance() {
        if (instance == null) {
            instance = new ActionService();
        }
        return instance;
    }

    private void finishAction(Action action) {
        if (action instanceof ParallelAction) {
            ParallelAction parallelAction = (ParallelAction) action;

            for (Action innerAction : new Array.ArrayIterator<>(parallelAction.getActions())) {
                finishAction(innerAction);
            }
        } else {
            action.act(1000F);
        }
    }

    private float getRemainingDurationRec(Action action) {
        if (action instanceof SequenceAction) {
            SequenceAction sequenceAction = (SequenceAction) action;

            float count = 0F;
            for (Action innerAction : new Array.ArrayIterator<>(sequenceAction.getActions())) {
                count += getRemainingDurationRec(innerAction);
            }
            return count;

        } else if (action instanceof ParallelAction) {
            ParallelAction parallelAction = (ParallelAction) action;

            float currentMax = 0F;
            for (Action innerAction : new Array.ArrayIterator<>(parallelAction.getActions())) {
                currentMax = Math.max(currentMax, getRemainingDurationRec(innerAction));
            }
            return currentMax;
        } else if (action instanceof TemporalAction) {
            TemporalAction temporalAction = (TemporalAction) action;

            return temporalAction.getDuration() - temporalAction.getTime();
        }

        return 0;
    }

    public float getRemainingDuration(Actor actor) {
        if (actor.getActions().size != 1) {
            return 0;
        }
        Action action = actor.getActions().get(0);
        return getRemainingDurationRec(action);
    }

    private SequenceAction getActorSequenceAction(Actor actor) {
        if (actor.getActions().size == 1) {
            // TODO what if that doesnt not work ? ... whatever
            return (SequenceAction) actor.getActions().get(0);
        }
        return null;
    }

    public void addAction(Actor actor, Action action) {
        SequenceAction sequenceAction = getActorSequenceAction(actor);
        if (sequenceAction == null) {
            sequenceAction = new SequenceAction();
            actor.addAction(sequenceAction);
        }

        sequenceAction.addAction(action);
    }


    public void reset(Actor actor) {
        SequenceAction sequenceAction = getActorSequenceAction(actor);
        if (sequenceAction == null) {
            return;
        }
        float savedX = actor.getX();
        float savedY = actor.getY();
        finishAction(sequenceAction);

        actor.setPosition(savedX, savedY);
    }
}
