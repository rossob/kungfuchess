package com.blumhorst.ross.kungfuchess.presenter;

import com.blumhorst.ross.kungfuchess.view.BoardView;

public class BoardPresenterImpl implements BoardPresenter {

    private BoardView boardView;

    public BoardPresenterImpl() { }

    public BoardPresenterImpl(BoardView boardView) {
        this.boardView = boardView;
    }
}
