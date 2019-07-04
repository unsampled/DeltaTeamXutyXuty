package deltateam.GameObject;

import deltateam.Graphics.Grid;
import deltateam.Graphics.Position;

public abstract class GameObject {

    private Position position;
    private Grid grid;
    //TODO:unused property
    private GameObjectType gameObjectType;

    public GameObject(Grid grid, Position position, GameObjectType gameObjectType){
        this.position = position;
        this.gameObjectType = gameObjectType;
        this.grid = grid;
    }

    public void setGrid(Grid grid){
        this.grid = grid;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Grid getGrid() {
        return grid;
    }

    //TODO: importing Rectangle from outside simple graphics
    //TODO:unused method
    public java.awt.Rectangle hitBox(){
        int initialX = grid.colsToX(position.getCol());
        int initialY = grid.rowsToY(position.getRow());
        int pictureWidth = position.pictureWidth();
        int pictureHeight = position.pictureHeight();
        return new java.awt.Rectangle(initialX, initialY, pictureWidth, pictureHeight);
    }

}
