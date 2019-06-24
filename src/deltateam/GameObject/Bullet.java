package deltateam.GameObject;

import deltateam.Graphics.Direction;
import deltateam.Graphics.Grid;
import deltateam.Graphics.Position;

public class Bullet extends GameObject implements Movable{

    private static final int SPEED = 1; //check
    private static final int DAMAGE = 100; //check
    private boolean moving;
    private Direction direction;
    private boolean available;

    public Bullet(Grid grid, Position position, Direction direction) {
        super(grid, position, GameObjectType.BULLET);
        this.direction = direction;
    }

    public void hit(Player player){
        player.receiveDamage(DAMAGE);
    }

    public void hit(Player2 player){
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

    public void hide()
    {
        this.getPosition().hide();
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getSPEED() {
        return SPEED;
    }
}


