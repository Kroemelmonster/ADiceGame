package com.mygdx.game.view.services;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.Pixmap;

import java.util.HashMap;

public class CursorService {
    private static CursorService instance = null;

    private CursorService() {
        Pixmap pm;
        for (CursorType value : CursorType.values()) {
            pm = new Pixmap(Gdx.files.internal("cursors/" + value.name() + ".png"));
            cursors.put(value, Gdx.graphics.newCursor(pm, 0, 0));
            pm.dispose();
        }
        setCursor(CursorType.cursor);
    }

    private HashMap<CursorType, Cursor> cursors = new HashMap<>();

    public static CursorService getInstance() {
        if (instance == null) {
            instance = new CursorService();
        }
        return instance;
    }

    public void setCursor(CursorType type) {
        Gdx.graphics.setCursor(cursors.get(type));
    }

    void dispose() {
        cursors.forEach((cursorType, cursor) -> {
            cursor.dispose();
        });
    }

    public enum CursorType {
        cursor, clicker, drag
    }
}
