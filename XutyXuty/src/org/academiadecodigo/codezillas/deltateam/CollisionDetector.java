package org.academiadecodigo.codezillas.deltateam;

import org.academiadecodigo.codezillas.deltateam.GameObject.Bullet;
import org.academiadecodigo.codezillas.deltateam.GameObject.Destroyable;
import org.academiadecodigo.codezillas.deltateam.GameObject.GameObject;
import org.academiadecodigo.codezillas.deltateam.GameObject.Player;

public class CollisionDetector {
    private GameObject[] gameObjects;

    public CollisionDetector(GameObject[] gameObjects) {
        this.gameObjects = gameObjects;
    }

    public void bulletCheck(Bullet bullet){             //Or Position of the bullet as parameter
        for (GameObject goCounter : gameObjects) {

            // No point in checking collisions with self
            if (goCounter == bullet) {
                continue;
            }

            if (goCounter.getPos().equals(bullet.getPos())) {
                switch (goCounter) {
                    case ("PLAYER"):
                        ((Player) goCounter).hit();
                        break;
                    case ("DESTROYABLE"):
                        ((Destroyable) goCounter).hit();
                        break;
                    default:                            //Non destroyable furniture
                        break;
                }
            }
        }
    }

    public void playerCheck(Player player) {            //Or Position of the player as parameter

        for (GameObject goCounter : gameObjects) {

            // No point in checking collisions with self
            if (goCounter == player) {
                continue;
            }

            player.stopMoving();      //The player can't move anymore - and we know it's not a bullet (if the bulletCheck() is done before the playerCheck()

            }
        }
    }
}
