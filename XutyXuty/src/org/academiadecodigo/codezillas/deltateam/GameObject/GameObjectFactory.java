package org.academiadecodigo.codezillas.deltateam.GameObject;

import org.academiadecodigo.codezillas.deltateam.Graphics.Grid;

public class GameObjectFactory {

    public static GameObject createGameObject(Grid grid, int col, int row, GameObjectType gameObjectType){

        GameObject gameObject;

        switch (gameObjectType){
            case PLAYER:
                gameObject = new Player(grid, grid.makeGridPosition(col,row,"./resources/doll.png")); //mudar
                break;
           case FURNITURE:
                gameObject = new Furniture(grid, grid.makeGridPosition(col,row,"Box.png"));//mudar
                break;
            default:
                return null;
        }
        return gameObject;
     }

}
