package com.willbergs.mikrospiele;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import static android.os.SystemClock.sleep;

public class DuelActivity extends Activity {

    private int rand = (int) (Math.random() * (500 - 3000 + 1) + 3000);     // from half a second to a full second
    private int react = (int) (Math.random() * (500 - 1000 + 1) + 1000);    // for the enemy
    private boolean success = false;                                        // to check if the button press is valid
    private ImageView arm = (ImageView) (findViewById(R.id.imgDuelArm));    // the arm graphic
    private ImageView enemy = (ImageView) (findViewById(R.id.imgDuelist));  // the enemy graphic
    private ImageView message = (ImageView) (findViewById(R.id.imgDraw));   // the graphic to tell the player when to tap
    private Thread timerThread = new Thread() {
        @Override
        public void run() {
            try {
                sleep(rand);
                success = true;
                message.setImageResource(R.drawable.duel_draw);
                sleep(react);
                fail(true);
                message.setImageResource(Integer.parseInt(null));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duel);

        timerThread.start();
    }


    protected void draw (){
        if (success == true) {
            arm.setImageResource(R.drawable.duel_arm);
            enemy.setImageResource(R.drawable.duelist2);
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
        sleep(500);
        Intent myIntent = new Intent (getApplicationContext(), TransitionActivity.class);
    }

    protected void end () {
        Intent myIntent = new Intent (getApplicationContext(), TransitionActivity.class);
        startActivity(myIntent);
        finish();
    }
}
