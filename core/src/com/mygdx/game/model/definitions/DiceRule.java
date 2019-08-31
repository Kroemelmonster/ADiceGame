package com.mygdx.game.model.definitions;

import com.mygdx.game.model.entities.Dice;

public abstract class DiceRule {
    public abstract boolean check(Dice dice);
}
