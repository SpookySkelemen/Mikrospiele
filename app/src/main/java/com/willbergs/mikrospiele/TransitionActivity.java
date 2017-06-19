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
    protected int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

        progress = 0;
        heart1 = (ImageView) findViewById(R.id.imgHeart1);
        heart2 = (ImageView) findViewById(R.id.imgHeart2);
        heart3 = (ImageView) findViewById(R.id.imgHeart3);

        CountDownTimer transition = new CountDownTimer(3000, 25) {
            @Override
            public void onTick(long millisUntilFinished) {
                animate();
            }

            @Override
            public void onFinish() {
                end();
            }
        };

        transition.start();
    } // onCreate method

    public static int lives;


    public void animate (){
        if (lives == 3){
            if (progress == 0){
                heart1.setImageResource(R.drawable.heart_2);
                heart2.setImageResource(R.drawable.heart_2);
                heart3.setImageResource(R.drawable.heart_2);
                progress++;
            } else if (progress == 1) {
                heart1.setImageResource(R.drawable.heart_3);
                heart2.setImageResource(R.drawable.heart_3);
                heart3.setImageResource(R.drawable.heart_3);
                progress++;
            } else if (progress == 2) {
                heart1.setImageResource(R.drawable.heart_4);
                heart2.setImageResource(R.drawable.heart_4);
                heart3.setImageResource(R.drawable.heart_4);
                progress++;
            } else if (progress == 3) {
                heart1.setImageResource(R.drawable.heart_5);
                heart2.setImageResource(R.drawable.heart_5);
                heart3.setImageResource(R.drawable.heart_5);
                progress++;
            } else if (progress == 4) {
                heart1.setImageResource(R.drawable.heart_6);
                heart2.setImageResource(R.drawable.heart_6);
                heart3.setImageResource(R.drawable.heart_6);
                progress++;
            } else if (progress > 4 && progress < 40){
                heart1.setImageResource(R.drawable.heart_1);
                heart2.setImageResource(R.drawable.heart_1);
                heart3.setImageResource(R.drawable.heart_1);
                progress++;
            } else {
                progress = 0;
            }
        } else if (lives == 2){
            if (progress == 0){
                heart1.setImageResource(R.drawable.heart_2);
                heart2.setImageResource(R.drawable.heart_2);
                heart3.setImageResource(R.drawable.heart_broken);
                progress++;
            } else if (progress == 1) {
                heart1.setImageResource(R.drawable.heart_3);
                heart2.setImageResource(R.drawable.heart_3);
                progress++;
            } else if (progress == 2) {
                heart1.setImageResource(R.drawable.heart_4);
                heart2.setImageResource(R.drawable.heart_4);
                progress++;
            } else if (progress == 3) {
                heart1.setImageResource(R.drawable.heart_5);
                heart2.setImageResource(R.drawable.heart_5);
                progress++;
            } else if (progress == 4) {
                heart1.setImageResource(R.drawable.heart_6);
                heart2.setImageResource(R.drawable.heart_6);
                progress++;
            } else if (progress > 4 && progress < 40){
                heart1.setImageResource(R.drawable.heart_1);
                heart2.setImageResource(R.drawable.heart_1);
                progress++;
            } else {
                progress = 0;
            }
        } else if (lives == 1) {
            if (progress == 0){
                heart1.setImageResource(R.drawable.heart_2);
                heart2.setImageResource(R.drawable.heart_broken);
                heart3.setImageResource(R.drawable.heart_broken);
                progress++;
            } else if (progress == 1) {
                heart1.setImageResource(R.drawable.heart_3);
                progress++;
            } else if (progress == 2) {
                heart1.setImageResource(R.drawable.heart_4);
                progress++;
            } else if (progress == 3) {
                heart1.setImageResource(R.drawable.heart_5);
                progress++;
            } else if (progress == 4) {
                heart1.setImageResource(R.drawable.heart_6);
                progress++;
            } else if (progress > 4 && progress < 40){
                heart1.setImageResource(R.drawable.heart_1);
                progress++;
            } else {
                progress = 0;
            }
        } else {
            heart1.setImageResource(R.drawable.heart_broken);
            heart2.setImageResource(R.drawable.heart_broken);
            heart3.setImageResource(R.drawable.heart_broken);
        }
    }


    public void end () {
        Intent myIntent = new Intent(getApplicationContext(), GameOverActivity.class);  // will be changed if they still have at least one life

        if (lives > 0){ // to move onto a game
            int rand = (int) (Math.random () * (5 - 1 + 1) + 1);
            if (rand == 1) {
                myIntent = new Intent (getApplicationContext(), ChiselActivity.class);
            } else if (rand == 2) {
                myIntent = new Intent (getApplicationContext(), ChiselActivity.class);
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
