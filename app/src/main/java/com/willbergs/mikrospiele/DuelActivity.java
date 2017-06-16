package com.willbergs.mikrospiele;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import static android.os.SystemClock.sleep;

public class DuelActivity extends Activity {

    private int rand;     // from half a second to a full second
    private int react;    // for the enemy
    private boolean success;                                        // to check if the button press is valid
    private ImageView arm;    // the arm graphic
    private ImageView enemy;  // the enemy graphic
    private ImageView message;   // the graphic to tell the player when to tap
    private Thread timerThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duel);

        rand = (int) (Math.random() * (500 - 3000 + 1) + 3000);     // from half a second to a full second
        react = (int) (Math.random() * (500 - 1000 + 1) + 1000);    // for the enemy
        success = false;                                        // to check if the button press is valid
        arm = (ImageView) (findViewById(R.id.imgDuelArm));    // the arm graphic
        enemy = (ImageView) (findViewById(R.id.imgDuelist));  // the enemy graphic
        message = (ImageView) (findViewById(R.id.imgDraw));   // the graphic to tell the player when to tap
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


    protected void draw (){
        if (success == true) {
            arm.setImageResource(R.drawable.duel_arm);
            enemy.setImageResource(R.drawable.duelist2);
        } else {
            fail(false);
        }

        end(null);
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
        sleep(500);
        end(null);
    }

    protected void end (View view) {
        Intent myIntent = new Intent (getApplicationContext(), TransitionActivity.class);
        startActivity(myIntent);
        finish();
    }
}
