package org.academiadecodigo.codezillas.deltateam.GameObject;

import org.academiadecodigo.codezillas.deltateam.Graphics.Grid;
import org.academiadecodigo.codezillas.deltateam.Graphics.Position;

import java.security.PrivateKey;

public abstract class GameObject {

    private Position position;
    private Grid grid;
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

}
