package com.blumhorst.ross.kungfuchess.presenter;

import android.util.Log;

import com.blumhorst.ross.kungfuchess.view.BoardView;

public class BoardPresenterImpl implements BoardPresenter {

    private BoardView boardView;

    private int[] clickedSpot;
    private int[][] moves;

    private int[] redMaster = {2, 0};
    private int[][] redStudents = {{0, 0}, {1, 0}, {3, 0}, {4, 0}};
    private int[] blueMaster = {2, 4};
    private int[][] blueStudents = {{0, 4}, {1, 4}, {3, 4}, {4, 4}};



    public BoardPresenterImpl(BoardView boardView) {
        this.boardView = boardView;
    }

    public void setClickedSpot(int[] clickedSpot) {
        this.clickedSpot = clickedSpot;
    }

    public void setMoves() {
        int x = clickedSpot[0];
        int y = clickedSpot[1];
        Log.d("setClickedSpot", x + " " + y);
        moves = new int[4][2];
        moves[0][0] = x - 1;
        moves[0][1] = y - 1;
        moves[1][0] = x - 1;
        moves[1][1] = y + 1;
        moves[2][0] = x + 1;
        moves[2][1] = y + 1;
        moves[3][0] = x + 1;
        moves[3][1] = y - 1;
    }

    public boolean pawnIsSelected() {
        if(clickedSpot == null) { return false; }
        if(redMaster[0] == clickedSpot[0] && redMaster[1] == clickedSpot[1]
                || blueMaster[0] == clickedSpot[0] && blueMaster[1] == clickedSpot[1] ) {
            return true;
        } for(int[] student: redStudents) {
            if(student[0] == clickedSpot[0] && student[1] == clickedSpot[1]) {
                return true;
            }
        } for(int[] student: blueStudents) {
            if(student[0] == clickedSpot[0] && student[1] == clickedSpot[1]) {
                return true;
            }
        }
        return false;
    }

    public boolean isPossibleMove(int[] clickedSpot) {
        for(int[] move: moves) {
            if(move[0] == clickedSpot[0] && move[1] == clickedSpot[1])
                return true;
        }
        return false;
    }

    public void moveSelectedPawn(int[] spotToMoveTo) {
        if(redMaster[0] == clickedSpot[0] && redMaster[1] == clickedSpot[1]) {
            redMaster[0] = spotToMoveTo[0];
            redMaster[1] = spotToMoveTo[1];
            return;
        } else if(blueMaster[0] == clickedSpot[0] && blueMaster[1] == clickedSpot[1]) {
            blueMaster[0] = spotToMoveTo[0];
            blueMaster[1] = spotToMoveTo[1];
            return;
        }
        for(int[] student: blueStudents) {
            if(student[0] == clickedSpot[0] && student[1] == clickedSpot[1]) {
                student[0] = spotToMoveTo[0];
                student[1] = spotToMoveTo[1];
                return;
            }
        }
        for(int[] student: blueStudents) {
            if(student[0] == clickedSpot[0] && student[1] == clickedSpot[1]) {
                student[0] = spotToMoveTo[0];
                student[1] = spotToMoveTo[1];
                return;
            }
        }
        moves = null;
        clickedSpot = null;
    }

    public int[][] getMoves() {
        return moves;
    }

    public int[][] getRedStudents() {
        return redStudents;
    }

    public int[] getRedMaster() {
        return redMaster;
    }

    public int[][] getBlueStudents() {
        return blueStudents;
    }

    public int[] getBlueMaster() {
        return blueMaster;
    }
}
