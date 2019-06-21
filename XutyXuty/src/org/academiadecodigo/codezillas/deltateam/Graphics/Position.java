package org.academiadecodigo.codezillas.deltateam.Graphics;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Position extends AbstractPosition {
    private Picture picture;


    public Position (int col, int row, Grid grid, String picture) {
        super(col, row, grid);
        this.picture = new Picture(col,row,picture);

        int x = grid.colsToX(col);
        int y = grid.rowsToY(row);

        show();

    }


    @Override
    public void moveInDirection(Direction direction, int distance){
        int initialCol = getCol();
        int initialRow = getRow();

        super.moveInDirection(direction, distance);

        int dx = super.getGrid().colsToX(getCol()) - super.getGrid().colsToX(initialCol);
        int dy = super.getGrid().rowsToY(getRow()) - super.getGrid().rowsToY(initialRow);

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
