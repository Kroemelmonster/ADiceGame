package com.mygdx.game.model.entities;

import com.mygdx.game.controller.DiceController;
import lombok.Getter;

import java.util.Observable;

@Getter
public class Dice extends Observable {
    private int number;
    private boolean active = true;

    public Dice(int number) {
        this.number = number;
    }

    public Dice() {
        this.number = getNextRoll();
    }

    private int getNextRoll() {
        return (int) (Math.abs(Math.random() * 6F) + 1);
    }

    public void setNumber(int number) {
        this.number = number;
        DiceController.getInstance().updateDiceNumber(this);
    }

    public void setActive(boolean active) {
        this.active = active;
        setChanged();
        notifyObservers(Change.active);
    }

    public void dispose() {
        setChanged();
        notifyObservers(Change.dispose);
    }

    public void roll() {
        setNumber(getNextRoll());
    }

    public enum Change {number, dispose, active}
}
