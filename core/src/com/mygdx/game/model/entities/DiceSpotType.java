package com.mygdx.game.model.entities;

import com.mygdx.game.model.definitions.DiceRule;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class DiceSpotType {
    protected float x;
    protected float y;
    protected int align;
    protected Category category;
    protected DiceRule diceRule;


    public enum Category {NORMAL, DRAW}
}
