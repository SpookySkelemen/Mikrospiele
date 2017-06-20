package com.willbergs.mikrospiele;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class GameOverActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        TextView finalScore = (TextView) findViewById(R.id.txtFinalScore);
        finalScore.setText("Your final score was " + TransitionActivity.score + "!");
    }
}
