package com.willbergs.mikrospiele;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class DuelActivity extends Activity {

    private int rand = (int) (Math.random() * (500 - 3000 + 1) + 3000);     // from half a second to a full second
    private int react = (int) (Math.random() * (500 - 1000 + 1) + 1000);    // for the enemy
    private boolean success = false;                                        // to check if the button press is valid
    private ImageView arm = (ImageView) (findViewById(R.id.imgDuelArm));    // the arm graphic
    private ImageView enemy = (ImageView) (findViewById(R.id.imgDuelist));  // the enemy graphic
    private Thread timerThread = new Thread() {
        @Override
        public void run() {
            try {
                sleep(rand);
                success = true;
                sleep(react);
                fail(true);
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
        }
    }
}
