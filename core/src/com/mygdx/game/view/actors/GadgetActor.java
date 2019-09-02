package com.mygdx.game.view.actors;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.mygdx.game.model.entities.DiceSpot;
import com.mygdx.game.model.entities.Gadget;
import com.mygdx.game.view.services.RenderService;

import java.util.ArrayList;
import java.util.List;

public class GadgetActor extends Group {
    private Image background;
    private List<DiceSpotActor> spots = new ArrayList<>();

    public GadgetActor(TheGadgetGrid grid, Gadget gadget) {
        Style style = RenderService.getInstance().getSkin().get(Style.class);
        background = new Image(style.background);
        addActor(background);

        for (DiceSpot spot : gadget.getSpots()) {
            DiceSpotActor spotActor = new DiceSpotActor(spot);
            addActor(spotActor);
            spots.add(spotActor);
        }

        float diceWidth = DiceSpotActor.getDiceWidth();
        float diceHeight = DiceSpotActor.getDiceHeight();
        float height = gadget.getHeight() * diceHeight;
        setBounds(
                gadget.getCol() * diceWidth,
                grid.getHeight() - gadget.getRow() * diceHeight - height,
                gadget.getWidth() * diceWidth,
                height
        );
        background.setBounds(2, 2, getWidth() - 4, getHeight() - 4);
    }

    public Vector2 getPositionOfIndex(int i) {
        return spots.get(i).getPosition();
    }

    private static class Style {
        private Drawable background;
        private float paddingX;
        private float paddingY;
    }

}
