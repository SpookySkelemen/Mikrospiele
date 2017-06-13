package com.willbergs.mikrospiele;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import static java.lang.Thread.sleep;

public class TransitionActivity extends Activity {

    public static int lives;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        transition();
    }


    public void transition() {
        ImageView heart1 = (ImageView) findViewById(R.id.imgHeart1);
        ImageView heart2 = (ImageView) findViewById(R.id.imgHeart2);
        ImageView heart3 = (ImageView) findViewById(R.id.imgHeart3);

        if (lives == 3) {
            for (int x = 0; x < 4; x++) {
                try {
                    heart1.setImageResource(R.drawable.heart_1);
                    heart2.setImageResource(R.drawable.heart_1);
                    heart3.setImageResource(R.drawable.heart_1);
                    sleep(33);
                    heart1.setImageResource(R.drawable.heart_2);
                    heart2.setImageResource(R.drawable.heart_2);
                    heart3.setImageResource(R.drawable.heart_2);
                    sleep(33);
                    heart1.setImageResource(R.drawable.heart_3);
                    heart2.setImageResource(R.drawable.heart_3);
                    heart3.setImageResource(R.drawable.heart_3);
                    sleep(33);
                    heart1.setImageResource(R.drawable.heart_4);
                    heart2.setImageResource(R.drawable.heart_4);
                    heart3.setImageResource(R.drawable.heart_4);
                    sleep(33);
                    heart1.setImageResource(R.drawable.heart_5);
                    heart2.setImageResource(R.drawable.heart_5);
                    heart3.setImageResource(R.drawable.heart_5);
                    sleep(33);
                    heart1.setImageResource(R.drawable.heart_6);
                    heart2.setImageResource(R.drawable.heart_6);
                    heart3.setImageResource(R.drawable.heart_6);
                    sleep(33);
                    heart1.setImageResource(R.drawable.heart_1);
                    heart2.setImageResource(R.drawable.heart_1);
                    heart3.setImageResource(R.drawable.heart_1);
                    sleep(802);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } // for x
        } else if (lives == 2) {
            for (int x = 0; x < 4; x++) {
                try {
                    heart1.setImageResource(R.drawable.heart_1);
                    heart2.setImageResource(R.drawable.heart_1);
                    heart3.setImageResource(R.drawable.heart_broken);
                    sleep(33);
                    heart1.setImageResource(R.drawable.heart_2);
                    heart2.setImageResource(R.drawable.heart_2);
                    sleep(33);
                    heart1.setImageResource(R.drawable.heart_3);
                    heart2.setImageResource(R.drawable.heart_3);
                    sleep(33);
                    heart1.setImageResource(R.drawable.heart_4);
                    heart2.setImageResource(R.drawable.heart_4);
                    sleep(33);
                    heart1.setImageResource(R.drawable.heart_5);
                    heart2.setImageResource(R.drawable.heart_5);
                    sleep(33);
                    heart1.setImageResource(R.drawable.heart_6);
                    heart2.setImageResource(R.drawable.heart_6);
                    sleep(33);
                    heart1.setImageResource(R.drawable.heart_1);
                    heart2.setImageResource(R.drawable.heart_1);
                    sleep(802);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } // try/catch
            } // for x
        } else if (lives == 1){
            for (int x = 0; x < 4; x++) {
                try {
                    heart1.setImageResource(R.drawable.heart_1);
                    heart2.setImageResource(R.drawable.heart_broken);
                    heart3.setImageResource(R.drawable.heart_broken);
                    sleep(33);
                    heart1.setImageResource(R.drawable.heart_2);
                    sleep(33);
                    heart1.setImageResource(R.drawable.heart_3);
                    sleep(33);
                    heart1.setImageResource(R.drawable.heart_4);
                    sleep(33);
                    heart1.setImageResource(R.drawable.heart_5);
                    sleep(33);
                    heart1.setImageResource(R.drawable.heart_6);
                    sleep(33);
                    heart1.setImageResource(R.drawable.heart_1);
                    sleep(802);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } // try/catch
            } // for x
        } else {
            heart1.setImageResource(R.drawable.heart_broken);
            heart2.setImageResource(R.drawable.heart_broken);
            heart3.setImageResource(R.drawable.heart_broken);
            try {
                sleep (1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } // try/catch
        } // if statement
        end();  // move on to next screen
    } // onCreate method


    public void end () {
        Intent myIntent = new Intent(getApplicationContext(), GameOverActivity.class);  // will be changed if they still have at least one life

        if (lives > 0){ // to move onto a game
            int rand = (int) (Math.random () * (5 - 1 + 1) + 1);
            if (rand == 1) {
                myIntent = new Intent (getApplicationContext(), ChiselActivity.class);
            } else if (rand == 2) {
                myIntent = new Intent (getApplicationContext(), NoseActivity.class);
            } else if (rand == 3) {
                myIntent = new Intent (getApplicationContext(), ChiselActivity.class);
            } else if (rand == 4) {
                myIntent = new Intent (getApplicationContext(), ChiselActivity.class);
            } else if (rand == 5) {
                myIntent = new Intent (getApplicationContext(), ChiselActivity.class);
            }
        }

        startActivity(myIntent);    // go to next screen
        finish();
    } // end method
} // TransitionActivity class
