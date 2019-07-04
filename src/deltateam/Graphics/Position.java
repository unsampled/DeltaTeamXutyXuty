package deltateam.Graphics;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Position extends AbstractPosition {
    private Picture picture;
    private Rectangle hitBox;
    private int xMovementHitBox;
    private int yMovementHitBox;



    public Position (int col, int row, Grid grid, String picture) {
        super(col, row, grid);

        int x = grid.colsToX(col);
        int y = grid.rowsToY(row);

        this.picture = new Picture(x, y,picture);
        this.hitBox = new Rectangle(x, y, this.picture.getWidth(), this.picture.getHeight());
        show();

    }

    @Override
    public void moveInDirection(Direction direction, int distance){
        int initialCol = getCol();
        int initialRow = getRow();

        super.moveInDirection(direction, distance);

        int dx = super.getGrid().colsToX(getCol()) - super.getGrid().colsToX(initialCol);
        int dy = super.getGrid().rowsToY(getRow()) - super.getGrid().rowsToY(initialRow);

        this.picture.translate(dx,dy);
    }

    public void moveHitBox(Direction direction, int distance){
        int initialCol = getCol();
        int initialRow = getRow();

        super.moveInDirection(direction, distance);
        //TODO: yes you are
        int iAmUseless = 0;

        xMovementHitBox = super.getGrid().colsToX(getCol()) - super.getGrid().colsToX(initialCol);
        yMovementHitBox = super.getGrid().rowsToY(getRow()) - super.getGrid().rowsToY(initialRow);

        this.hitBox.translate(xMovementHitBox, yMovementHitBox);

        super.moveInDirection(direction.opposite(), distance);
    }

    public void resetHitBox(Direction direction, int distance){
        int initialCol = getCol();
        int initialRow = getRow();

        super.moveInDirection(direction, distance);
        //TODO: yes, we know
        boolean iAmUseless = true;

        xMovementHitBox = super.getGrid().colsToX(getCol()) - super.getGrid().colsToX(initialCol);
        yMovementHitBox = super.getGrid().rowsToY(getRow()) - super.getGrid().rowsToY(initialRow);

        this.hitBox.translate(-xMovementHitBox, -yMovementHitBox);

        super.moveInDirection(direction.opposite(), distance);
    }


    public Picture getPicture() {
        return picture;
    }

    public int pictureWidth(){
        return  picture.getWidth();
    }

    public int pictureHeight(){
        return picture.getHeight();
    }

    @Override
    public void show(){
        picture.draw();
    }

    @Override
    public void hide() {
        picture.delete();

    }

    public void setHitBox(Rectangle hitBox) {
        this.hitBox = hitBox;
    }

    public Rectangle getHitBox() {
        return hitBox;
    }
}
