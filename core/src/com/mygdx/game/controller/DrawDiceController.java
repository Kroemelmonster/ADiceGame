package com.mygdx.game.controller;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.model.entities.Dice;
import com.mygdx.game.model.entities.DiceSpot;
import com.mygdx.game.model.entities.DiceSpotType;
import com.mygdx.game.model.entities.GadgetGrid;
import com.mygdx.game.services.DiceActionService;
import com.mygdx.game.view.actors.DiceActor;
import com.mygdx.game.view.actors.DiceSpotActor;
import lombok.extern.java.Log;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

@Log
public class DrawDiceController {
    private static DrawDiceController instance = null;

    private DrawDiceController() {
    }

    public static DrawDiceController getInstance() {
        if (instance == null) {
            instance = new DrawDiceController();
        }
        return instance;
    }

    private List<DiceSpot> targets = new LinkedList<>();

    public void drawDice() {
        Optional<DiceSpot> optionalDiceSpot = getNextFreeDiceSpot();
        if (!optionalDiceSpot.isPresent()) {
            log.log(Level.WARNING, "No more DiceSpots to roll something into");
            return;
        }
        DiceSpot spot = optionalDiceSpot.get();

        Dice dice = new Dice();
        DiceActor diceActor = DiceController.getInstance().createDiceActor(dice);


        LayerController layerController = LayerController.getInstance();
        Vector2 startPosition = layerController.getTheShaker().getDiceStartPosition();

        diceActor.setCenterPosition(startPosition.x, startPosition.y);
        diceActor.setScale(0);

        DiceActionService.getInstance().addRollIntoAction(dice, spot);


        GadgetController.getInstance().putDice(dice, spot);

    }

    private Optional<DiceSpot> getNextFreeDiceSpot() {
        return targets.stream().filter(diceSpot -> !diceSpot.hasDice()).findFirst();
    }

    public int getIndex(DiceSpotActor diceSpotActor) {
        return targets.indexOf(diceSpotActor.getModel());
    }

    public void updateTargets() {
        GadgetGrid grid = GameController.getInstance().getPlayer().getGadgetGrid();
        targets.clear();
        grid.forEach(gadget -> gadget.forEachSpot(diceSpot -> {
            if (DiceSpotType.Category.DRAW.equals(diceSpot.getType().getCategory())) {
                targets.add(diceSpot);
                diceSpot.getView().updateContent();
            }
        }));
    }
}
