package com.mygdx.game.view.render;

import com.badlogic.gdx.scenes.scene2d.Actor;

public interface Draggable {
    float getOriginalPositionX();

    float getOriginalPositionY();

    Actor getDraggableActor();
}
