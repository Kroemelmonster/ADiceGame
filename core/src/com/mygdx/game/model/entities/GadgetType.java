package com.mygdx.game.model.entities;

import com.mygdx.game.model.definitions.DiceRule;
import com.mygdx.game.model.definitions.GadgetAction;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Getter
public class GadgetType {
    @Getter(AccessLevel.NONE)
    private List<DiceSpotType> spots = new ArrayList<>();
    protected final int height;
    protected final int width;

    private GadgetAction action;

    public GadgetType(int height, int width, GadgetAction action) {
        this.height = height;
        this.width = width;
        this.action = action;
    }

    public GadgetType add(int x, int y, int align, DiceRule rule, DiceSpotType.Category type) {
        spots.add(new DiceSpotType(x, y, align, type, rule));
        return this;
    }

    public void forEachSpot(Consumer<? super DiceSpotType> action) {
        spots.forEach(action);
    }
}
