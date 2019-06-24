package deltateam;

import deltateam.GameObject.Bullet;
import deltateam.GameObject.Player;
import deltateam.Graphics.Direction;
import deltateam.Graphics.Grid;
import deltateam.Graphics.Position;

public class BulletThread extends Thread {

    private Grid grid;
    private Position position;
    private Direction direction;
    private Bullet bullet;
    //private Player player;

    public BulletThread(Grid grid, Position position, Direction direction){
        this.grid = grid;
        this.position = position;
        this.direction = direction;
        //this.player = player;
    }

    public Bullet getBullet() {
        return bullet;
    }

    @Override
    public void run() {
       bullet = new Bullet(grid, position, direction);
       bullet.setMoving(true);

        if (bullet.isMoving()) {
            for (int i = 0; i < 85; i++) {
                bullet.move();
                try {
                    Thread.sleep(8);
                } catch (InterruptedException ex) {
                }
            }
            bullet.setMoving(false);
            //player.setCanShoot(true);
        }


    }
}
