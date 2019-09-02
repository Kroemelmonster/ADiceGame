package com.mygdx.game.view.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.controller.GadgetController;
import com.mygdx.game.model.entities.GadgetGrid;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class TheGadgetGrid extends PaddedPanel {
    private List<GadgetActor> places = new ArrayList<>();
    @Getter
    private GadgetGrid model;

    public TheGadgetGrid(GadgetGrid grid, int x, float y, int width, float height) {
        super(x, y, width, height);
        model = grid;
        model.setView(this);

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

        places.get(0).addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                GadgetController.getInstance().incrementAll(places.get(0).getModel(), -1);
                event.handle();
                return true;
            }
        });
    }
}
