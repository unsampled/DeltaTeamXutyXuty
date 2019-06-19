package org.academiadecodigo.codezillas.deltateam.gfx;

import org.academiadecodigo.codezillas.deltateam.grid.Grid;
import org.academiadecodigo.codezillas.deltateam.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.swing.plaf.metal.MetalIconFactory;

public class GfxGrid implements Grid {

    public static final int PADDING = 10;
    public static final int CELL_SIZE = 1; // Requires checking
    public static final int COL = 662; // Decide later
    public static final int ROW = 1294; // Decide later
    private Picture canvas;

    public GfxGrid(){
        canvas = new Picture(0, 0, "/map-temple-ruins_50.png"); //Ask MC's why the fit is wrong
        canvas.draw();

    }

    public void getHeight(){
        System.out.println(canvas.getHeight());
    }

    public void getWidth(){
        System.out.println(canvas.getWidth());
    }




    @Override
    public GridPosition makeGridPosition(int a, int b){
        return null;
    }

    @Override
    public void init(){
    }


    @Override
    public int getRow() {
        return ROW;
    }

    @Override
    public int getCol() {
        return COL;
    }
}
