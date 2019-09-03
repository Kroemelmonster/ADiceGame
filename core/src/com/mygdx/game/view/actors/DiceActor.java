package com.mygdx.game.view.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.model.entities.Dice;
import com.mygdx.game.services.DraggableService;
import com.mygdx.game.services.RenderService;
import lombok.Getter;

public class DiceActor extends AbstractDiceActor {
    @Getter
    private Dice model;
    private Style style;
    private Image content;

    public DiceActor(Dice dice) {
        super();
        model = dice;
        model.setView(this);
        setup();
    }

    private DiceActor(DiceActor diceActor) {
        super();
        model = diceActor.model;
        setup();
    }

    private void setup() {
        Skin skin = RenderService.getInstance().getSkin();
        style = skin.get(Style.class);
        border.setColor(Color.BLACK);
        content = addSubImage(null);
        content.setColor(style.contentColor);


        updateContent(model.getValue());

        DraggableService.getInstance().addDraggableDiceListener(this);
    }

    public DiceActor createHighlightCopy(boolean accept) {
        DiceActor copy = new DiceActor(this);
        copy.setTouchable(Touchable.disabled);
        if (accept) {
            copy.border.setColor(Color.GREEN);
        } else {
            copy.border.setColor(Color.RED);
        }
        copy.setColor(1, 1, 1, 0.5F);

        return copy;
    }

    public void setPosition(float x, float y) {
        super.setPosition(x, y);
    }

    public void updateContent(int value) {
        Skin skin = RenderService.getInstance().getSkin();
        content.setDrawable(skin, style.dicePrefix + value);
    }

    private static class Style {
        private String dicePrefix;
        private Color contentColor;
    }
}
