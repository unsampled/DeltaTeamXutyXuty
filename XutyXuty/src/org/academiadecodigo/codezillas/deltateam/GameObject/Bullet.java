package org.academiadecodigo.codezillas.deltateam.GameObject;

import org.academiadecodigo.codezillas.deltateam.Graphics.Direction;
import org.academiadecodigo.codezillas.deltateam.Graphics.Position;

public class Bullet extends  GameObject implements Movable{

    public static final int SPEED = 1; //check
    private static final int DAMAGE = 1; //check
    private boolean moving;

    public Bullet(Position position){
        super(position, GameObjectType.BULLET);
    }

    public void hit(Player player){}

    @Override
    public void move(Direction direction, Position position, int speed){}

}
