package com.willbergs.mikrospiele;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;

public class TransitionActivity extends Activity {

    protected ImageView heart1;
    protected ImageView heart2;
    protected ImageView heart3;
    protected int frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

        frame = 0;  // the current animation frame
        // the ImageViews that will be animated.
        heart1 = (ImageView) findViewById(R.id.imgHeart1);
        heart2 = (ImageView) findViewById(R.id.imgHeart2);
        heart3 = (ImageView) findViewById(R.id.imgHeart3);

        CountDownTimer transition = new CountDownTimer(4000, 25) {  // 25 frames per second
            @Override
            public void onTick(long millisUntilFinished) {
                animate();
            }   // to animate the hearts beating.

            @Override
            public void onFinish() {
                end();
            }   // leaves this activity and moves to another one.
        };

        transition.start();
    } // onCreate method

    public static int lives;
    public static int score;

    // animates the hearts beating in time with the timer
    public void animate() {
        if (lives == 3) {           // all three hearts will animate
            if (frame == 0) {
                heart1.setImageResource(R.drawable.heart_2);
                heart2.setImageResource(R.drawable.heart_2);
                heart3.setImageResource(R.drawable.heart_2);
                frame++;
            } else if (frame == 1) {
                heart1.setImageResource(R.drawable.heart_3);
                heart2.setImageResource(R.drawable.heart_3);
                heart3.setImageResource(R.drawable.heart_3);
                frame++;
            } else if (frame == 2) {
                heart1.setImageResource(R.drawable.heart_4);
                heart2.setImageResource(R.drawable.heart_4);
                heart3.setImageResource(R.drawable.heart_4);
                frame++;
            } else if (frame == 3) {
                heart1.setImageResource(R.drawable.heart_5);
                heart2.setImageResource(R.drawable.heart_5);
                heart3.setImageResource(R.drawable.heart_5);
                frame++;
            } else if (frame == 4) {
                heart1.setImageResource(R.drawable.heart_6);
                heart2.setImageResource(R.drawable.heart_6);
                heart3.setImageResource(R.drawable.heart_6);
                frame++;
            } else if (frame > 4 && frame < 40) {
                heart1.setImageResource(R.drawable.heart_1);
                heart2.setImageResource(R.drawable.heart_1);
                heart3.setImageResource(R.drawable.heart_1);
                frame++;
            } else {
                frame = 0;
            }
        } else if (lives == 2) {    // two hearts will animate
            if (frame == 0) {
                heart1.setImageResource(R.drawable.heart_2);
                heart2.setImageResource(R.drawable.heart_2);
                heart3.setImageResource(R.drawable.heart_broken);
                frame++;
            } else if (frame == 1) {
                heart1.setImageResource(R.drawable.heart_3);
                heart2.setImageResource(R.drawable.heart_3);
                frame++;
            } else if (frame == 2) {
                heart1.setImageResource(R.drawable.heart_4);
                heart2.setImageResource(R.drawable.heart_4);
                frame++;
            } else if (frame == 3) {
                heart1.setImageResource(R.drawable.heart_5);
                heart2.setImageResource(R.drawable.heart_5);
                frame++;
            } else if (frame == 4) {
                heart1.setImageResource(R.drawable.heart_6);
                heart2.setImageResource(R.drawable.heart_6);
                frame++;
            } else if (frame > 4 && frame < 40) {
                heart1.setImageResource(R.drawable.heart_1);
                heart2.setImageResource(R.drawable.heart_1);
                frame++;
            } else {
                frame = 0;
            }
        } else if (lives == 1) {    // one heart will animate
            if (frame == 0) {
                heart1.setImageResource(R.drawable.heart_2);
                heart2.setImageResource(R.drawable.heart_broken);
                heart3.setImageResource(R.drawable.heart_broken);
                frame++;
            } else if (frame == 1) {
                heart1.setImageResource(R.drawable.heart_3);
                frame++;
            } else if (frame == 2) {
                heart1.setImageResource(R.drawable.heart_4);
                frame++;
            } else if (frame == 3) {
                heart1.setImageResource(R.drawable.heart_5);
                frame++;
            } else if (frame == 4) {
                heart1.setImageResource(R.drawable.heart_6);
                frame++;
            } else if (frame > 4 && frame < 40) {
                heart1.setImageResource(R.drawable.heart_1);
                frame++;
            } else {
                frame = 0;
            }
        } else {                    // none of them will animate
            heart1.setImageResource(R.drawable.heart_broken);
            heart2.setImageResource(R.drawable.heart_broken);
            heart3.setImageResource(R.drawable.heart_broken);
        }
    }


    public void end() {
        Intent myIntent = new Intent(getApplicationContext(), GameOverActivity.class);  // will be changed if they still have at least one life

        if (lives > 0) { // to move onto a game
            // int rand = (int) (Math.random() * (3 - 1 + 1) + 1);  // if all of the games were working this would be on
            int rand = 1;   // rand is not random
            if (rand == 1) {
                myIntent = new Intent(getApplicationContext(), ChiselActivity.class);
            } else if (rand == 2) {
                myIntent = new Intent(getApplicationContext(), DuelActivity.class);
            } else if (rand == 3) {
                myIntent = new Intent(getApplicationContext(), NoseActivity.class);
            }
        }

        // leave this screen and move on to the next
        startActivity(myIntent);
        finish();
    } // end method
} // TransitionActivity class
