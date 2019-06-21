package org.academiadecodigo.codezillas.deltateam.GameObject;

import org.academiadecodigo.codezillas.deltateam.Graphics.Direction;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.security.Key;

public class Player extends GameObject implements Movable, Destroyable, KeyboardHandler {

    public static final int SPEED = 1; //Check velocity
    private String name;
    private Bullet bullet;
    private Keyboard keyboard;
    private boolean destroyed;
    private int hitPoints;
    private Direction direction;
    private boolean moving;

    public void init(){}

    public void shoot(){}

    public void keyPress(KeyboardEvent keyboardEvent){}

    public void keyRelease(KeyboardEvent keyboardEvent){}

    @Override
    public static void receiveDamage(int damage){
        System.out.println("morri");
    }

}
