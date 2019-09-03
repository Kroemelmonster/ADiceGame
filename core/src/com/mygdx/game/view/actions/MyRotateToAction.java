package com.mygdx.game.view.actions;

import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;

public class MyRotateToAction extends RotateToAction {
    @Override
    protected void end() {
        target.setRotation(target.getRotation() % 360);
    }
}
