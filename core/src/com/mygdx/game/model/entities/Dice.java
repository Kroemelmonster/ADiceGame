package com.mygdx.game.model.entities;

import com.mygdx.game.view.actors.DiceActor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dice {
    private DiceActor view;
    private int value;
    private boolean active = true;

    public Dice(int value) {
        this.value = value;
    }

    public Dice() {
        value = getNextRoll();
    }

    private int getNextRoll() {
        return (int) (Math.abs(Math.random() * 6F) + 1);
    }

    public void roll() {
        setValue(getNextRoll());
    }

    public int increment(int i) {
        int incrementTo = Math.min(Math.max(i + value, 1), 6);
        int overhead = (i + value) - incrementTo;
        value = incrementTo;

        return overhead;
    }
}
