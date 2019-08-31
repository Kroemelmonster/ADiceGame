package com.mygdx.game.model.definitions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PanType {
    private final List<PanPlace> places = new ArrayList<>();

    protected PanType add(int x, int y) {
        places.add(new PanPlace(x, y));
        return this;
    }

    public List<PanPlace> getPlaces() {
        return Collections.unmodifiableList(places);
    }

}
