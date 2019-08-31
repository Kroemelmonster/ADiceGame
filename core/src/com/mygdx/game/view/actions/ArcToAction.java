package com.mygdx.game.view.actions;

import com.badlogic.gdx.math.Bezier;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class ArcToAction extends MoveToAction {
    private List<BezierPoints> extraPoints = new ArrayList<>();
    private Bezier<Vector2> bezier;

    public void addPoint(Vector2 offset, BezierPoints.Anchor anchor) {
        this.extraPoints.add(new BezierPoints(offset, anchor));
    }

    @Override
    protected void begin() {
        super.begin();
        Vector2[] controlPoints = new Vector2[2 + extraPoints.size()];
        controlPoints[0] = new Vector2(target.getX(), target.getY());
        controlPoints[extraPoints.size() + 1] = new Vector2(getX(), getY());

        int i = 1;
        for (BezierPoints extraPoint : extraPoints) {
            if (BezierPoints.Anchor.start.equals(extraPoint.anchor)) {
                controlPoints[i] = new Vector2(controlPoints[0]).add(extraPoint.offset);
            } else {
                controlPoints[i] = new Vector2(controlPoints[extraPoints.size() + 1]).add(extraPoint.offset);
            }
            i++;
        }
        bezier = new Bezier<>(controlPoints);
    }

    protected void update(float percent) {
        if (percent >= 1) {
            target.setPosition(getX(), getY(), getAlignment());
            return;
        }
        Vector2 st = new Vector2();
        bezier.valueAt(st, percent);

        target.setPosition(st.x, st.y, getAlignment());
    }

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class BezierPoints {
        private Vector2 offset;
        private Anchor anchor;

        public enum Anchor {start, target}
    }
}
