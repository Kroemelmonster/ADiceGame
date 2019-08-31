package com.mygdx.game.view.actors;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.mygdx.game.model.definitions.PanPlace;
import com.mygdx.game.model.definitions.PanType;

import java.util.ArrayList;
import java.util.List;

public class TheDicePan extends Group {
    private Style style;

    private List<DicePanActor> places = new ArrayList<>();

    public TheDicePan(PanType panType) {
        int i = 1;
        for (PanPlace place : panType.getPlaces()) {
            DicePanActor dicePanActor = new DicePanActor(place, i);
            this.addActor(dicePanActor);
            places.add(dicePanActor);
            i++;
        }
    }

    public Vector2 getPositionOfIndex(int i) {
        return places.get(i).getPosition();
    }

    private static class Style {
        private float dicePadding;
        private float bottom;
        private float left;
    }
}
