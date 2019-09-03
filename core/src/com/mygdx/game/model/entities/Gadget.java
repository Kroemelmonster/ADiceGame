package com.mygdx.game.model.entities;

import com.google.common.collect.ImmutableList;
import com.mygdx.game.view.actors.GadgetActor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Getter
public class Gadget implements Comparable<Gadget> {
    private GadgetType type;
    private List<DiceSpot> spots = new ArrayList<>();
    private Integer row;
    private Integer col;
    @Setter
    private GadgetActor view;

    public Gadget(GadgetType type, int row, int col) {
        this.type = type;
        this.row = row;
        this.col = col;
        type.forEachSpot(diceSpotType -> spots.add(new DiceSpot(diceSpotType, this)));
    }

    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public int compareTo(Gadget other) {
        int compare = row.compareTo(other.row);
        if (compare == 0) {
            compare = col.compareTo(other.col);
        }
        return compare;
    }

    public void forEachSpot(Consumer<? super DiceSpot> action) {
        spots.forEach(action);
    }

    public List<DiceSpot> getSpots() {
        return ImmutableList.copyOf(spots);
    }

    public List<Dice> getAllDice() {
        return spots.stream().filter(DiceSpot::hasDice).map(DiceSpot::getDice).collect(Collectors.toList());
    }

    public void forEachDice(Consumer<? super Dice> action) {
        spots.stream().filter(DiceSpot::hasDice).map(DiceSpot::getDice).forEach(action);
    }

    public boolean isFull() {
        return spots.stream().allMatch(DiceSpot::hasDice);
    }

    public boolean isEmpty() {
        return spots.stream().noneMatch(DiceSpot::hasDice);
    }
}
