package org.academiadecodigo.codezillas.deltateam.GameObject;

import org.academiadecodigo.codezillas.deltateam.Graphics.Grid;

public class GameObjectFactory {

    public static GameObject createGameObject(Grid grid, int col, int row, GameObjectType gameObjectType){

        GameObject gameObject;

        switch (gameObjectType){
            case PLAYER:
                gameObject = new Player(grid, grid.makeGridPosition(col,row,"./resources/doll.png")); //mudar
                break;
           /* case FURNITURE:
                gameObject = new Furniture(grid.makeGridPosition(10,20,"fas")); //mudar*/
            default:
                return null;
        }
        return gameObject;
     }

}
