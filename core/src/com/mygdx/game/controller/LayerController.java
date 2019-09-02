package com.mygdx.game.controller;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.services.RenderService;
import com.mygdx.game.view.actors.PaddedPanel;
import com.mygdx.game.view.actors.Panel;
import com.mygdx.game.view.actors.TheGadgetGrid;
import com.mygdx.game.view.actors.TheShaker;
import lombok.Getter;

public class LayerController {
    public static final int PADDING = 10;
    public static final int WIDTH = RenderService.SCREEN_WIDTH - (PADDING * 2);
    public static final int HEIGHT = RenderService.SCREEN_HEIGHT - (PADDING * 2);
    private static LayerController instance = null;
    @Getter
    private Panel bottomPanel;
    @Getter
    private TheGadgetGrid theGadgetGrid;
    @Getter
    private Group diceLayer;
    @Getter
    private TheShaker theShaker;

    private LayerController() {
    }

    public static LayerController getInstance() {
        if (instance == null) {
            instance = new LayerController();
        }
        return instance;
    }

    public void init() {
        Stage stage = RenderService.getInstance().getStage();

        setUpBackgroundColor(stage);
        setUpPanels(stage);

        theShaker = new TheShaker();
        bottomPanel.addActor(theShaker);

    }

    private void setUpBackgroundColor(Stage stage) {
        Color backgroundColor = RenderService.getInstance().getSkin().getColor("BackgroundColor");

        Panel playablePanel = new Panel();
        playablePanel.setBounds(0, 0, RenderService.SCREEN_WIDTH, RenderService.SCREEN_HEIGHT);
        playablePanel.setBackgroundColor(backgroundColor);
        stage.addActor(playablePanel);
    }

    private void setUpPanels(Stage stage) {
        Color transparent = new Color(1, 1, 1, 0.2F);

        bottomPanel = new PaddedPanel(0, 0, 1, 0.3F);
        bottomPanel.setBackgroundColor(new Color(Color.BLACK).mul(transparent));
        stage.addActor(bottomPanel);

        theGadgetGrid = new TheGadgetGrid(GameController.getInstance().getPlayer().getGadgetGrid(), 0, 0.3F, 1, 0.7F);
        stage.addActor(theGadgetGrid);


        diceLayer = new Group();
        stage.addActor(diceLayer);
    }
}
