package org.academiadecodigo.codezillas.deltateam.GameObject;

import org.academiadecodigo.codezillas.deltateam.Graphics.Grid;
import org.academiadecodigo.codezillas.deltateam.Graphics.Position;

public class Furniture extends GameObject {

    public Furniture(Grid grid, Position position){
        super(grid, position,GameObjectType.FURNITURE);
    }

}
