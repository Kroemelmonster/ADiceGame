package com.mygdx.game.view.services;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.DependencyInjection;

public class Assets {
    public static TextureRegion WHITE;

    public static void init() {
        Skin skin = DependencyInjection.getRenderService().getSkin();
        WHITE = skin.getRegion("WHITE");
    }
}
