package com.mygdx.game.view.render;

import com.mygdx.game.view.actors.DiceActor;

public interface DiceDroppable {
    void dragOverStart(DiceActor diceActor);

    void dragOverEnd(DiceActor diceActor);

    boolean drop(DiceActor diceActor);
}
