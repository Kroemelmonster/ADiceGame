package com.mygdx.game.view.services;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {
    public static TextureRegion WHITE;

    public static void init() {
        Skin skin = RenderService.getInstance().getSkin();
        WHITE = skin.getRegion("WHITE");
    }
}
