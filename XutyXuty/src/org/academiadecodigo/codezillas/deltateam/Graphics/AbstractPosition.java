package org.academiadecodigo.codezillas.deltateam.Graphics;

public abstract class AbstractPosition {

    private Grid grid;
    private int col;
    private int row;

    public AbstractPosition(int col, int row, Grid grid){
        this.grid = grid;
        this.col = col;
        this.row = row;
    }

    public void moveInDirection(Direction direction, int distance) {
        switch (direction) {

            case UP:
                moveUp(distance);
                break;
            case DOWN:
                moveDown(distance);
                break;
            case LEFT:
                moveLeft(distance);
                break;
            case RIGHT:
                moveRight(distance);
                break;
        }

    }

    public boolean equals(Position position){
        return this.col == position.getCol() && this.row == position.getRow();
    }

    public abstract void show();

    public abstract void hide();


    //VER
    private void moveUp(int distance){
        int maxRowsUp = Math.min(distance,0); //mal
        setPos(col, row - maxRowsUp);
    }

    private void moveDown(int distance){
        int maxRowsDown = Math.min(distance,getRow());
        setPos(col, row - maxRowsDown);
    }

    private void moveLeft(int distance){
        int maxColsLeft = Math.min(distance,0);
        setPos(col - maxColsLeft, row);
    }

    private void moveRight(int distance){
        int maxColsRight = Math.min(distance,getCol());
        setPos(col - maxColsRight, row);
    }

    //BR


    //xGETTERS & SETTERS
    public Grid getGrid() {
        return grid;
    }

    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
        show();
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
