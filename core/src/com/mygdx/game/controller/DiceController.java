package com.mygdx.game.controller;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.google.common.collect.HashBiMap;
import com.mygdx.game.model.entities.Dice;
import com.mygdx.game.view.actions.ArcToAction;
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

    private HashBiMap<Dice, DiceActor> diceMap = HashBiMap.create();

    public void updateDiceNumber(Dice dice) {
        DiceActor actor = diceMap.get(dice);
        if (actor != null) {
            actor.updateNumber(dice);
        }
    }

    private int number = 0;

    public Dice createDice() {
        Dice dice = new Dice();
        DiceActor diceActor = new DiceActor(dice);

        diceMap.put(dice, diceActor);

        LayerController layerController = LayerController.getInstance();

        layerController.getDiceLayer().addActor(diceActor);
        Vector2 position = layerController.getTheShaker().getDiceStartPosition();
        diceActor.setCenterPosition(position.x, position.y);

        diceActor.setScale(0);

        ArcToAction arcToAction = new ArcToAction();

        position = layerController.getTheDicePan().getPositionOfIndex(number);
        arcToAction.setPosition(position.x, position.y);
        arcToAction.addPoint(new Vector2(0, 800), ArcToAction.BezierPoints.Anchor.start);
        arcToAction.setDuration(1F);
        arcToAction.setInterpolation(Interpolation.pow2);

        ParallelAction parallelAction = Actions.parallel(
                arcToAction,
                Actions.scaleTo(1, 1, 1F),
                Actions.rotateBy(-(360 * 2), 1F));
        diceActor.addAction(parallelAction);

        number++;

        return dice;
    }

    public void init() {
        createDice();
    }

    public void draw() {
        createDice();
    }
}
