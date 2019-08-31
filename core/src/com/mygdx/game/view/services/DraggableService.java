package com.mygdx.game.view.services;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.DependencyInjection;
import com.mygdx.game.model.services.DiceService;
import com.mygdx.game.view.actors.DiceActor;
import com.mygdx.game.view.actors.UsableActor;
import com.mygdx.game.view.render.DraggableListener;
import com.mygdx.game.view.render.DraggableListenerEvent;

public class DraggableService {
    private DraggableListenerEvent diceDraggableListenerEvent;
    private CursorService cursorService = DependencyInjection.getCursorService();
    private DiceService diceService = DependencyInjection.getDiceService();

    public DraggableService() {
        diceDraggableListenerEvent = new DraggableListenerEvent() {
            @Override
            public void dragStart() {
                cursorService.setCursor(CursorService.CursorType.drag);
            }

            @Override
            public void dragOverStart(Actor drag, Actor over) {
                if (!(over instanceof UsableActor)) {
                    return;
                }
                DiceActor dice = (DiceActor) drag;
                UsableActor usable = (UsableActor) over;

                boolean isUsable = diceService.isUsable(dice.getDice(), usable.getUsable());

                usable.enableDragOver(isUsable);
            }

            @Override
            public void dragOverEnd(Actor drag, Actor over) {
                if (!(over instanceof UsableActor)) {
                    return;
                }
                UsableActor usableActor = (UsableActor) over;

                usableActor.clearDragOver();
            }

            @Override
            public boolean drop(Actor drag, Actor drop) {
                cursorService.setCursor(CursorService.CursorType.cursor);

                if (!(drop instanceof UsableActor)) {
                    return true;
                }
                DiceActor dice = (DiceActor) drag;
                UsableActor usable = (UsableActor) drop;

                return diceService.useUsable(dice.getDice(), usable.getUsable());
            }
        };
    }

    public void addDraggableDiceListener(DiceActor dice) {
        dice.addListener(new DraggableListener(dice, diceDraggableListenerEvent));
    }
}
