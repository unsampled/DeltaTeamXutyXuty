package org.academiadecodigo.codezillas.deltateam.Graphics;

public abstract class AbstractPosition {

    private Grid grid;
    private int col;
    private int row;

    public void moveInDirection(Direction direction, int distance){}

    public boolean equals(Position position){
        return true;
    }

    public abstract void show();

    public abstract void hide();

    private void moveUp(){}

    private void moveDown(){}

    private void moveLeft(){}

    private void moveRight(){}


}
