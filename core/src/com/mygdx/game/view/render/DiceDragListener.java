package com.mygdx.game.view.render;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.mygdx.game.services.DiceActionService;
import com.mygdx.game.view.actors.DiceActor;

public class DiceDragListener extends DragListener {
    private DiceActor diceActor;

    private DiceDroppable lastHit;

    public DiceDragListener(DiceActor diceActor) {
        super();
        this.diceActor = diceActor;
    }

    public void dragStart(InputEvent event, float x, float y, int pointer) {
        diceActor.toFront();
        DiceActionService.getInstance().reset(diceActor.getModel());
        diceActor.setTouchable(Touchable.disabled);
    }

    public void drag(InputEvent event, float x, float y, int pointer) {
        diceActor.moveBy(x - getDragStartX(), y - getDragStartY());
        DiceDroppable hit = getHit(event);
        // did we change from the lastHit ?
        if (lastHit != null && !lastHit.equals(hit)) {
            lastHit.dragOverEnd(diceActor);
        }
        // did we hit something new ?
        if (hit != null && !hit.equals(lastHit)) {
            hit.dragOverStart(diceActor);
        }
        lastHit = hit;
    }

    public void dragStop(InputEvent event, float x, float y, int pointer) {

        // are we currently above some Actor ?
        if (lastHit != null) {
            lastHit.dragOverEnd(diceActor);
        }
        DiceDroppable hit = getHit(event);
        diceActor.setTouchable(Touchable.enabled);
        boolean dropLegit = false;

        if (hit != null) {
            dropLegit = hit.drop(diceActor);
        }

        if (!dropLegit) {
            DiceActionService.getInstance().addReturnAction(diceActor.getModel());
        }
    }

    private DiceDroppable getHit(InputEvent event) {
        Actor actor = event.getStage().hit(event.getStageX(), event.getStageY(), true);
        if (actor instanceof DiceDroppable) {
            return (DiceDroppable) actor;
        }
        return null;
    }
}
