package com.mygdx.game.controller;

import com.mygdx.game.model.entities.Dice;
import com.mygdx.game.services.DiceActionService;
import com.mygdx.game.services.DiceService;
import com.mygdx.game.view.actors.DiceActor;

public class DiceController {
    private static DiceController instance = null;

    private DiceController() {
    }

    public static DiceController getInstance() {
        if (instance == null) {
            instance = new DiceController();
        }
        return instance;
    }

    public DiceActor createDiceActor(Dice dice) {
        DiceActor diceActor = new DiceActor(dice);

        LayerController.getInstance().getDiceLayer().addActor(diceActor);
        return diceActor;
    }



    public void init() {
        DrawDiceController.getInstance().updateTargets();
    }

    public void draw() {
        DrawDiceController.getInstance().drawDice();
    }

    public void increment(Dice dice, int i) {
        DiceService.getInstance().increment(dice, i);
        DiceActionService.getInstance().addPopAction(dice, dice.getValue());
    }
}
