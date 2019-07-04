package deltateam.GameObject;
//TODO:useless class, complete copy of Player
import deltateam.Graphics.Direction;
import deltateam.Graphics.Grid;
import deltateam.Graphics.Position;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player2 extends GameObject implements Movable, Destroyable, KeyboardHandler {

    private static final int SPEED = 1; //Check velocity
    private Bullet bullet;
    private Keyboard keyboard;
    private boolean destroyed;
    private int hitPoints;
    private Direction direction;
    private boolean moving;
    private boolean canShoot = true;
    private Grid grid;
    private GameObject[] gameObjects = GameObjectFactory.getGameObjects();
    private  boolean canChangeDirection = true;
    private int distance = 0;
    private boolean armour = false;

    public Player2(Grid grid, Position position){
        super(grid, position, GameObjectType.PLAYER);
        direction = Direction.LEFT;
        this.grid = grid;
        hitPoints = 100;
        keyboard = new Keyboard(this);

        init();
    }

    public void init(){

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_W);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_S);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_D);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_A);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent shoot = new KeyboardEvent();
        shoot.setKey(KeyboardEvent.KEY_Q);
        shoot.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent Up = new KeyboardEvent();
        Up.setKey(KeyboardEvent.KEY_W);
        Up.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent Down = new KeyboardEvent();
        Down.setKey(KeyboardEvent.KEY_S);
        Down.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent Right = new KeyboardEvent();
        Right.setKey(KeyboardEvent.KEY_D);
        Right.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent Left = new KeyboardEvent();
        Left.setKey(KeyboardEvent.KEY_A);
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

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_Q && canShoot && !moving) {
            switch (direction){
                case UP:
                    //TODO:brilliant
                    boolean useless = true;
                    distance = getPosition().getRow() + 2;
                    break;
                case DOWN:
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
            case KeyboardEvent.KEY_S:
                if(canChangeDirection) {
                    direction = Direction.DOWN;
                    moving = true;
                }
                break;
            case KeyboardEvent.KEY_A:
                if(canChangeDirection) {
                    direction = Direction.LEFT;
                    //TODO:directories should never be capitallized
                    getPosition().getPicture().load("./Resources/doll2Left.png");
                    moving = true;
                }
                break;
            case KeyboardEvent.KEY_D:
                if(canChangeDirection) {
                    direction = Direction.RIGHT;
                    getPosition().getPicture().load("./Resources/doll2.png");
                    moving = true;
                }
                break;
            case KeyboardEvent.KEY_W:
                if(canChangeDirection) {
                    direction = Direction.UP;
                    moving = true;
                }
                break;
        }

    }

    public void shoot(){
        bullet = new Bullet(grid, grid.makeGridPosition(this.getPosition().getCol(), this.getPosition().getRow(), "./Resources/Bullet.png"), direction);
        bullet.setMoving(true);
        gameObjects[126] = bullet;
    }

    @Override
    public void receiveDamage(int damage){
        if(!destroyed){
            if(armour){
                hitPoints -= damage/2;
                armour = false;
            } else {
                hitPoints -= damage;
            }
        }
        if(hitPoints <= 0){
            hitPoints = 0;
            destroyed = true;
            System.out.println(hitPoints);
        }
    }

    @Override
    public void move(){

        getPosition().moveInDirection(direction, SPEED);

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent){

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_S:
                moving = false;
                break;
            case KeyboardEvent.KEY_A:
                moving = false;
                break;
            case KeyboardEvent.KEY_D:
                moving = false;
                break;
            case KeyboardEvent.KEY_W:
                moving = false;
                break;
        }

    }
    //TODO:unused methods
    public int getHitPoints() {
        return hitPoints;
    }

    public boolean isMoving() {
        return moving;
    }

    public Bullet getBullet() {
        return bullet;
    }

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

    public int getDistance()
    {
        return distance;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setArmour(boolean armour) {
        this.armour = armour;
    }
}

