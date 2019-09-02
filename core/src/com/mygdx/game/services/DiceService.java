package com.mygdx.game.services;

import com.mygdx.game.model.entities.Dice;
import com.mygdx.game.model.entities.Usable;

public class DiceService {
    private static DiceService instance = null;

    private DiceService() {
    }

    public static DiceService getInstance() {
        if (instance == null) {
            instance = new DiceService();
        }
        return instance;
    }

    public boolean isUsable(Dice dice, Usable usable) {
        return usable.isUsable(dice);
    }

    public boolean useUsable(Dice dice, Usable usable) {
        if (usable.isUsable(dice)) {
            return usable.use(dice);
        }
        return true;
    }

    public void increment(Dice dice, int i) {
        int tooMuch = dice.increment(i);
    }
}
