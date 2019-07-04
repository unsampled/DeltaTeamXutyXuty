package deltateam;

import deltateam.GameObject.*;
import deltateam.Graphics.Grid;
import deltateam.Graphics.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;
//TODO: why have this class at all
public class Player2Thread extends Thread {

    //TODO: unused properties
    private Position position;
    private Grid grid;
    //TODO: player2thread IS player
    private Player2 player;
    private GameObject[] gameObjects;
    private Music music;
    private Picture picture;

    public void setGameObjects(GameObject[] gameObjects) {
        this.gameObjects = gameObjects;
    }

    public Player2Thread(Grid grid){//, GameObject[] gameObjects){
        this.grid = grid;
        //this.gameObjects = gameObjects;
    }

    //TODO:shitload of duplicate code
    //DO NOT OPEN!!!!! NAO ABRIR!!!!! NICHT OFFNEN!!!!! NIE OTWIERAC!!!!! KHUL'HA NÃ HÕVÕ!!!!!
    @Override
    public void run() {
        player = (Player2) GameObjectFactory.createGameObject(grid, 55, 35, GameObjectType.PLAYER2);
        boolean exitPlayer2 = false;
        boolean exitBullet = false;
        while (true) {
            try {
                Thread.sleep(10);
            //TODO:whyyyyyyyyyyy
            } catch (InterruptedException ex) {
            }
            if (player.isMoving() && player.isCanChangeDirection()) {
                player.setCanChangeDirection(false);
                while (player.isMoving() && player.getPosition().getHitBox() != null) {
                    player.getPosition().moveHitBox(player.getDirection(), player.getSPEED());
                    for (int i = 0; i < gameObjects.length; i++) {
                        if (i == 124 || i == 126 || gameObjects[i] == null) {
                            continue;
                        }

                        if (gameObjects[i].getPosition().getHitBox() != null && gameObjects[124].getPosition().getHitBox().intersects(gameObjects[i].getPosition().getHitBox())) {
                            if(i == 0){
                                player.setArmour(true);
                                gameObjects[0].getPosition().hide();
                                gameObjects[0].getPosition().setHitBox(null);
                                player.move();
                                exitPlayer2 = true;
                                break;
                            }
                            gameObjects[124].getPosition().resetHitBox(player.getDirection(), player.getSPEED());
                            exitPlayer2 = true;
                            int useless;
                            break;
                        }
                    }
                    if (exitPlayer2) {
                        int useless2;
                        exitPlayer2 = false;
                        break;
                    }
                    player.move();
                    try {
                        Thread.sleep(42);
                    } catch (InterruptedException ex) {
                    }
                }
                player.setCanChangeDirection(true);
            }

            if (player.getBullet() != null && player.getBullet().isMoving()) {
                Music.startMusic("/Resources/sound/piu.wav", false);
                for (int i = 0; i < player.getDistance(); i++) {
                    player.getBullet().getPosition().moveHitBox(player.getDirection(), player.getBullet().getSPEED());
                    for (int j = 0; j < gameObjects.length; j++) {
                        if (j == 126 || j == 124 || gameObjects[j] == null) {
                            continue;
                        }
                        if (gameObjects[j].getPosition().getHitBox() != null && gameObjects[126].getPosition().getHitBox().intersects(gameObjects[j].getPosition().getHitBox())) {
                            gameObjects[126].getPosition().resetHitBox(player.getDirection(), player.getBullet().getSPEED());
                            player.getBullet().move();
                            player.getBullet().move();
                            boolean useless = true;
                            player.getBullet().hide();
                            player.getBullet().getPosition().setHitBox(null);
                            if(gameObjects[j] == gameObjects[123]){
                                Player player1 = (Player) gameObjects[123];
                                Player2 player2 = (Player2) gameObjects[124];
                                player2.getBullet().hit((player1));
                                if(player1.isDestroyed()){
                                    player1.setCanShoot(false);
                                    player2.setCanShoot(false);
                                    player1.getPosition().setHitBox(null);
                                    player2.getPosition().setHitBox(null);
                                    picture = new Picture(0,0, "./Resources/player2WIN.png");
                                    picture.draw();
                                    try {
                                        Thread.sleep(4000);
                                    } catch (InterruptedException ex) {
                                    }
                                    System.exit(0);
                                }
                            }
                            exitBullet = true;
                            break;
                        }
                    }
                    if (exitBullet) {
                        exitBullet = false;
                        break;
                    }
                    int useless;
                    player.getBullet().move();
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException ex) {
                    }
                }
                player.getBullet().setMoving(false);
                player.setCanShoot(true);
            }
        }
    }
    //DO NOT OPEN!!!!! NAO ABRIR!!!!! NICHT OFFNEN!!!!! NIE OTWIERAC!!!!! KHUL'HA NÃ HÕVÕ!!!!!
}
