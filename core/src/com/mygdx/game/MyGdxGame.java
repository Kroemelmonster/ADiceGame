package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.mygdx.game.view.services.RenderService;

public class MyGdxGame extends ApplicationAdapter {
    private RenderService renderService;

    public void create() {
        DependencyInjection.init();
        renderService = DependencyInjection.getRenderService();
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
