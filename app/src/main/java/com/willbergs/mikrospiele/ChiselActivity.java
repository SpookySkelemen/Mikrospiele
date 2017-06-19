package com.willbergs.mikrospiele;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class ChiselActivity extends Activity {


    protected int progress;
//    protected ImageView timer;
    protected Thread myThread;
    protected ViewGroup mainScrn;
    protected CountDownTimer timer;
    protected TextView timerTxt;
    protected int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chisel);

        progress = 0;
 //       timer = (ImageView) (findViewById(R.id.imgTimer));
        mainScrn = (ViewGroup) (findViewById(R.id.activity_chisel));
        /*myThread = new Thread() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            sleep(1000);
                            timer.setImageResource(R.drawable.timer4);
                            mainScrn.invalidate();
                            sleep(1000);
                            timer.setImageResource(R.drawable.timer3);
                            mainScrn.invalidate();
                            sleep(1000);
                            timer.setImageResource(R.drawable.timer2);
                            mainScrn.invalidate();
                            sleep(1000);
                            timer.setImageResource(R.drawable.timer1);
                            mainScrn.invalidate();
                            end();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            }; */
        // mainScrn = (ViewGroup) (findViewById(R.id.activity_chisel));

        time = 5;
        timerTxt = (TextView) (findViewById(R.id.txtTimer));
        timer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {
                time--;
            }

            @Override
            public void onFinish() {
                end();
            }
        };
    }


    public void start (){
        // myThread.start();
        timer.start();
    }


    public void chisel(View view) {
        ImageButton chiselBtn = (ImageButton) (findViewById(R.id.btnChisel));
        if (progress == 0) {
            chiselBtn.setImageResource(R.drawable.chisel2);
            progress++;
            start();
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

        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(myIntent);
        finish();
    }
}
