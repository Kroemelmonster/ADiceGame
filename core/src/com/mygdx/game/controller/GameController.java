package com.mygdx.game.controller;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.DependencyInjection;
import com.mygdx.game.model.definitions.DiceActions;
import com.mygdx.game.model.definitions.DiceRules;
import com.mygdx.game.model.definitions.GadgetTypes;
import com.mygdx.game.model.definitions.PanTypes;
import com.mygdx.game.view.actors.Panel;
import com.mygdx.game.view.actors.TheDicePan;
import com.mygdx.game.view.actors.TheShaker;
import com.mygdx.game.view.services.RenderService;
import lombok.Getter;

public class GameController {

    private RenderService renderService = DependencyInjection.getRenderService();
    private static final int padding = 10;
    @Getter
    private Panel leftPanel;
    @Getter
    private Panel rightPanel;
    @Getter
    private Panel effectPanel;

    @Getter
    private TheShaker theShaker;
    @Getter
    private TheDicePan theDicePan;

    public void startGame() {
        DiceRules.init();
        DiceActions.init();
        PanTypes.init();
        GadgetTypes.init();

        Stage stage = renderService.getStage();

        setUpBackgroundColor(stage);
        setUpPanels(stage);

        theShaker = new TheShaker();
        leftPanel.addActor(theShaker);

        theDicePan = new TheDicePan(PanTypes.DEFAULT);
        theDicePan.setX(200);
        leftPanel.addActor(theDicePan);


        DependencyInjection.getDiceController().init();
        DependencyInjection.getGadgetController().init();

    }

    private void setUpBackgroundColor(Stage stage) {
        Color backgroundColor = renderService.getSkin().getColor("BackgroundColor");

        Panel playablePanel = new Panel();
        playablePanel.setBounds(0, 0, RenderService.SCREEN_WIDTH, RenderService.SCREEN_HEIGHT);
        playablePanel.setBackgroundColor(backgroundColor);
        stage.addActor(playablePanel);
    }

    private void setUpPanels(Stage stage) {
        float width12th = (RenderService.SCREEN_WIDTH - (padding * 2)) / 12F;
        Color transparent = new Color(1, 1, 1, 0.2F);

        leftPanel = new Panel();
        leftPanel.setBounds(padding, padding, width12th * 9, 200);
        //leftPanel.setBackgroundColor(new Color(Color.BLACK).mul(transparent));
        stage.addActor(leftPanel);

        rightPanel = new Panel();
        rightPanel.setBounds(padding + (width12th * 9), padding, width12th * 3, 200);
        //rightPanel.setBackgroundColor(new Color(Color.RED).mul(transparent));
        stage.addActor(rightPanel);

        effectPanel = new Panel();
        stage.addActor(effectPanel);
    }
}
