package com.mygdx.game.view.actors;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.view.services.RenderService;

import java.util.Optional;

public class DiceSpotTypeActorBuilder {
    protected static Optional<DiceSpotTypeActor> create(DiceSpotActor spotActor) {
        Skin skin = RenderService.getInstance().getSkin();
        switch (spotActor.spot.getType()) {
            case NORMAL:
                return Optional.of(new NormalDiceSpotTypeActor(spotActor, skin));
            case DRAW:
                return Optional.of(new DrawDiceSpotTypeActor(spotActor, skin));
            default:
                // code block
        }
        return Optional.empty();
    }
}
