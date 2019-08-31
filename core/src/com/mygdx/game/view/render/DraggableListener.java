package com.mygdx.game.view.render;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

public class DraggableListener extends DragListener {
    private Actor actor;
    private Draggable draggable;
    private DraggableListenerEvent listenerEvent;
    private MoveToAction moveBack;

    private Actor lastDragOver;

    public DraggableListener(Draggable draggable, DraggableListenerEvent listenerEvent) {
        super();
        this.draggable = draggable;
        this.actor = draggable.getDraggableActor();
        this.listenerEvent = listenerEvent;
    }

    public void dragStart(InputEvent event, float x, float y, int pointer) {
        actor.toFront();
        actor.setTouchable(Touchable.disabled);
        if (moveBack != null) {
            actor.removeAction(moveBack);
        }

        moveBack = Actions.moveTo(draggable.getOriginalPositionX(), draggable.getOriginalPositionY(),
                1, Interpolation.fastSlow);

        listenerEvent.dragStart();
    }

    public void drag(InputEvent event, float x, float y, int pointer) {
        actor.moveBy(x - getDragStartX(), y - getDragStartY());

        Actor hit = event.getStage().hit(event.getStageX(), event.getStageY(), true);
        if (lastDragOver != null && !lastDragOver.equals(hit)) {
            listenerEvent.dragOverEnd(actor, lastDragOver);
        }
        if (hit != null && !hit.equals(lastDragOver)) {
            listenerEvent.dragOverStart(actor, hit);
        }
        lastDragOver = hit;
    }

    public void dragStop(InputEvent event, float x, float y, int pointer) {
        if (lastDragOver != null) {
            listenerEvent.dragOverEnd(actor, lastDragOver);
        }
        Actor hit = event.getStage().hit(event.getStageX(), event.getStageY(), true);
        actor.setTouchable(Touchable.enabled);
        boolean shouldContinue = listenerEvent.drop(actor, hit);

        if (shouldContinue) {
            actor.addAction(moveBack);
        }
    }
}
