package com.mygdx.game.model.entities;

import com.mygdx.game.model.definitions.GadgetType;
import lombok.Getter;

@Getter
public class Gadget extends GadgetType {
    private int x;
    private int y;

    public Gadget(GadgetType type, int x, int y) {
        for (DiceSpot spot : type.getSpots()) {
            this.spots.add(new DiceSpot(spot));
        }
        this.x = x;
        this.y = y;
    }
}
