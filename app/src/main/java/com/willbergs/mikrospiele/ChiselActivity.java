package com.willbergs.mikrospiele;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import static com.willbergs.mikrospiele.R.id.btnChisel;
import static com.willbergs.mikrospiele.R.id.imgTimer;

public class ChiselActivity extends Activity {

    private int progress = 0;
    private final ImageView timer = (ImageView) (findViewById(imgTimer));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chisel);
        Thread myThread = new Thread() {
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
        };
        myThread.start();
    }


    public void chisel(View view) {
        ImageButton chiselBtn = (ImageButton) (findViewById(btnChisel));
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
