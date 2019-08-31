package com.mygdx.game.controller;

import com.google.common.collect.HashBiMap;
import com.mygdx.game.DependencyInjection;
import com.mygdx.game.model.definitions.GadgetTypes;
import com.mygdx.game.model.entities.Gadget;
import com.mygdx.game.view.actors.GadgetActor;

public class GadgetController {
    private HashBiMap<Gadget, GadgetActor> map = HashBiMap.create();

    private GameController gameController = DependencyInjection.getGameController();


    public void init() {
        Gadget gadget = new Gadget(GadgetTypes.DEFAULT, 0, 0);
        GadgetActor actor = new GadgetActor(gadget);

        gameController.getLeftPanel().addActor(actor);

        gadget = new Gadget(GadgetTypes.ONE, 4, 0);
        actor = new GadgetActor(gadget);
        gameController.getLeftPanel().addActor(actor);

        gadget = new Gadget(GadgetTypes.TWO, 5, 0);
        actor = new GadgetActor(gadget);
        gameController.getLeftPanel().addActor(actor);

        gadget = new Gadget(GadgetTypes.TWO, 4, 2);
        actor = new GadgetActor(gadget);
        gameController.getLeftPanel().addActor(actor);

    }
}
