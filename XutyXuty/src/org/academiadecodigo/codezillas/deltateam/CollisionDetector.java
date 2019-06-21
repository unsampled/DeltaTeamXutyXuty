package org.academiadecodigo.codezillas.deltateam;

import org.academiadecodigo.codezillas.deltateam.GameObject.Bullet;
import org.academiadecodigo.codezillas.deltateam.GameObject.GameObject;
import org.academiadecodigo.codezillas.deltateam.GameObject.GameObjectType;
import org.academiadecodigo.codezillas.deltateam.GameObject.Player;

public class CollisionDetector {

    private GameObject[] gameObjects;


    public CollisionDetector (GameObject[] gameObjects) {

        this.gameObjects = gameObjects;
    }


    public void bulletCheck(Bullet bullet, GameObject gameObject) {

        if (gameObject instanceof Player) {

            Player player = (Player) gameObject;
            bullet.hit(player);
        }

        bullet.hide; // make method in class bullet
    } //Or Position of the bullet as parameter

    public void playerCheck(Player player, GameObject gameObject) {

        if (gameObject instanceof Bullet) {

            Bullet bullet = (Bullet) gameObject;
            bullet.hit(player);
            bullet.hide; // make method in class bullet
        }

        player.getMoving = false; // getMoving class player
    }

    public void checkCollision(GameObject gameObject) {

        for (GameObject object : gameObjects) {

            if (object == gameObject) {
                continue;
            }

            if (object.getPosition.equals(gameObject.getPosition)) { //getPosition in class GameObject

                switch (object.getGameObjectType) { //getGameObjectType in class GameObject

                    case BULLET:

                        Bullet bullet = (Bullet) object;
                        bulletCheck(bullet, gameObject);
                        break;

                    case PLAYER:

                        Player player = (Player) object;
                        playerCheck(player, gameObject);
                        break;
                }
            }
        }
    } //Or Position of the player as parameter

}
