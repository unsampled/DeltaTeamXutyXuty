package deltateam.GameObject;

import deltateam.Graphics.Grid;

public class GameObjectFactory {

        //private static java.awt.Rectangle[] hitBoxes = new java.awt.Rectangle[32];
        private static GameObject[] gameObjects = new GameObject[127];
        private static int counter = 0;

    public static GameObject createGameObject(Grid grid, int col, int row, GameObjectType gameObjectType){ //,Direction direction){

        GameObject gameObject;

        switch (gameObjectType){
            case PLAYER:
                gameObject = new Player(grid, grid.makeGridPosition(col,row,"./Resources/doll.png"));
                gameObjects[counter] = gameObject;
                counter++;
                break;
            case FURNITURE:
                gameObject = new Furniture(grid, grid.makeGridPosition(col,row,"./Resources/Box.png"));
                gameObjects[counter] = gameObject;
                counter++;
                break;
            case PLAYER2:
                gameObject = new Player2(grid, grid.makeGridPosition(col,row,"./Resources/doll2.png"));
                gameObjects[counter] = gameObject;
                counter++;
                break;
            case FURNITURE2:
                gameObject = new Furniture(grid, grid.makeGridPosition(col,row,"./Resources/Box2.png"));
                gameObjects[counter] = gameObject;
                counter++;
                break;
            case POWERUP:
                gameObject = new PowerUp(grid, grid.makeGridPosition(col,row,"./Resources/powerarmor.png"));
                gameObjects[counter] = gameObject;
                counter++;
            default:
                return null;
        }
        return gameObject;
     }

    public static GameObject[] getGameObjects() {
        return gameObjects;
    }
}
