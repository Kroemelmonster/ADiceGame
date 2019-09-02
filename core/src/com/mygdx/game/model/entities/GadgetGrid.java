package com.mygdx.game.model.entities;

import com.mygdx.game.view.actors.TheGadgetGrid;
import lombok.Getter;
import lombok.Setter;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Consumer;

public class GadgetGrid {
    private final int rows, columns;
    private final Gadget[][] grid;
    private final SortedSet<Gadget> sortedSet = new TreeSet<>();
    @Getter
    @Setter
    private TheGadgetGrid view;

    public GadgetGrid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        grid = new Gadget[rows][columns];
    }

    public boolean doesGadgetFit(GadgetType gadgetType, int row, int col) {
        int height = gadgetType.getHeight();
        int width = gadgetType.getWidth();

        if ((row + height >= rows) || (col + width >= columns)) {
            return false;
        }
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (grid[row + x][col + y] != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void addGadget(GadgetType gadgetType, int row, int col) {
        if (!doesGadgetFit(gadgetType, row, col)) {
            return;
        }
        Gadget gadget = new Gadget(gadgetType, row, col);
        int height = gadgetType.getHeight();
        int width = gadgetType.getWidth();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                grid[row][col] = gadget;
            }
        }

        sortedSet.add(gadget);
    }

    public void forEach(Consumer<? super Gadget> action) {
        sortedSet.forEach(action);
    }
}
