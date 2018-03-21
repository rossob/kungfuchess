package com.blumhorst.ross.kungfuchess.model;

/**
 * Created by rossblumhorst on 3/19/18.
 */

public class Card {

    private String title;
    private int[][] moves;

    public Card(String title, int[][] moves) {
        this.title = title;
        this.moves = moves;
    }
}
