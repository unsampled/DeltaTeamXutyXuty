package org.academiadecodigo.codezillas.deltateam.Graphics;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    public static final int CELL_SIZE = 10; //change cell size
    private int cols;
    private int rows;
    private Picture picture;

    public void init(){}

    public int colsToX(int cols){return 0;}

    public int rowsToY(int rows){return 0;}

    public Position makeGridPosition(int rows, int cols){
        return new Position();
    }


}
