package com.blumhorst.ross.kungfuchess.presenter;

/**
 * Created by rossblumhorst on 3/20/18.
 */

public interface BoardPresenter {

    void setClickedSpot(int[] clickedSpot);

    void setMoves();

    boolean pawnIsSelected();

    boolean isPossibleMove(int[] clickedSpot);

    void moveSelectedPawn(int[] spotToMoveTo);

    int[][] getMoves();

    int[][] getRedStudents();

    int[] getRedMaster();

    int[][] getBlueStudents();

    int[] getBlueMaster();
}
