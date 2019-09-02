package com.mygdx.game.view.actors;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.services.RenderService;

public class DiceSpotTypeActorBuilder {
    protected static DiceSpotTypeActor create(DiceSpotActor spotActor) {
        Skin skin = RenderService.getInstance().getSkin();
        switch (spotActor.getModel().getType().getCategory()) {
            case NORMAL:
                return new NormalDiceSpotTypeActor(spotActor, skin);
            case DRAW:
                return new DrawDiceSpotTypeActor(spotActor, skin);
            default:
                // code block
        }
        return null;
    }
}
