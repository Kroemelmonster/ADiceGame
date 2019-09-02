package com.mygdx.game.view.actors;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.mygdx.game.controller.DiceController;
import com.mygdx.game.view.services.RenderService;

public class TheShaker extends Group {
    private final Image background;
    private final Style style;

    public TheShaker() {
        super();
        style = RenderService.getInstance().getSkin().get(Style.class);
        setBounds(0, 0, 100, 100);
        background = add(style.background);

        addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                DiceController.getInstance().draw();
                event.handle();
                return true;
            }
        });
    }

    public Vector2 getDiceStartPosition() {
        Vector2 pos = new Vector2(getWidth() / 2, getHeight() / 2);
        localToStageCoordinates(pos);
        return pos;
    }

    private Image add(Drawable drawable) {
        Image image;
        if (drawable == null) {
            image = new Image();
        } else {
            image = new Image(drawable);
        }
        image.setWidth(getWidth());
        image.setHeight(getHeight());
        this.addActor(image);
        return image;
    }


    private static class Style {
        private Drawable background;
    }
}
