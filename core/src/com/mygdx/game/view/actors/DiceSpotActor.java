package com.mygdx.game.view.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.model.entities.DiceSpot;
import com.mygdx.game.model.entities.DiceSpotType;
import com.mygdx.game.services.RenderService;
import lombok.Getter;

public class DiceSpotActor extends AbstractDiceActor {
    @Getter
    private DiceSpot model;
    private static Style style;
    private DiceSpotTypeActor content;

    public DiceSpotActor(DiceSpot spot) {
        super();
        model = spot;
        model.setView(this);
        createStyle();

        border.setColor(Color.BLACK);

        content = DiceSpotTypeActorBuilder.create(this);
        if (content != null) {
            addActor(content.getActor());
        }

        setColor(1, 1, 1, 0.2F);


        DiceSpotType type = spot.getType();

        int align = type.getAlign();
        float x = type.getX() * getWidthWithPadding();
        if (Align.isLeft(align)) {
            x += 2;
        } else if (Align.isRight(align)) {
            x += style.paddingX - 2;
        } else {
            x += style.paddingX / 2;
        }

        float y = type.getY() * getHeightWithPadding();
        y += style.offsetY;
        if (Align.isTop(align)) {
            y += style.paddingY / 2 - 2;
        } else if (Align.isBottom(align)) {
            y -= style.paddingY / 2 - 2;
        }

        setPosition(x, y);
    }

    public void updateContent() {
        if (content != null) {
            content.updateContent(this);
        }
    }

    private static void createStyle() {
        if (style == null) {
            style = RenderService.getInstance().getSkin().get(Style.class);
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
        return getWidth() + style.paddingX;
    }

    public float getHeightWithPadding() {
        return getHeight() + style.paddingY;
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
