package org.academiadecodigo.codezillas.deltateam.gameobject;

import org.academiadecodigo.codezillas.deltateam.grid.Grid;
import org.academiadecodigo.codezillas.deltateam.grid.GridDirection;
import org.academiadecodigo.codezillas.deltateam.grid.position.GridPosition;

public class Player extends GameObject {

    public static final int HIT_POINTS = 100; //Definir vida
    public static final int SPEED = 1; //Definir velocidade de deslocamento
    private String name;
    private Bullet bullet;
    private GridDirection direction;
    private boolean moving;
    private boolean destroyed;
    //Mais propriedades?

    public Player(Grid grid, GridPosition position, String name, Bullet bullet){
        super(grid,position);

        this.name  = name;
        this.bullet = bullet;

    }

    public void hit (int damage){}

    public void suffer(int damage){}

    public void shoot(Bullet bullet){}

    public void move(){}

}
