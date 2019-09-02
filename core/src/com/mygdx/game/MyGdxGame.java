package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.mygdx.game.controller.GameController;
import com.mygdx.game.services.RenderService;

public class MyGdxGame extends ApplicationAdapter {
    private RenderService renderService;

    public void create() {
        renderService = RenderService.getInstance();
        GameController.getInstance().startGame();
    }

    public void render() {
        renderService.render();
    }

    public void resize(int width, int height) {
        renderService.resize(width, height);
    }

    public void dispose() {
        renderService.dispose();
    }
}
