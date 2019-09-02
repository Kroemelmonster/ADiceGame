package com.mygdx.game.model.definitions;

import com.mygdx.game.controller.DiceController;
import com.mygdx.game.model.entities.Dice;

public class DiceActions {
    public static DiceAction ADD, DISCARD;

    public static void init() {
        DiceActions.ADD = new DiceAction() {
            @Override
            public boolean act(Dice dice) {
                DiceController.getInstance().increment(dice, 1);
                return true;
            }
        };
        DiceActions.DISCARD = new DiceAction() {
            @Override
            public boolean act(Dice dice) {
                DiceController.getInstance().dispose(dice);
                return false;
            }
        };
    }
}
