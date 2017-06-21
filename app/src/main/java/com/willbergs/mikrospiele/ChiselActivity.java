package com.willbergs.mikrospiele;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import static android.view.View.GONE;

public class ChiselActivity extends Activity {

    // variables
    protected int progress;         // the number of clicks the user has done on the chiselBtn
    protected CountDownTimer timer; // the timer that finishes the game
    protected int time;             // a variable to keep track of the current countdown time (5,4,3,2,1)
    protected ImageView timerImg;   // visual representation of the countdown timer
    protected ImageButton chiselBtn;// the chisel button that the player will tap

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chisel);

        // assigning values to the variables.
        progress = 0;   // starts at zero
        time = 5;       // starts at five
        timerImg = (ImageView) (findViewById(R.id.imgTimer));
        chiselBtn = (ImageButton) (findViewById(R.id.btnChisel));

        timer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                update();
            }

            @Override
            public void onFinish() {
                ImageButton chiselBtn = (ImageButton) (findViewById(R.id.btnChisel));
                chiselBtn.setEnabled(false);
                end();
            }
        };
        chiselBtn.setEnabled(false);
    }


    public void start(View view) {
        timer.start();
        chiselBtn.setEnabled(true);
        Button startBtn = (Button) (findViewById(R.id.btnStart));
        startBtn.setVisibility(GONE);
    }


    // update() is called on whenever the timer ticks.
    public void update() {
        time--; // changing the current countdown number

        // updates the timer image
        if (time == 4) {
            timerImg.setImageResource(R.drawable.timer4);
        } else if (time == 3) {
            timerImg.setImageResource(R.drawable.timer3);
        } else if (time == 2) {
            timerImg.setImageResource(R.drawable.timer2);
        } else if (time == 1) {
            timerImg.setImageResource(R.drawable.timer1);
        } else {
            // prevents the player from using the button when the timer is done.
            chiselBtn.setEnabled(false);
        }
    }


    public void chisel(View view) {
        // changing the image and progressing the integer
        if (progress == 0) {
            chiselBtn.setImageResource(R.drawable.chisel2);
            progress++;
        } else if (progress == 1) {
            chiselBtn.setImageResource(R.drawable.chisel3);
            progress++;
        } else if (progress == 2) {
            chiselBtn.setImageResource(R.drawable.chisel4);
            progress++;
        } else if (progress == 3) {
            chiselBtn.setImageResource(R.drawable.chisel5);
            progress++;
        } else if (progress == 4) {
            chiselBtn.setImageResource(R.drawable.chisel6);
            progress++;
        } else if (progress == 5) {
            chiselBtn.setImageResource(R.drawable.chisel7);
            progress++;
        } else if (progress == 6) {
            chiselBtn.setImageResource(R.drawable.chisel8);
            progress++;
        } else if (progress == 7) {
            chiselBtn.setImageResource(R.drawable.chisel9);
            progress++;
        }
    }


    private void end() {
        if (progress < 8) { // if the player loses
            TransitionActivity.lives--;
        } else {            // if the player wins
            TransitionActivity.score++;
        }

        // moves back to the transition screen
        Intent myIntent = new Intent(getApplicationContext(), TransitionActivity.class);
        startActivity(myIntent);
        finish();
    }
}
