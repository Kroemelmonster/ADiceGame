package com.mygdx.game;

import com.mygdx.game.controller.DiceController;
import com.mygdx.game.controller.GadgetController;
import com.mygdx.game.controller.GameController;
import com.mygdx.game.model.services.DiceService;
import com.mygdx.game.view.services.Assets;
import com.mygdx.game.view.services.CursorService;
import com.mygdx.game.view.services.DraggableService;
import com.mygdx.game.view.services.RenderService;
import lombok.Getter;

public class DependencyInjection {
    @Getter
    private static RenderService renderService;
    @Getter
    private static DraggableService draggableService;
    @Getter
    private static CursorService cursorService;
    @Getter
    private static DiceService diceService;
    @Getter
    private static DiceController diceController;
    @Getter
    private static GameController gameController;
    @Getter
    private static GadgetController gadgetController;

    static void init() {
        cursorService = new CursorService();
        diceService = new DiceService();
        draggableService = new DraggableService();
        renderService = new RenderService();
        gameController = new GameController();
        diceController = new DiceController();
        gadgetController = new GadgetController();


        Assets.init();
        gameController.startGame();
    }

}
