package deltateam.Graphics;

public abstract class AbstractPosition {

    private Grid grid;
    private int col;
    private int row;

    public AbstractPosition(int col, int row, Grid grid){
        this.grid = grid;
        this.col = col;
        this.row = row;
    }

    public void moveInDirection(Direction direction, int distance) {
        switch (direction) {

            case UP:
                moveUp(distance);
                break;
            case DOWN:
                moveDown(distance);
                break;
            case LEFT:
                moveLeft(distance);
                break;
            case RIGHT:
                moveRight(distance);
                break;
        }

    }

    //TODO: unused
    public boolean equals(Position position){
        return this.col == position.getCol() && this.row == position.getRow();
    }

    public abstract void show();

    public abstract void hide();


    //TODO:VER
    //VER
    private void moveUp(int distance){
        //TODO:if its bad get rid of it
        //int maxRowsUp = Math.min(distance,0); //mal
        setPos(col, row - distance);
    }

    private void moveDown(int distance){
        //TODO:fetus deletus
        //int maxRowsDown = Math.min(distance,getRow());
        setPos(col, row + distance);
    }

    private void moveLeft(int distance){
        //TODO:begone thot
        //int maxColsLeft = Math.min(distance,0);
        setPos(col - distance, row);
    }

    private void moveRight(int distance){
        //TODO: *internal screaming*
        //int maxColsRight = Math.min(distance,getCol());
        setPos(col + distance, row);
    }

    //TODO: wut
    //BR


    //xGETTERS & SETTERS
    public Grid getGrid() {
        return grid;
    }

    //TODO:IDE has great ideas sometimes
    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
