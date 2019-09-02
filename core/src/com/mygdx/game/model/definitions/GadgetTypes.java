package com.mygdx.game.model.definitions;

import com.badlogic.gdx.utils.Align;
import com.mygdx.game.model.entities.DiceSpotType;
import com.mygdx.game.model.entities.GadgetType;

public class GadgetTypes {
    public static GadgetType DEFAULT, ONE, TWO;

    public static void init() {
        DEFAULT = new GadgetType(2, 4, GadgetActions.INCREMENT)
                .add(1, 0, Align.topRight, DiceRules.EVEN, DiceSpotType.Category.DRAW)
                .add(1, 1, Align.bottomRight, DiceRules.EVEN, DiceSpotType.Category.DRAW)
                .add(2, 1, Align.bottomLeft, DiceRules.EVEN, DiceSpotType.Category.DRAW)
                .add(2, 0, Align.topLeft, DiceRules.EVEN, DiceSpotType.Category.DRAW);

        ONE = new GadgetType(1, 1, GadgetActions.INCREMENT)
                .add(0, 0, Align.center, DiceRules.ODD, DiceSpotType.Category.DRAW);

        TWO = new GadgetType(1, 2, GadgetActions.NOTHING)
                .add(0, 0, Align.right, DiceRules.EVEN, DiceSpotType.Category.DRAW)
                .add(1, 0, Align.left, DiceRules.EVEN, DiceSpotType.Category.NORMAL);
    }
}
