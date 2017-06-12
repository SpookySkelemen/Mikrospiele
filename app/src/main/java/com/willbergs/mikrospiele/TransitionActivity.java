package com.willbergs.mikrospiele;

import android.app.Activity;
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


    public void transition (){
        ImageView heart1 = (ImageView) findViewById(R.id.imgHeart1);
        ImageView heart2 = (ImageView) findViewById(R.id.imgHeart2);
        ImageView heart3 = (ImageView) findViewById(R.id.imgHeart3);

        for (int x = 0 ; x < 4 ; x++){
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

        }

    }
}
