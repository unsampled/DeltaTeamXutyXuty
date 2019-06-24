package deltateam;

import deltateam.GameObject.*;
import deltateam.Graphics.Grid;

public class MapFactory {

    public static void init(Grid grid) {
        PowerUp powerUp = (PowerUp) GameObjectFactory.createGameObject(grid, 29,19, GameObjectType.POWERUP);
        Furniture furniture = (Furniture) GameObjectFactory.createGameObject(grid, 6, 6, GameObjectType.FURNITURE);
        Furniture furniture1 = (Furniture) GameObjectFactory.createGameObject(grid, 6, 8, GameObjectType.FURNITURE);
        Furniture furniture2 = (Furniture) GameObjectFactory.createGameObject(grid, 6, 10, GameObjectType.FURNITURE);
        Furniture furniture3 = (Furniture) GameObjectFactory.createGameObject(grid, 8, 8, GameObjectType.FURNITURE);
        Furniture furniture5 = (Furniture) GameObjectFactory.createGameObject(grid, 8, 32, GameObjectType.FURNITURE);
        Furniture furniture6 = (Furniture) GameObjectFactory.createGameObject(grid, 10, 32, GameObjectType.FURNITURE);
        Furniture furnituremid = (Furniture) GameObjectFactory.createGameObject(grid, 20,24, GameObjectType.FURNITURE);
        Furniture furnituremid1 = (Furniture) GameObjectFactory.createGameObject(grid, 20,26, GameObjectType.FURNITURE);
        Furniture furniture7 = (Furniture) GameObjectFactory.createGameObject(grid,20,28,GameObjectType.FURNITURE);
        Furniture furniture8 = (Furniture) GameObjectFactory.createGameObject(grid,22,28,GameObjectType.FURNITURE);
        Furniture furniture9 = (Furniture) GameObjectFactory.createGameObject(grid,24,28,GameObjectType.FURNITURE);
        Furniture furniture10 = (Furniture) GameObjectFactory.createGameObject(grid,20,22,GameObjectType.FURNITURE);
        Furniture furniture11 = (Furniture) GameObjectFactory.createGameObject(grid,26,28,GameObjectType.FURNITURE);
        Furniture furniture12 = (Furniture) GameObjectFactory.createGameObject(grid,38,10,GameObjectType.FURNITURE);
        Furniture furniture13 = (Furniture) GameObjectFactory.createGameObject(grid,38,12,GameObjectType.FURNITURE);
        Furniture furniture14 = (Furniture) GameObjectFactory.createGameObject(grid,38,14,GameObjectType.FURNITURE);
        Furniture furniture15 = (Furniture) GameObjectFactory.createGameObject(grid,38,16,GameObjectType.FURNITURE);
        Furniture furniture16 = (Furniture) GameObjectFactory.createGameObject(grid,36,10,GameObjectType.FURNITURE);
        Furniture furniture17 = (Furniture) GameObjectFactory.createGameObject(grid,34,10,GameObjectType.FURNITURE);
        Furniture furniture18 = (Furniture) GameObjectFactory.createGameObject(grid,32,10,GameObjectType.FURNITURE);
        Furniture furniture19 = (Furniture) GameObjectFactory.createGameObject(grid,50,6,GameObjectType.FURNITURE);
        Furniture furniture20 = (Furniture) GameObjectFactory.createGameObject(grid,48,6,GameObjectType.FURNITURE);
        Furniture furniture23 = (Furniture) GameObjectFactory.createGameObject(grid,52,32,GameObjectType.FURNITURE);
        Furniture furniture24 = (Furniture) GameObjectFactory.createGameObject(grid,52,28,GameObjectType.FURNITURE);
        Furniture furniture25 = (Furniture) GameObjectFactory.createGameObject(grid,52,30,GameObjectType.FURNITURE);
        Furniture furniture26 = (Furniture) GameObjectFactory.createGameObject(grid,50,30,GameObjectType.FURNITURE);

        for (int i = 0; i < 40; i = i + 2) {
            GameObjectFactory.createGameObject(grid,0,i,GameObjectType.FURNITURE2);
        }
        for (int i = 0; i < 40; i = i +2){
            GameObjectFactory.createGameObject(grid,58,i,GameObjectType.FURNITURE2);
        }
        for (int i = 2; i < 58; i = i +2) {
            GameObjectFactory.createGameObject(grid,i,38,GameObjectType.FURNITURE2);
        }
        for (int i = 2; i < 58 ; i = i+2) {
            GameObjectFactory.createGameObject(grid,i,0,GameObjectType.FURNITURE2);
        }
    }
}


