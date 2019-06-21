package org.academiadecodigo.codezillas.deltateam.Graphics;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    public static final int CELL_SIZE = 10; //change cell size
    private int cols;
    private int rows;
    private Picture picture;

    public void init(){
        this.cols = 10;
        this.rows = 10;
        this.picture = new Picture(0, 0, "./Resources/map-temple-ruins_50.png");
        this.picture.draw();
    }

    public int colsToX(int col){
        return CELL_SIZE * col;
    }

    public int rowsToY(int row){
        return CELL_SIZE * row;
    }

    public Position makeGridPosition(int row, int col, Picture picture){ //temos de passar uma pic - no carcrash a pic era um ret q era criado na position
        return new Position(col, row, this, picture);
    }


    //GETTERS & SETTERS
    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
