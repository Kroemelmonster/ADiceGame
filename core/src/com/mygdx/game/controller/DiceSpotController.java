package com.mygdx.game.controller;

import com.mygdx.game.view.actors.DiceActor;
import com.mygdx.game.view.actors.DiceSpotActor;

public class DiceSpotController {
    private static DiceSpotController instance = null;
    private DiceSpotActor currentDragOver;

    private DiceSpotController() {
    }

    public static DiceSpotController getInstance() {
        if (instance == null) {
            instance = new DiceSpotController();
        }
        return instance;
    }

    public void init() {
    }

    public void dragOverStart(DiceActor diceActor, DiceSpotActor diceSpotActor) {
        if (diceSpotActor != currentDragOver) {
            System.out.println("start drag over ");
            System.out.println(diceSpotActor);
            System.out.println(currentDragOver);
            currentDragOver = diceSpotActor;
            diceSpotActor.showDragOver(diceActor, true);
        }
    }

    public void dragOverEnd(DiceSpotActor diceSpotActor) {
        if (currentDragOver == diceSpotActor) {
            System.out.println("end drag over ");
            System.out.println(diceSpotActor);
            System.out.println(currentDragOver);
            currentDragOver.hideDragOver();
            currentDragOver = null;
        }
    }

    public boolean drop(DiceActor diceActor, DiceSpotActor diceSpotActor) {
        return false;
    }
}
