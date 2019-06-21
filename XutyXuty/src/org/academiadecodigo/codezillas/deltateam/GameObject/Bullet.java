package org.academiadecodigo.codezillas.deltateam.GameObject;

import org.academiadecodigo.codezillas.deltateam.Graphics.Direction;
import org.academiadecodigo.codezillas.deltateam.Graphics.Grid;
import org.academiadecodigo.codezillas.deltateam.Graphics.Position;

public class Bullet extends  GameObject implements Movable{

    private static final int SPEED = 3; //check
    private static final int DAMAGE = 25; //check
    private boolean moving;
    private Direction direction;

    public Bullet(Grid grid, Position position, Direction direction) {
        super(grid, position, GameObjectType.BULLET);
        this.direction = direction;
        moving = true;
    }

    public void hit(Player player){
        player.receiveDamage(DAMAGE);
    }

    @Override
    public void move(){
        getPosition().moveInDirection(direction, 200);
        moving = false;
    }

    public boolean isMoving() {
        return moving;
    }
}
