package com.mygdx.game.model.entities;

import com.mygdx.game.model.definitions.DiceRule;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class DiceSpot {
    protected float x;
    protected float y;
    protected int align;
    private Type type;

    private DiceRule diceRule;
    public DiceSpot(DiceSpot spot) {
        this.x = spot.x;
        this.y = spot.y;
        this.align = spot.align;
        this.diceRule = spot.diceRule;
        this.type = spot.type;
    }

    public enum Type {NORMAL, DRAW}
}
