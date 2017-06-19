package com.willbergs.mikrospiele;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import static android.view.View.GONE;

public class ChiselActivity extends Activity {


    protected int progress;
    protected ViewGroup mainScrn;
    protected CountDownTimer timer;
    protected int time;
    protected ImageView timerImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chisel);

        progress = 0;
        mainScrn = (ViewGroup) (findViewById(R.id.activity_chisel));
        time = 5;
        timerImg = (ImageView) (findViewById(R.id.imgTimer));
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
        ImageButton chiselBtn = (ImageButton) (findViewById(R.id.btnChisel));
        chiselBtn.setEnabled(false);
    }


    public void start (View view){
        timer.start();
        ImageButton chiselBtn = (ImageButton) (findViewById(R.id.btnChisel));
        chiselBtn.setEnabled(true);
        Button startBtn = (Button) (findViewById(R.id.btnStart));
        startBtn.setVisibility(GONE);
    }


    public void update (){
        ImageButton chiselBtn = (ImageButton) (findViewById(R.id.btnChisel));
        time--;
        if (time == 4){
            timerImg.setImageResource(R.drawable.timer4);
        } else if (time == 3){
            timerImg.setImageResource(R.drawable.timer3);
        } else if (time == 2){
            timerImg.setImageResource(R.drawable.timer2);
        } else if (time == 1){
            timerImg.setImageResource(R.drawable.timer1);
        } else {
            chiselBtn.setEnabled(false);
        }
    }


    public void chisel(View view) {
        ImageButton chiselBtn = (ImageButton) (findViewById(R.id.btnChisel));

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
        if (progress < 8) {
            TransitionActivity.lives--;
        } else {
            TransitionActivity.score++;
        }

        Intent myIntent = new Intent(getApplicationContext(), TransitionActivity.class);
        startActivity(myIntent);
        finish();
    }
}
