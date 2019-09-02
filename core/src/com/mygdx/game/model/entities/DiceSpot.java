package com.mygdx.game.model.entities;

import com.mygdx.game.view.actors.DiceSpotActor;
import lombok.Getter;
import lombok.Setter;


@Getter
public class DiceSpot {
    private final DiceSpotType type;
    private final Gadget gadget;
    @Setter
    private Dice dice;

    @Setter
    private DiceSpotActor view;

    public DiceSpot(DiceSpotType diceSpotType, Gadget gadget) {
        type = diceSpotType;
        this.gadget = gadget;
    }

    public boolean hasDice() {
        return dice != null;
    }
}
