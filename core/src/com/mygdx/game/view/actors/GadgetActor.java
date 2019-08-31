package com.mygdx.game.view.actors;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.mygdx.game.DependencyInjection;
import com.mygdx.game.model.entities.DiceSpot;
import com.mygdx.game.model.entities.Gadget;
import com.mygdx.game.view.services.RenderService;

import java.util.ArrayList;
import java.util.List;

public class GadgetActor extends Group {
    private Image background;
    private List<DiceSpotActor> spots = new ArrayList<>();

    private RenderService renderService = DependencyInjection.getRenderService();

    public GadgetActor(Gadget gadget) {
        Style style = renderService.getSkin().get(Style.class);
        this.background = new Image(style.background);
        this.addActor(this.background);

        int x = 0;
        int y = 0;
        for (DiceSpot spot : gadget.getSpots()) {
            DiceSpotActor spotActor = new DiceSpotActor(spot);
            this.addActor(spotActor);
            this.spots.add(spotActor);

            x = Math.max(x, spot.getX());
            y = Math.max(y, spot.getY());
        }
        x++;
        y++;
        this.background.setBounds(0, 0, x * DiceSpotActor.getDiceWidth(), y * DiceSpotActor.getDiceHeight());
        this.setPosition(gadget.getX() * DiceSpotActor.getDiceWidth(), (7 - gadget.getY() - y) * DiceSpotActor.getDiceHeight());
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
