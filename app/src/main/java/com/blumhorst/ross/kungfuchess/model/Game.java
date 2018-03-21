package com.blumhorst.ross.kungfuchess.model;

import com.blumhorst.ross.kungfuchess.model.Card;

public class Game {

    private int redPlayerCount;
    private int redPlayerStudents[][];
    private int[] redPlayerMaster = new int[2];

    private int bluePlayerCount;
    private int[][] bluePlayerStudents = new int[5][2];
    private int[] bluePlayerMaster = new int[2];

    public Card[] cards;

    public Game() {
        initializeBoard();
    }

    private void initializeBoard() {
        redPlayerCount = 5;
        redPlayerStudents = new int[][]{
            {0,0}, {0,1}, {0,3}, {0,4}
        };
        redPlayerMaster = new int[]{0,2};

        bluePlayerCount = 5;
        bluePlayerStudents = new int[][]{
            {4,0}, {4,1}, {4,3}, {4,4}
        };
        bluePlayerMaster = new int[]{4,2};
    }
}

