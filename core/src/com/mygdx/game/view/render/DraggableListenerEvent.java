package com.mygdx.game.view.render;

import com.badlogic.gdx.scenes.scene2d.Actor;

public interface DraggableListenerEvent {
    void dragStart();

    void dragOverStart(Actor drag, Actor over);

    void dragOverEnd(Actor drag, Actor over);

    boolean drop(Actor drag, Actor drop);
}
