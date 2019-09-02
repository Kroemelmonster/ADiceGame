package com.mygdx.game.model.definitions;

import com.mygdx.game.controller.GadgetController;
import com.mygdx.game.model.entities.Gadget;

public class GadgetActions {
    public static GadgetAction INCREMENT, NOTHING;

    public static void init() {
        GadgetActions.INCREMENT = new GadgetAction() {
            @Override
            public void act(Gadget gadget) {
                GadgetController.getInstance().incrementAll(gadget, 1);
            }
        };
        GadgetActions.NOTHING = new GadgetAction() {
            @Override
            public void act(Gadget gadget) {
            }
        };
    }
}
