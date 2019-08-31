package com.mygdx.game.model.definitions;

import com.mygdx.game.model.entities.Dice;

public class DiceActions {
    public static DiceAction ADD, DISCARD;

    public static void init() {
        DiceActions.ADD = new DiceAction() {
            @Override
            public boolean act(Dice dice) {
                dice.setNumber(dice.getNumber() + 1);
                return true;
            }
        };
        DiceActions.DISCARD = new DiceAction() {
            @Override
            public boolean act(Dice dice) {
                dice.dispose();
                return false;
            }
        };
    }
}
