package com.willbergs.mikrospiele;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import static com.willbergs.mikrospiele.R.id.btnChisel;

public class ChiselActivity extends Activity {

    private int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chisel);
    }


    public void chisel (View view){
        ImageButton chiselBtn = (ImageButton) (findViewById(btnChisel));
        if (progress == 0){
            chiselBtn.setImageResource(R.drawable.chisel2);
            progress++;
        }
        else if (progress == 1){
            chiselBtn.setImageResource(R.drawable.chisel3);
            progress++;
        }
        else if (progress == 2){
            chiselBtn.setImageResource(R.drawable.chisel4);
            progress++;
        }
        else if (progress == 3){
            chiselBtn.setImageResource(R.drawable.chisel5);
            progress++;
        }
        else if (progress == 4){
            chiselBtn.setImageResource(R.drawable.chisel6);
            progress++;
        }
        else if (progress == 5){
            chiselBtn.setImageResource(R.drawable.chisel7);
            progress++;
        }
        else if (progress == 6){
            chiselBtn.setImageResource(R.drawable.chisel8);
            progress++;
        }
        else{
            chiselBtn.setImageResource(R.drawable.chisel9);
            progress++;
        }
    }
}
