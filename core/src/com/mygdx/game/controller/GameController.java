package com.mygdx.game.controller;

import com.mygdx.game.model.definitions.DiceRules;
import com.mygdx.game.model.definitions.GadgetActions;
import com.mygdx.game.model.definitions.GadgetTypes;
import com.mygdx.game.model.entities.GadgetGrid;
import com.mygdx.game.model.entities.Player;
import com.mygdx.game.view.definitions.Assets;
import lombok.Getter;

public class GameController {
    private static GameController instance = null;
    @Getter
    private Player player;

    private GameController() {
    }

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    public void startGame() {
        Assets.init();

        DiceRules.init();
        GadgetActions.init();
        GadgetTypes.init();


        GadgetGrid gadgetGrid = new GadgetGrid(8, 8);
        gadgetGrid.addGadget(GadgetTypes.DEFAULT, 0, 0);
        gadgetGrid.addGadget(GadgetTypes.ONE, 0, 4);
        gadgetGrid.addGadget(GadgetTypes.TWO, 0, 5);
        gadgetGrid.addGadget(GadgetTypes.TWO, 3, 3);

        player = new Player(gadgetGrid);

        LayerController.getInstance().init();

        DiceController.getInstance().init();
        GadgetController.getInstance().init();
    }
}
