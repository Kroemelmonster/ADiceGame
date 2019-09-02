package com.mygdx.game.model.definitions;

import com.badlogic.gdx.utils.Align;
import com.mygdx.game.model.entities.DiceSpot;

public class GadgetTypes {
    public static GadgetType DEFAULT, ONE, TWO;

    public static void init() {
        DEFAULT = new GadgetType(2, 4)
                .add(1, 0, Align.topRight, DiceRules.EVEN, DiceSpot.Type.DRAW)
                .add(1, 1, Align.bottomRight, DiceRules.EVEN, DiceSpot.Type.DRAW)
                .add(2, 1, Align.bottomLeft, DiceRules.EVEN, DiceSpot.Type.DRAW)
                .add(2, 0, Align.topLeft, DiceRules.EVEN, DiceSpot.Type.DRAW);

        ONE = new GadgetType(1, 1)
                .add(0, 0, Align.center, DiceRules.ODD, DiceSpot.Type.NORMAL);

        TWO = new GadgetType(1, 2)
                .add(0, 0, Align.right, DiceRules.EVEN, DiceSpot.Type.NORMAL)
                .add(1, 0, Align.left, DiceRules.EVEN, DiceSpot.Type.NORMAL);
    }
}
