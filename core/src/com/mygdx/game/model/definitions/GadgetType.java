package com.mygdx.game.model.definitions;

import com.mygdx.game.model.entities.DiceSpot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GadgetType {
    protected List<DiceSpot> spots = new ArrayList<>();

    public GadgetType() {

    }

    protected GadgetType add(int x, int y, DiceRule rule) {
        spots.add(new DiceSpot(x, y, rule));
        return this;
    }

    public List<DiceSpot> getSpots() {
        return Collections.unmodifiableList(spots);
    }
}
