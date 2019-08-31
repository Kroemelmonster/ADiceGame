package com.mygdx.game.model.definitions;

public class PanTypes {
    public static PanType DEFAULT;

    public static void init() {
        DEFAULT = new PanType()
                .add(0, 0)
                .add(0, 1)
                .add(1, 1)
                .add(1, 0)
                .add(2, 0)
                .add(2, 1)
                .add(3, 1)
                .add(3, 0);
    }

}
