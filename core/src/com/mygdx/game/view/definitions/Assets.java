package com.mygdx.game.view.definitions;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.services.RenderService;

public class Assets {
    public static TextureRegion WHITE;

    public static void init() {
        Skin skin = RenderService.getInstance().getSkin();
        WHITE = skin.getRegion("WHITE");
    }
}
