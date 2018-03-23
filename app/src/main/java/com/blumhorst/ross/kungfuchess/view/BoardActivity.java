package com.blumhorst.ross.kungfuchess.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

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

        gridView = findViewById(R.id.game_board);
        gridView.setViewListener(this);

        boardPresenter = new BoardPresenterImpl(this);
        setPawnPositions();
    }

    @Override
    public void onGridClick(int x, int y){
        Log.d("onGridClick", "X: " + x + ",Y: " + y);
        int[] clickedSpot = {x, y};
        if(boardPresenter.pawnIsSelected()) {
            if(boardPresenter.isPossibleMove(clickedSpot)) {
                Log.d("jkhgfg", "jhgfd");
                boardPresenter.moveSelectedPawn(clickedSpot);
                setPawnPositions();
                gridView.drawPossibleMoves(clickedSpot, boardPresenter.getMoves());
            } else {
                gridView.drawPossibleMoves(new int[0], new int[0][0]);
            }
        } else {
            boardPresenter.setClickedSpot(clickedSpot);
            boardPresenter.setMoves();
            gridView.drawPossibleMoves(clickedSpot, boardPresenter.getMoves());
        }
    }

    private void setPawnPositions() {
        gridView.setPawnPositions(
                boardPresenter.getRedMaster(),
                boardPresenter.getRedStudents(),
                boardPresenter.getBlueMaster(),
                boardPresenter.getBlueStudents()
        );
    }
}
