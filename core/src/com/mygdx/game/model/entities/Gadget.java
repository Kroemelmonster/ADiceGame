package com.mygdx.game.model.entities;

import com.mygdx.game.model.definitions.GadgetType;
import lombok.Getter;

@Getter
public class Gadget extends GadgetType implements Comparable<Gadget> {
    private Integer row;
    private Integer col;

    public Gadget(GadgetType type, int row, int col) {
        super(type);
        this.row = row;
        this.col = col;
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
}
