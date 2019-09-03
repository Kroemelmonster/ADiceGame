package com.mygdx.game.services;

import com.mygdx.game.model.entities.Dice;

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

    public void increment(Dice dice, int i) {
        int tooMuch = dice.increment(i);
    }
}
