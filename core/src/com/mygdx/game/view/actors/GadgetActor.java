package com.mygdx.game.view.actors;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.mygdx.game.controller.GadgetController;
import com.mygdx.game.model.entities.Gadget;
import com.mygdx.game.services.RenderService;
import com.mygdx.game.view.render.DiceDroppable;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class GadgetActor extends Group implements DiceDroppable {
    private Image background;
    private List<DiceSpotActor> spots = new ArrayList<>();
    @Getter
    private Gadget model;

    public GadgetActor(TheGadgetGrid grid, Gadget gadget) {
        model = gadget;
        model.setView(this);

        Style style = RenderService.getInstance().getSkin().get(Style.class);
        background = new Image(style.background);
        background.setTouchable(Touchable.disabled);
        addActor(background);

        gadget.forEachSpot(diceSpot -> {
            DiceSpotActor spotActor = new DiceSpotActor(diceSpot);
            addActor(spotActor);
            spots.add(spotActor);
        });

        float diceWidth = DiceSpotActor.getDiceWidth();
        float diceHeight = DiceSpotActor.getDiceHeight();
        float height = gadget.getType().getHeight() * diceHeight;
        setBounds(
                gadget.getCol() * diceWidth,
                grid.getHeight() - gadget.getRow() * diceHeight - height,
                gadget.getType().getWidth() * diceWidth,
                height
        );
        background.setBounds(2, 2, getWidth() - 4, getHeight() - 4);
    }

    public Vector2 getPositionOfIndex(int i) {
        return spots.get(i).getPosition();
    }

    @Override
    public void dragOverStart(DiceActor diceActor) {
        GadgetController.getInstance().dragOverStart(diceActor, this);
    }

    @Override
    public void dragOverEnd(DiceActor diceActor) {
        GadgetController.getInstance().dragOverEnd(diceActor, this);
    }

    @Override
    public boolean drop(DiceActor diceActor) {
        return GadgetController.getInstance().drop(diceActor, this);
    }

    private static class Style {
        private Drawable background;
        private float paddingX;
        private float paddingY;
    }

}
