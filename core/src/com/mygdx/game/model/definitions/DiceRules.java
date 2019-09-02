package com.mygdx.game.model.definitions;

import com.mygdx.game.model.entities.Dice;

public class DiceRules {
    public static DiceRule ODD, EVEN;

    public static void init() {
        DiceRules.EVEN = new DiceRule() {
            @Override
            public boolean check(Dice dice) {
                return isEven(dice.getValue());
            }
        };

        DiceRules.ODD = new DiceRule() {
            @Override
            public boolean check(Dice dice) {
                return !isEven(dice.getValue());
            }
        };
    }

    private static boolean isEven(int number) {
        return (number % 2) == 0;
    }
}
