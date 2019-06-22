package org.academiadecodigo.codezillas.deltateam.GameObject;

import org.academiadecodigo.codezillas.deltateam.Graphics.Direction;
import org.academiadecodigo.codezillas.deltateam.Graphics.Grid;
import org.academiadecodigo.codezillas.deltateam.Graphics.Position;

public class Bullet extends  GameObject implements Movable{

    private static final int SPEED = 1; //check
    private static final int DAMAGE = 25; //check
    private boolean moving;
    private Direction direction;

    public Bullet(Grid grid, Position position, Direction direction) {
        super(grid, position, GameObjectType.BULLET);
        this.direction = direction;
    }

    public void hit(Player player){
        player.receiveDamage(DAMAGE);
    }

    @Override
    public void move(){
        getPosition().moveInDirection(direction, SPEED);
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void hide(){
        this.getPosition().hide();
    }
}
