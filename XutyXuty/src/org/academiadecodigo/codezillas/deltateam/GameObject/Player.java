package org.academiadecodigo.codezillas.deltateam.GameObject;

import org.academiadecodigo.codezillas.deltateam.CollisionDetector;
import org.academiadecodigo.codezillas.deltateam.Graphics.Direction;
import org.academiadecodigo.codezillas.deltateam.Graphics.Grid;
import org.academiadecodigo.codezillas.deltateam.Graphics.Position;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.security.Key;

public class Player extends GameObject implements Movable, Destroyable, KeyboardHandler {

    private static final int SPEED = 1; //Check velocity
    private Bullet bullet;
    private Keyboard keyboard;
    private boolean destroyed;
    private int hitPoints;
    private Direction direction;
    private boolean moving;
    private Grid grid;
    private CollisionDetector collisionDetector;

    public Player(Grid grid, Position position){
        super(grid, position, GameObjectType.PLAYER);
        direction = Direction.UP;
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

        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(shoot);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent){

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_L){
            shoot();
        }

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_DOWN:
                direction = Direction.DOWN;
                System.out.println("asf");
                moving = true;
                break;
            case KeyboardEvent.KEY_LEFT:
                direction = Direction.LEFT;
                System.out.println("dsf");
                moving = true;
                break;
            case KeyboardEvent.KEY_RIGHT:
                direction = Direction.RIGHT;
                moving = true;
                break;
            case KeyboardEvent.KEY_UP:
                direction = Direction.UP;
                moving = true;
                break;
        }

    }

    public void shoot(){
        bullet = new Bullet(grid, grid.makeGridPosition(super.getPosition().getCol(),super.getPosition().getRow(), "./Resources/doll.png"), direction);
        bullet.move();
    }

    @Override
    public void receiveDamage(int damage){
        if(!destroyed){
            hitPoints -= damage;
        }
        if(hitPoints <= 0){
            hitPoints = 0;
            destroyed = true;
        }
    }

    @Override
    public void move(){

        getPosition().moveInDirection(direction, SPEED);
        moving = false;

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent){

    }

    public int getHitPoints() {
        return hitPoints;
    }

    public boolean isMoving() {
        return moving;
    }
}
