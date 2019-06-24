package deltateam.Graphics;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    public static final int CELL_SIZE = 20; //change cell size
    private int cols;
    private int rows;
    private Picture picture;

    public void init(){
        this.picture = new Picture(0, 0, "./Resources/map-temple-ruins_50.png");
        this.picture.draw();
    }

    public int colsToX(int col){
        return CELL_SIZE * col;
    }

    public int rowsToY(int row){
        return CELL_SIZE * row;
    }

    public Position makeGridPosition(int col, int row, String picture){ //temos de passar uma pic - no carcrash a pic era um ret q era criado na position
        return new Position(col, row, this, picture);
    }


    //GETTERS & SETTERS
    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Grid getGrid()
    {
        return this;
    }

    public Picture getPicture()
    {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}

