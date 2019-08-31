package com.mygdx.game.model.entities;

import com.mygdx.game.model.definitions.DiceAction;
import com.mygdx.game.model.definitions.DiceRule;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Usable {
    private int x;
    private int y;

    private DiceRule diceRule;
    private DiceAction diceAction;

    public boolean isUsable(Dice dice) {
        return this.diceRule.check(dice);
    }

    public boolean use(Dice dice) {
        return diceAction.act(dice);
    }
}
