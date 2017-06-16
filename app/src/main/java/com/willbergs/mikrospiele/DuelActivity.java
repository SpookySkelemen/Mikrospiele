package com.willbergs.mikrospiele;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DuelActivity extends Activity {

    protected int rand;         // from half a second to a full second
    protected int react;        // for the enemy
    protected boolean success;  // to check if the button press is valid
    protected ImageView arm;    // the arm graphic
    protected ImageView enemy;  // the enemy graphic
    protected ImageView message;
    protected Thread timerThread;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duel);

        rand = (int) (Math.random() * (500 - 3000 + 1) + 3000); // from half a second to a full second
        react = (int) (Math.random() * (500 - 1000 + 1) + 1000);// for the enemy
        success = false;                                        // to check if the button press is valid
        arm = (ImageView) (findViewById(R.id.imgDuelArm));      // the arm graphic
        enemy = (ImageView) (findViewById(R.id.imgDuelist));    // the enemy graphic
        message = (ImageView) (findViewById(R.id.imgDraw));     // the graphic to tell the player when to tap
        timerThread = new Thread() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            sleep(rand);
                            success = true;
                            message.setImageResource(R.drawable.duel_draw);
                            sleep(react);
                            fail(true);
                            message.setVisibility(View.INVISIBLE);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        };

        timerThread.start();
    }



    protected void draw (View view){
        if (success == true) {
            arm.setImageResource(R.drawable.duel_arm);
            enemy.setImageResource(R.drawable.duelist2);
            end(null);
        } else {
            fail(false);
        }

    }


    protected void fail (boolean timeOut){
        success = false;

        timerThread.interrupt();

        if (timeOut == true){
            enemy.setImageResource(R.drawable.duelist3);
        } else {
            enemy.setImageResource(R.drawable.duelist4);
        }

        TransitionActivity.lives = TransitionActivity.lives - 1;
        end(null);
    }

    protected void end (View view) {
        Thread why =  new Thread() {
            @Override
            public void run() {
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent myIntent = new Intent (getApplicationContext(), TransitionActivity.class);
                startActivity(myIntent);
                finish();
            }
        };

        why.start();
    }
}
