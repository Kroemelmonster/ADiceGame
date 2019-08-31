package com.mygdx.game.view.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.DependencyInjection;
import com.mygdx.game.model.entities.DiceSpot;
import com.mygdx.game.view.services.RenderService;

public class DiceSpotActor extends AbstractDiceActor {
    private static Style style;
    private Label content;
    private RenderService renderService = DependencyInjection.getRenderService();

    public DiceSpotActor(DiceSpot spot) {
        super();
        createStyle();
        Skin skin = renderService.getSkin();

        this.border.setColor(Color.BLACK);

        this.content = new Label(Integer.toString((int) Math.abs(Math.random() * 10)), skin);
        content.setColor(Color.BLACK);
        content.setBounds(0, 15, this.getWidth(), this.getHeight());
        content.setAlignment(Align.center);
        this.addActor(this.content);

        this.setColor(1, 1, 1, 0.2F);


        this.setPosition(spot.getX() * getWidthWithPadding() + style.paddingX / 2, spot.getY() * getHeightWithPadding() + style.offsetY);

        //this.content.setColor(style.contentColor);
    }

    private static void createStyle() {
        RenderService renderService = DependencyInjection.getRenderService();
        if (style == null) {
            style = renderService.getSkin().get(Style.class);
        }
    }

    public static float getDiceWidth() {
        createStyle();
        float size = AbstractDiceActor.getSize();
        return size + style.paddingX;
    }

    public static float getDiceHeight() {
        createStyle();
        float size = AbstractDiceActor.getSize();
        return size + style.paddingY;
    }

    public float getWidthWithPadding() {
        return this.getWidth() + style.paddingX;
    }

    public float getHeightWithPadding() {
        return this.getHeight() + style.paddingY;
    }

    public Vector2 getPosition() {
        return localToStageCoordinates(new Vector2());
    }

    private static class Style {
        private float offsetY;
        private float paddingX;
        private float paddingY;
    }
}
