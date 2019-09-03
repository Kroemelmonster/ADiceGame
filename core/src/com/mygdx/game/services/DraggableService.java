package com.mygdx.game.services;

import com.mygdx.game.view.actors.DiceActor;
import com.mygdx.game.view.render.DiceDragListener;

public class DraggableService {
    private static DraggableService instance = null;

    private DiceDragListener diceDragListenerEvent;

    private DraggableService() {
    }

    public static DraggableService getInstance() {
        if (instance == null) {
            instance = new DraggableService();
        }
        return instance;
    }

    public void addDraggableDiceListener(DiceActor diceActor) {
        diceActor.addListener(new DiceDragListener(diceActor));
    }
}
