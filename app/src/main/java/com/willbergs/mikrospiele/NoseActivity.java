package com.willbergs.mikrospiele;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class NoseActivity extends Activity {

    private final ImageView timer = (ImageView) (findViewById(R.id.imgTimer));
    private boolean winState = false;
    private ImageView arm = (ImageView) (findViewById(R.id.imgArm));
    private float xPos = 0;
    private float yPos = 250;
    private Thread timerThread = new Thread() {
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

    private Thread noseThread = new Thread() {
        @Override
        public void run() {
            for (int x = 0; x < 5; x++) {
                try {
                    sleep(1000 / 30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (arm.getX() < 104) {
                    xPos = xPos + 2;
                    arm.setX(xPos);
                } else {
                    xPos = xPos - 2;
                    arm.setX(xPos);
                }
            }
        }
    };

    private Thread armThread = new Thread() {
        @Override
        public void run() {
            for (int x = 0 ; x < 22 ; x++){
                try {
                    sleep(1000/30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                yPos = yPos + 5;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nose);

        timerThread.start();
        noseThread.start();
    }


    protected void pick (){
        noseThread.destroy();
        armThread.start();
        // disable button
        if (xPos <= 46 && xPos >= 50){
            winState = true;
        }
        else{
            winState = false;
        }
    }


    private void end() {
        if (winState == false) {
            TransitionActivity.lives = TransitionActivity.lives - 1;
        }
        Intent myIntent = new Intent(getApplicationContext(), TransitionActivity.class);
        startActivity(myIntent);
    }
}
