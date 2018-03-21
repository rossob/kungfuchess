package com.blumhorst.ross.kungfuchess.view;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.blumhorst.ross.kungfuchess.R;
import com.blumhorst.ross.kungfuchess.presenter.BoardPresenter;
import com.blumhorst.ross.kungfuchess.presenter.BoardPresenterImpl;

/**
 * Created by rossblumhorst on 3/20/18.
 */

public class BoardActivity extends AppCompatActivity implements BoardView, GridViewInterface {

    private BoardPresenter boardPresenter;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_view);

        gridView = (GridView)findViewById(R.id.game_board);
        gridView.setViewListener(this);

        boardPresenter = new BoardPresenterImpl(this);
    }

    @Override
    public void onGridClick(int x, int y){
        int[] clickedSpot = {x, y};
        int[][] moves = {{x-1, y-1}, {x-1, y+1},{x+1, y+1},{x+1, y-1}};
        gridView.drawPossibleMoves(clickedSpot, moves);
    }
}
