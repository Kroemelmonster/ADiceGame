package com.mygdx.game.model.definitions;

import com.mygdx.game.model.entities.DiceSpot;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GadgetType {
    protected List<DiceSpot> spots = new ArrayList<>();
    @Getter
    protected final int height;
    @Getter
    protected final int width;

    public GadgetType(GadgetType type) {
        for (DiceSpot spot : type.spots) {
            this.spots.add(new DiceSpot(spot));
        }
        this.height = type.height;
        this.width = type.width;
    }

    protected GadgetType(int height, int width) {
        this.height = height;
        this.width = width;
    }

    protected GadgetType add(int x, int y, int align, DiceRule rule, DiceSpot.Type type) {
        spots.add(new DiceSpot(x, y, align, rule, type));
        return this;
    }

    public List<DiceSpot> getSpots() {
        return Collections.unmodifiableList(spots);
    }
}
