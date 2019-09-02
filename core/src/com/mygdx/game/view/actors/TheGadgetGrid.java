package com.mygdx.game.view.actors;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.model.entities.GadgetGrid;

import java.util.ArrayList;
import java.util.List;

public class TheGadgetGrid extends PaddedPanel {
    private List<GadgetActor> places = new ArrayList<>();

    public TheGadgetGrid(GadgetGrid grid, int x, float y, int width, float height) {
        super(x, y, width, height);

        Color transparent = new Color(1, 1, 1, 0.2F);
        setBackgroundColor(new Color(Color.BLUE).mul(transparent));
        setGrid(grid);
    }

    private void setGrid(GadgetGrid grid) {
        grid.forEach(gadget -> {
            GadgetActor actor = new GadgetActor(this, gadget);
            places.add(actor);
            this.addActor(actor);
        });
    }
}
