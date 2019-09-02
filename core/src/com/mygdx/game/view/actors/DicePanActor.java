package com.mygdx.game.view.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.model.definitions.PanPlace;
import com.mygdx.game.view.services.RenderService;

public class DicePanActor extends AbstractDiceActor {
    private Style style;
    private Label content;

    public DicePanActor(PanPlace place, int number) {
        super();
        Skin skin = RenderService.getInstance().getSkin();
        border.setColor(Color.BLACK);

        content = new Label(Integer.toString(number), skin);
        content.setColor(Color.BLACK);
        content.setBounds(0, 15, getWidth(), getHeight());
        content.setAlignment(Align.center);
        addActor(content);

        setColor(1, 1, 1, 0.2F);

        setPosition(place.getX() * (getWidth() + 20), place.getY() * (getHeight() + 20));

        //this.content.setColor(style.contentColor);
    }

    public Vector2 getPosition() {
        return localToStageCoordinates(new Vector2());
    }

    private static class Style {
        private String dicePrefix;
        private Color contentColor;
    }
}
