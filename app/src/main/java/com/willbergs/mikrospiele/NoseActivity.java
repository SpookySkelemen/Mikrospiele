package com.willbergs.mikrospiele;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

public class NoseActivity extends Activity {

    private ImageButton pickBtn;
    private ImageView timer;
    private ImageView arm;
    private ImageView nose;
    private boolean winState;
    private float xPos;
    private float yPos;
    private Thread timerThread;
    private Thread noseThread;
    private Thread armThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nose);

        pickBtn = (ImageButton) (findViewById(R.id.btnPick));
        timer = (ImageView) (findViewById(R.id.imgTimer));
        arm = (ImageView) (findViewById(R.id.imgArm));
        nose = (ImageView) (findViewById(R.id.imgNose));
        winState = false;
        xPos = 0;
        yPos = 250;
        timerThread = new Thread() {
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
        noseThread = new Thread() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        int change = 1;
                        for (int x = 0; x < 5; x++) {
                            try {
                                sleep(1000 / 60);   // moves at about 60fps
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            // move the nose in the correct direction.
                            if (nose.getX() == 0) {
                                change = 1;
                            } else if (nose.getX() == 104) {
                                change = -1;
                            }

                            // move the nose
                            xPos = xPos + change;
                            nose.setX(xPos);
                        }
                    }
                });
            }
        };
        armThread = new Thread() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        for (int x = 0; x < 22; x++) {
                            try {
                                sleep(1000 / 30);     // moves at about 30fps
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            yPos = yPos + 5;
                        }
                        if (xPos <= 46 && xPos >= 50) {                  // on a success
                            nose.setImageResource(R.drawable.nose2);    // change the nose graphic
                            arm.setImageResource(R.drawable.arm2);      // change the arm graphic
                        } else {                                           // on a failure
                            nose.setImageResource(R.drawable.nose3);    // change the nose graphic
                        }
                    }
                });
            }
        };

        timerThread.start();    // start the timer
        noseThread.start();     // make the nose start moving
    }




    protected void pick (){         // btnPick onClick method
        noseThread.interrupt();     // stop the nose moving side to side
        armThread.start();          // start the arm animation
        pickBtn.setEnabled(false);  // disable the button

        // determine whether the player wins or loses
        if (xPos <= 46 && xPos >= 50){
            winState = true;
        }
        else{
            winState = false;
        }
    }


    private void end() {            // when the timer ends
        if (winState == false) {    // if the player did not succeed
            TransitionActivity.lives = TransitionActivity.lives - 1;
        }
        Intent myIntent = new Intent(getApplicationContext(), TransitionActivity.class);
        startActivity(myIntent);
        finish();
    }
}
