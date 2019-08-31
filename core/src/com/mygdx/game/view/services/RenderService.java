package com.mygdx.game.view.services;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.DependencyInjection;
import lombok.Getter;

public class RenderService {
    public static final int SCREEN_WIDTH = 1000;
    public static final int SCREEN_HEIGHT = 700;

    @Getter
    private Stage stage;
    @Getter
    private Skin skin;

    public RenderService() {
        FitViewport viewport = new FitViewport(SCREEN_WIDTH, SCREEN_HEIGHT, new OrthographicCamera());

        this.stage = new Stage(viewport);

        Gdx.input.setInputProcessor(stage);
        this.skin = new Skin(Gdx.files.internal("skin.json"));
    }

    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    public void dispose() {
        DependencyInjection.getCursorService().dispose();
        stage.dispose();
    }

}
