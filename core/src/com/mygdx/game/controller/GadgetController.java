package com.mygdx.game.controller;

import com.google.common.collect.HashBiMap;
import com.mygdx.game.model.entities.Gadget;
import com.mygdx.game.view.actors.GadgetActor;

public class GadgetController {
    private static GadgetController instance = null;

    private GadgetController() {
    }

    public static GadgetController getInstance() {
        if (instance == null) {
            instance = new GadgetController();
        }
        return instance;
    }

    private HashBiMap<Gadget, GadgetActor> map = HashBiMap.create();


    public void init() {


    }
}
