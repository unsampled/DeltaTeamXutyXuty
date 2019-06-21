package org.academiadecodigo.codezillas.deltateam.GameObject;

import org.academiadecodigo.codezillas.deltateam.Graphics.Position;

import java.sql.BatchUpdateException;

public class Bullet extends GameObject implements Movable{

    public static final int SPEED = 1; //Change speed
    //public static final int DAMAGE = 10; //Different damages per instation?
    private static final int damage = 2; //Check

    public Bullet(Position position){
        super(position, GameObjectType.BULLET);
    };

    public void hit(Player player){};

}
