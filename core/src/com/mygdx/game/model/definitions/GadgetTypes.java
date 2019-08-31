package com.mygdx.game.model.definitions;

public class GadgetTypes {
    public static GadgetType DEFAULT, ONE, TWO;

    public static void init() {
        DEFAULT = new GadgetType()
                .add(0, 0, DiceRules.EVEN)
                .add(0, 1, DiceRules.EVEN)
                .add(1, 1, DiceRules.EVEN)
                .add(1, 0, DiceRules.EVEN)
                .add(2, 0, DiceRules.ODD)
                .add(2, 1, DiceRules.ODD)
                .add(3, 1, DiceRules.ODD)
                .add(3, 0, DiceRules.ODD);

        ONE = new GadgetType()
                .add(0, 0, DiceRules.EVEN);

        TWO = new GadgetType()
                .add(0, 0, DiceRules.EVEN)
                .add(1, 0, DiceRules.EVEN);
    }
}
