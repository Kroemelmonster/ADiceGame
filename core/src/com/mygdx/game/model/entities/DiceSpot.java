package com.mygdx.game.model.entities;

import com.mygdx.game.model.definitions.DiceRule;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class DiceSpot {
    protected int x;
    protected int y;

    private DiceRule diceRule;

    public DiceSpot(DiceSpot spot) {
        this.x = spot.x;
        this.y = spot.y;
        this.diceRule = spot.diceRule;
    }
}
