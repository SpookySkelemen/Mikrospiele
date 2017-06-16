package com.willbergs.mikrospiele;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ChiselActivity extends Activity {


    protected int progress;
    protected ImageView timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chisel);

        progress = 0;
        timer = (ImageView) (findViewById(R.id.imgTimer));
        Thread myThread = new Thread() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            sleep(1000);
                            timer.setImageResource(R.drawable.timer4);
                            sleep(1000);
                            timer.setImageResource(R.drawable.timer3);
                            sleep(1000);
                            timer.setImageResource(R.drawable.timer2);
                            sleep(1000);
                            timer.setImageResource(R.drawable.timer1);
                            end();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            };
        myThread.start();
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
        } else {
            chiselBtn.setImageResource(R.drawable.chisel9);
            progress++;
        }
    }


    private void end() {
        if (progress < 7) {
            TransitionActivity.lives = TransitionActivity.lives - 1;
        }
        Intent myIntent = new Intent(getApplicationContext(), TransitionActivity.class);
        startActivity(myIntent);
    }
}
