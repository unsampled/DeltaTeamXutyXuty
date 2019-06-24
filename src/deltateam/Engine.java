package deltateam;

import deltateam.GameObject.*;
import deltateam.Graphics.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Engine {

    private Grid grid;
    private Player player;
    private GameObject[] gameObjects;
    private Player2Thread player2;
    private Picture picture;
    private Menu menu;


    public Engine() {
        menu = new Menu();
        Music.startMusic("/Resources/sound/menu.wav",true);
        while (!menu.isStartGame()){
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
            }
        }
        grid = new Grid();
        grid.init();
        MapFactory.init(grid);
        this.player = (Player) GameObjectFactory.createGameObject(grid, 3, 3, GameObjectType.PLAYER);
        player2 = new Player2Thread(grid);
        gameObjects = player.getGameObjects();
        player2.setGameObjects(gameObjects);
    }

    boolean exitPlayer = false;
    boolean exitBullet = false;


    public void start() {

        player2.start();
        player1Start();
    }

    //DO NOT OPEN!!!!! NAO ABRIR!!!!! NICHT OFFNEN!!!!! NIE OTWIERAC!!!!! KHUL'HA NÃ HÕVÕ!!!!!
    private void player1Start() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
            }
            if (player.isMoving() && player.isCanChangeDirection()) {
                player.setCanChangeDirection(false);
                while (player.isMoving()) {
                    player.getPosition().moveHitBox(player.getDirection(), player.getSPEED());
                    for (int i = 0; i < gameObjects.length; i++) {
                        if (i == 123 || i == 125 || gameObjects[i] == null) {
                            continue;
                        }
                        if (gameObjects[i].getPosition().getHitBox() != null && gameObjects[123].getPosition().getHitBox().intersects(gameObjects[i].getPosition().getHitBox())) {
                            if (i == 0) {
                                player.setArmour(true);
                                gameObjects[0].getPosition().hide();
                                gameObjects[0].getPosition().setHitBox(null);
                                exitPlayer = true;
                                player.move();
                                break;
                            }
                            gameObjects[123].getPosition().resetHitBox(player.getDirection(), player.getSPEED());
                            exitPlayer = true;
                            break;
                        }
                    }
                    if (exitPlayer) {
                        exitPlayer = false;
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
                Music.startMusic("/Resources/sound/xuty.wav",false);
                for (int i = 0; i < player.getDistance(); i++) {
                    player.getBullet().getPosition().moveHitBox(player.getDirection(), player.getBullet().getSPEED());
                    for (int j = 0; j < gameObjects.length; j++) {
                        if (j == 125 || j == 123 || gameObjects[j] == null) {
                            continue;
                        }
                        if (gameObjects[j].getPosition().getHitBox() != null && gameObjects[125].getPosition().getHitBox().intersects(gameObjects[j].getPosition().getHitBox())) {
                            gameObjects[125].getPosition().resetHitBox(player.getDirection(), player.getBullet().getSPEED());
                            player.getBullet().move();
                            player.getBullet().move();
                            player.getBullet().hide();
                            player.getBullet().getPosition().setHitBox(null);
                            if (gameObjects[j] == gameObjects[124]) {
                                Player player1 = (Player) gameObjects[123];
                                Player2 player2 = (Player2) gameObjects[124];
                                boolean useless = true;
                                player1.getBullet().hit(player2);
                                if (player2.isDestroyed()) {
                                    player1.getPosition().setHitBox(null);
                                    player2.getPosition().setHitBox(null);
                                    player1.setCanShoot(false);
                                    player2.setCanShoot(false);
                                    picture = new Picture(0,0, "./Resources/player1WIN.png");
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
                    player.getBullet().move();
                    try {
                        Thread.sleep(4);
                    } catch (InterruptedException ex) {
                    }
                }
                player.getBullet().setMoving(false);
                player.setCanShoot(true);
            }
            if (player.getHitPoints() == 0) {
                return;
            }
        }
    }
}   //DO NOT OPEN!!!!! NAO ABRIR!!!!! NICHT OFFNEN!!!!! NIE OTWIERAC!!!!! KHUL'HA NÃ HÕVÕ!!!!!


