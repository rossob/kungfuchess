package com.blumhorst.ross.kungfuchess.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.blumhorst.ross.kungfuchess.R;

/**
 * Created by rossblumhorst on 3/20/18.
 */

public class GridView extends View {

    private GridViewInterface gridViewInterface;

    private int cellWidth, cellHeight;
    private int[] clickedSpot;
    private int[][] moves;

    private Paint paint = new Paint();
    private Paint currentSpot = new Paint();
    private Paint possibleMoves = new Paint();

    private int[] redMaster;
    private int[][]redStudents;
    private int[] blueMaster;
    private int[][] blueStudents;

    public GridView(Context context) {
        this(context, null);
    }

    public GridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setStyle(Paint.Style.STROKE);
        currentSpot.setStyle(Paint.Style.FILL);
        currentSpot.setARGB(63, 127, 63, 63);
        possibleMoves.setStyle(Paint.Style.FILL);
        possibleMoves.setARGB(63, 63, 63, 63);
    }

    public void setViewListener(GridViewInterface gridViewInterface) {
        this.gridViewInterface = gridViewInterface;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        calculateDimensions();
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }

    private void calculateDimensions() {
        cellWidth = cellHeight = getWidth() / 5;

        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Log.d("onDraw", "clickedSpot: " + clickedSpot + ", possibleMoves: " + possibleMoves);
        canvas.drawColor(Color.WHITE);

        Drawable redMasterDrawable = getResources().getDrawable(R.drawable.master_red);
        Drawable redStudentDrawable = getResources().getDrawable(R.drawable.student_red);
        Drawable blueMasterDrawable = getResources().getDrawable(R.drawable.master_blue);
        Drawable blueStudentDrawable = getResources().getDrawable(R.drawable.student_blue);

        int width = getWidth();
        int height = getWidth();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                canvas.drawRect(
                        i * cellWidth,
                        j * cellHeight,
                        (i + 1) * cellWidth,
                        (j + 1) * cellHeight,
                        paint
                );
                if (clickedSpot != null && clickedSpot[0] == i && clickedSpot[1] == j) {
                    canvas.drawRect(
                            i * cellWidth,
                            j * cellHeight,
                            (i + 1) * cellWidth,
                            (j + 1) * cellHeight,
                            currentSpot
                    );
                }
                if (moves != null) {
                    for (int x = 0; x < moves.length; x++) {
                        if (moves[x][0] == i && moves[x][1] == j) {
                            canvas.drawRect(
                                    i * cellWidth,
                                    j * cellHeight,
                                    (i + 1) * cellWidth,
                                    (j + 1) * cellHeight,
                                    possibleMoves
                            );
                        }
                    }
                }
            }
        }

        for (int i = 1; i < 5; i++) {
            canvas.drawLine(
                    i * cellWidth,
                    0,
                    i * cellWidth,
                    height,
                    paint);
        }

        for (int i = 1; i < 5; i++) {
            canvas.drawLine(
                    0,
                    i * cellHeight,
                    width,
                    i * cellHeight,
                    paint);
        }

        redMasterDrawable.setBounds(
                (redMaster[0] * cellWidth) + (cellWidth / 2) - 48,
                (redMaster[1] * cellHeight) + (cellHeight / 2) - 48,
                (redMaster[0] * cellWidth) + (cellWidth / 2) + 48,
                (redMaster[1] * cellHeight) + (cellHeight / 2) + 48
        );
        redMasterDrawable.draw(canvas);

        for (int[] student : redStudents) {
            redStudentDrawable.setBounds(
                    (student[0] * cellWidth) + (cellWidth / 2) - 24,
                    (student[1] * cellHeight) + (cellHeight / 2) - 24,
                    (student[0] * cellWidth) + (cellWidth / 2) + 24,
                    (student[1] * cellHeight) + (cellHeight / 2) + 24
            );
            redStudentDrawable.draw(canvas);
        }

        blueMasterDrawable.setBounds(
                (blueMaster[0] * cellWidth) + (cellWidth / 2) - 48,
                (blueMaster[1] * cellHeight) + (cellHeight / 2) - 48,
                (blueMaster[0] * cellWidth) + (cellWidth / 2) + 48,
                (blueMaster[1] * cellHeight) + (cellHeight / 2) + 48
        );
        blueMasterDrawable.draw(canvas);

        for (int[] student : blueStudents) {
            blueStudentDrawable.setBounds(
                    (student[0] * cellWidth) + (cellWidth / 2) - 24,
                    (student[1] * cellHeight) + (cellHeight / 2) - 24,
                    (student[0] * cellWidth) + (cellWidth / 2) + 24,
                    (student[1] * cellHeight) + (cellHeight / 2) + 24
            );
            blueStudentDrawable.draw(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            int column = (int) (event.getX() / cellWidth);
            int row = (int) (event.getY() / cellHeight);
            gridViewInterface.onGridClick(column, row);
        }
        return true;
    }

    public void setPawnPositions(int[] redMaster, int[][] redStudents, int[] blueMaster, int[][] blueStudents) {
        this.redMaster = redMaster;
        this.redStudents = redStudents;
        this.blueMaster = blueMaster;
        this.blueStudents = blueStudents;
        invalidate();
    }

    public void drawPossibleMoves(int[] clickedSpot, int[][] moves) {
        if (clickedSpot != null && moves != null) {
            this.clickedSpot = clickedSpot;
            this.moves = moves;
            invalidate();
        }
    }
}
