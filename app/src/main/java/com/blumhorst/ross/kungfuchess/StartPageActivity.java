package com.blumhorst.ross.kungfuchess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blumhorst.ross.kungfuchess.presenter.BoardPresenterImpl;
import com.blumhorst.ross.kungfuchess.view.BoardActivity;

public class StartPageActivity extends AppCompatActivity {

    private Button startGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        startGameButton = findViewById(R.id.start_game_button);
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartPageActivity.this, BoardActivity.class);
                startActivity(intent);
            }
        });
    }
}
