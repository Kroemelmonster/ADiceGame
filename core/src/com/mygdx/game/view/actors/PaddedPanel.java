package com.mygdx.game.view.actors;

import com.mygdx.game.controller.LayerController;

public class PaddedPanel extends Panel {
    public PaddedPanel(int x, float y, int width, float height) {
        super();
        setBounds(
                LayerController.PADDING + x * LayerController.WIDTH,
                LayerController.PADDING + y * LayerController.HEIGHT,
                LayerController.WIDTH * width,
                LayerController.HEIGHT * height);
    }
}
