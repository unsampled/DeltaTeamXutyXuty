package org.academiadecodigo.codezillas.deltateam;

import org.academiadecodigo.codezillas.deltateam.GameObject.Furniture;
import org.academiadecodigo.codezillas.deltateam.GameObject.GameObject;
import org.academiadecodigo.codezillas.deltateam.GameObject.GameObjectFactory;
import org.academiadecodigo.codezillas.deltateam.GameObject.GameObjectType;
import org.academiadecodigo.codezillas.deltateam.Graphics.Grid;
import org.academiadecodigo.codezillas.deltateam.Graphics.Position;

public class MapFactory {

    public static void init(Grid grid) {
        Furniture furniture = (Furniture) GameObjectFactory.createGameObject(grid, 11, 7, GameObjectType.FURNITURE);
        Furniture furniture1 = (Furniture) GameObjectFactory.createGameObject(grid, 11, 10, GameObjectType.FURNITURE);
        Furniture furniture2 = (Furniture) GameObjectFactory.createGameObject(grid, 11, 13, GameObjectType.FURNITURE);
        Furniture furniture3 = (Furniture) GameObjectFactory.createGameObject(grid, 8, 10, GameObjectType.FURNITURE);
        Furniture furniture5 = (Furniture) GameObjectFactory.createGameObject(grid, 9, 52, GameObjectType.FURNITURE);
        Furniture furniture6 = (Furniture) GameObjectFactory.createGameObject(grid, 12, 52, GameObjectType.FURNITURE);
        Furniture furnituremid = (Furniture) GameObjectFactory.createGameObject(grid, 30,35, GameObjectType.FURNITURE);
        Furniture furnituremid1 = (Furniture) GameObjectFactory.createGameObject(grid, 55,16, GameObjectType.FURNITURE);
        Furniture furniture7 = (Furniture) GameObjectFactory.createGameObject(grid,80,7,GameObjectType.FURNITURE);
        Furniture furniture8 = (Furniture) GameObjectFactory.createGameObject(grid,77,7,GameObjectType.FURNITURE);
        Furniture furniture9 = (Furniture) GameObjectFactory.createGameObject(grid,77,51,GameObjectType.FURNITURE);
        Furniture furniture10 = (Furniture) GameObjectFactory.createGameObject(grid,77,48,GameObjectType.FURNITURE);
        Furniture furniture11 = (Furniture) GameObjectFactory.createGameObject(grid,77,45,GameObjectType.FURNITURE);
        Furniture furniture12 = (Furniture) GameObjectFactory.createGameObject(grid,80,48,GameObjectType.FURNITURE);
        Furniture furniture13 = (Furniture) GameObjectFactory.createGameObject(grid,9,49,GameObjectType.FURNITURE);
        Furniture furniture14 = (Furniture) GameObjectFactory.createGameObject(grid,12,49,GameObjectType.FURNITURE);
        Furniture furniture15 = (Furniture) GameObjectFactory.createGameObject(grid,80,10,GameObjectType.FURNITURE);
        Furniture furniture16 = (Furniture) GameObjectFactory.createGameObject(grid,77,10,GameObjectType.FURNITURE);
        Furniture furniture17 = (Furniture) GameObjectFactory.createGameObject(grid,30,38,GameObjectType.FURNITURE);
        Furniture furniture18 = (Furniture) GameObjectFactory.createGameObject(grid,30,41,GameObjectType.FURNITURE);
        Furniture furniture19 = (Furniture) GameObjectFactory.createGameObject(grid,30,32,GameObjectType.FURNITURE);
        Furniture furniture20 = (Furniture) GameObjectFactory.createGameObject(grid,33,41,GameObjectType.FURNITURE);
        Furniture furniture21 = (Furniture) GameObjectFactory.createGameObject(grid,36,41,GameObjectType.FURNITURE);
        Furniture furniture22 = (Furniture) GameObjectFactory.createGameObject(grid,39,41,GameObjectType.FURNITURE);
        Furniture furniture23 = (Furniture) GameObjectFactory.createGameObject(grid,58,16,GameObjectType.FURNITURE);
        Furniture furniture24 = (Furniture) GameObjectFactory.createGameObject(grid,61,16,GameObjectType.FURNITURE);
        Furniture furniture25 = (Furniture) GameObjectFactory.createGameObject(grid,61,19,GameObjectType.FURNITURE);
        Furniture furniture26 = (Furniture) GameObjectFactory.createGameObject(grid,61,22,GameObjectType.FURNITURE);
        Furniture furniture27 = (Furniture) GameObjectFactory.createGameObject(grid,61,25,GameObjectType.FURNITURE);
        Furniture furniture28 = (Furniture) GameObjectFactory.createGameObject(grid,52,16,GameObjectType.FURNITURE);

    }


}
