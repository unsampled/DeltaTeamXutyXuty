package org.academiadecodigo.codezillas.deltateam.grid;

import org.academiadecodigo.codezillas.deltateam.grid.position.GridPosition;

public interface Grid {

    public void init();

    public int getCol();

    public int getRow();

    public GridPosition makeGridPosition(int col, int rows);
}
