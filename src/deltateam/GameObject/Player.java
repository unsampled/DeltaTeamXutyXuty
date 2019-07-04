package deltateam.GameObject;

import deltateam.Graphics.Direction;
import deltateam.Graphics.Grid;
import deltateam.Graphics.Position;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player extends GameObject implements Movable, Destroyable, KeyboardHandler {

    private static final int SPEED = 1; //Check velocity
    private Bullet bullet;
    private Keyboard keyboard;
    private boolean destroyed;
    private int hitPoints;
    private Direction direction;
    private boolean moving;
    private boolean canShoot = true;
    private Grid grid;
    //TODO: player also has all game objects, makes absolute sense
    private GameObject[] gameObjects = GameObjectFactory.getGameObjects();
    private  boolean canChangeDirection = true;
    private int distance;
    private boolean armour = false;

    public Player(Grid grid, Position position){
        super(grid, position, GameObjectType.PLAYER);
        direction = Direction.RIGHT;
        this.grid = grid;
        hitPoints = 100;
        keyboard = new Keyboard(this);
        init();
    }

    public void init(){

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent shoot = new KeyboardEvent();
        shoot.setKey(KeyboardEvent.KEY_L);
        shoot.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent Up = new KeyboardEvent();
        Up.setKey(KeyboardEvent.KEY_UP);
        Up.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent Down = new KeyboardEvent();
        Down.setKey(KeyboardEvent.KEY_DOWN);
        Down.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent Right = new KeyboardEvent();
        Right.setKey(KeyboardEvent.KEY_RIGHT);
        Right.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent Left = new KeyboardEvent();
        Left.setKey(KeyboardEvent.KEY_LEFT);
        Left.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(shoot);
        keyboard.addEventListener(Up);
        keyboard.addEventListener(Down);
        keyboard.addEventListener(Left);
        keyboard.addEventListener(Right);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent){

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_L && canShoot && !moving){
            switch (direction){
                case UP:
                    distance = getPosition().getRow() + 2;
                    break;
                case DOWN:
                    //TODO:CELL_SIZE is static, why are you accessing it through an instance?
                    distance = (grid.getPicture().getHeight()/grid.CELL_SIZE) - getPosition().getRow();
                    break;
                case LEFT:
                    distance = getPosition().getCol() + 2;
                    break;
                case RIGHT:
                    distance = (grid.getPicture().getWidth()/grid.CELL_SIZE) - getPosition().getCol();
            }
                setCanShoot(false);
                shoot();
        }

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_DOWN:
                if(canChangeDirection) {
                    direction = Direction.DOWN;
                    moving = true;
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                if(canChangeDirection) {
                    direction = Direction.LEFT;
                    getPosition().getPicture().load("./Resources/dollLeft.png");
                    moving = true;
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                if(canChangeDirection) {
                    direction = Direction.RIGHT;
                    getPosition().getPicture().load("./Resources/doll.png");
                    moving = true;
                }
                break;
            case KeyboardEvent.KEY_UP:
                if(canChangeDirection) {
                    direction = Direction.UP;
                    moving = true;
                }
                break;
        }

    }
    //TODO:could be private, make it private
    public void shoot(){
        bullet = new Bullet(grid, grid.makeGridPosition(this.getPosition().getCol(), this.getPosition().getRow(), "./Resources/Bullet2.png"), direction);
        bullet.setMoving(true);
        gameObjects[125] = bullet;

    }

    @Override
    public void receiveDamage(int damage){
        if(!destroyed){
            if(armour){
                hitPoints -= damage/2;
                armour = false;

            } else{
                hitPoints -= damage;
            }
        }

        if(hitPoints <= 0){
            hitPoints = 0;
            destroyed = true;
        }
    }

    @Override
    public void move(){

        getPosition().moveInDirection(direction, SPEED);

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent){
        //TODO:all resolutions are the same no matter what key is pressed, why a switch?
        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_DOWN:
                moving = false;
                break;
            case KeyboardEvent.KEY_LEFT:
                moving = false;
                break;
            case KeyboardEvent.KEY_RIGHT:
                moving = false;
                break;
            case KeyboardEvent.KEY_UP:
                moving = false;
                break;
        }

    }

    public int getHitPoints() {
        return hitPoints;
    }

    public boolean isMoving() {
        return moving;
    }

    public Bullet getBullet() {
        return bullet;
    }
    //TODO:unused setter
    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void setCanShoot(boolean canShoot) {
        this.canShoot = canShoot;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getSPEED() {
        return SPEED;
    }

    public GameObject[] getGameObjects() {
        return gameObjects;
    }

    public boolean isCanChangeDirection() {
        return canChangeDirection;
    }

    public void setCanChangeDirection(boolean canChangeDirection) {
        this.canChangeDirection = canChangeDirection;
    }

    public int getDistance() {
        return distance;
    }

    public void setArmour(boolean armour) {
        this.armour = armour;
    }

    public boolean isDestroyed() {
        return destroyed;
    }
}
