package org.academiadecodigo.codezillas.deltateam.Graphics;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Position extends AbstractPosition {
    private Grid grid;
    private Picture picture;


    public Position (int col, int row, Grid grid, Picture picture) {
        super(col, row, grid);
        this.picture = picture;

        int x = grid.colsToX(col);
        int y = grid.rowsToY(row);

        this.picture = picture;

        show();

    }


    @Override
    public void moveInDirection(Direction direction, int distance){
        int initialCol = getCol();
        int initialRow = getRow();

        super.moveInDirection(direction, distance);

        int dx = grid.colsToX(getCol()) - grid.colsToX(initialCol);
        int dy = grid.rowsToY(getRow()) - grid.rowsToY(initialRow);

        this.picture.translate(dx,dy);
    }

    @Override
    public void show(){
        picture.draw();
    }

    @Override
    public void hide(){
        picture.delete();
    }



}
