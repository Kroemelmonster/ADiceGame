package com.mygdx.game.controller;

import com.mygdx.game.model.entities.Dice;
import com.mygdx.game.model.entities.DiceSpot;
import com.mygdx.game.model.entities.Gadget;
import com.mygdx.game.services.ActionService;
import com.mygdx.game.services.DiceActionService;
import com.mygdx.game.view.actors.DiceActor;
import com.mygdx.game.view.actors.GadgetActor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class GadgetController {
    private static GadgetController instance = null;

    private GadgetController() {
    }

    public static GadgetController getInstance() {
        if (instance == null) {
            instance = new GadgetController();
        }
        return instance;
    }

    public void init() {


    }

    public void putDice(Dice dice, DiceSpot spot) {
        spot.setDice(dice);
        dice.setSpot(spot);

        Gadget gadget = spot.getGadget();
        if (gadget.isFull()) {
            gadget.getType().getAction().act(gadget);
        }
    }

    private void addWaitForAllAction(Gadget gadget) {
        if (gadget.isEmpty()) {
            return;
        }

        List<Dice> dices = gadget.getAllDice();
        List<Float> remainingTimes = new ArrayList<>();
        dices.forEach(dice -> {
            float wait = ActionService.getInstance().getRemainingDuration(dice.getView());
            remainingTimes.add(wait);
        });
        Float max = Collections.max(remainingTimes);
        if (max > 0F) {
            for (int i = 0; i < dices.size(); i++) {
                Dice dice = dices.get(i);
                float waitTime = max - remainingTimes.get(i);
                if (waitTime > 0F) {
                    DiceActionService.getInstance().addWaitAction(dice, waitTime);
                }
            }
        }
    }

    public void incrementAll(Gadget gadget, int i) {
        addWaitForAllAction(gadget);
        gadget.forEachDice(dice -> DiceController.getInstance().increment(dice, i));
    }

    public void dragOverStart(DiceActor diceActor, GadgetActor gadgetActor) {
        Gadget gadget = gadgetActor.getModel();
        Optional<DiceSpot> optionalDiceSpot = gadget.getSpots().stream().filter(diceSpot -> !diceSpot.hasDice()).findFirst();
        optionalDiceSpot.ifPresent(diceSpot -> {
            DiceSpotController.getInstance().dragOverStart(diceActor, diceSpot.getView());
        });
    }

    public void dragOverEnd(DiceActor diceActor, GadgetActor gadgetActor) {
        Gadget gadget = gadgetActor.getModel();
        Optional<DiceSpot> optionalDiceSpot = gadget.getSpots().stream().filter(diceSpot -> !diceSpot.hasDice()).findFirst();
        optionalDiceSpot.ifPresent(diceSpot -> {
            DiceSpotController.getInstance().dragOverEnd(diceSpot.getView());
        });
    }

    public boolean drop(DiceActor diceActor, GadgetActor gadgetActor) {

        return true;
    }
}
