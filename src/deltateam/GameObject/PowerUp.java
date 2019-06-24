package deltateam.GameObject;

import deltateam.Graphics.Grid;
import deltateam.Graphics.Position;

public class PowerUp extends GameObject {

    public PowerUp(Grid grid, Position position){
        super(grid, position, GameObjectType.POWERUP);
    }

}
