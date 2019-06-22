package org.academiadecodigo.codezillas.deltateam;


import org.academiadecodigo.codezillas.deltateam.GameObject.*;
import org.academiadecodigo.codezillas.deltateam.Graphics.Grid;
import org.academiadecodigo.codezillas.deltateam.Graphics.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {
    private Grid grid;


    public static void main(String[] args) {
        Grid grid = new Grid();
        grid.init();
        MapFactory.init(grid);
        Player player = (Player) GameObjectFactory.createGameObject(grid, 1, 1, GameObjectType.PLAYER);

        while (true) {

                while (player.isMoving()) {
                    player.move();
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException ex) {
                    }
                }
            if (player.getBullet() != null && player.getBullet().isMoving()) {
                for (int i = 0; i < 85; i++) {
                    player.getBullet().move();
                    try {
                        Thread.sleep(7);
                    } catch (InterruptedException ex) {
                    }
                }
            player.getBullet().setMoving(false);
            }


        }
    }
}
