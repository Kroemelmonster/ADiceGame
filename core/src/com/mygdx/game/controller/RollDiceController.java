package com.mygdx.game.controller;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.mygdx.game.model.entities.Dice;
import com.mygdx.game.model.entities.DiceSpot;
import com.mygdx.game.model.entities.DiceSpotType;
import com.mygdx.game.model.entities.GadgetGrid;
import com.mygdx.game.services.ActionService;
import com.mygdx.game.view.actions.ArcToAction;
import com.mygdx.game.view.actors.DiceActor;
import com.mygdx.game.view.actors.DiceSpotActor;
import lombok.extern.java.Log;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

@Log
public class RollDiceController {
    private static RollDiceController instance = null;

    private RollDiceController() {
    }

    public static RollDiceController getInstance() {
        if (instance == null) {
            instance = new RollDiceController();
        }
        return instance;
    }

    private List<DiceSpot> targets = new LinkedList<>();

    public void rollNewDice() {
        Optional<DiceSpot> target = getNextFreeDiceSpot();
        if (!target.isPresent()) {
            log.log(Level.WARNING, "No more DiceSpots to roll something into");
            return;
        }

        final Dice dice = new Dice();
        final DiceActor diceActor = DiceController.getInstance().createDiceActor(dice);


        LayerController layerController = LayerController.getInstance();

        Vector2 startPosition = layerController.getTheShaker().getDiceStartPosition();
        diceActor.setCenterPosition(startPosition.x, startPosition.y);

        diceActor.setScale(0);
        diceActor.setTouchable(Touchable.disabled);


        ArcToAction arcToAction = new ArcToAction();


        DiceSpot spot = target.get();

        Vector2 endPosition = spot.getView().getPosition();
        arcToAction.setPosition(endPosition.x, endPosition.y);
        arcToAction.addPoint(new Vector2(0, 800), ArcToAction.BezierPoints.Anchor.start);
        arcToAction.setDuration(4F);
        arcToAction.setInterpolation(Interpolation.pow2);

        ParallelAction parallelAction = Actions.parallel(
                arcToAction,
                Actions.scaleTo(1, 1, 4F),
                Actions.rotateBy(-(360 * 2), 4F));

        ActionService.getInstance().addAction(diceActor, parallelAction, () -> {
            diceActor.setRotation(0);
            diceActor.setTouchable(Touchable.enabled);
        });

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
