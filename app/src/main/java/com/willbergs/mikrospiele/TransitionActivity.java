package com.willbergs.mikrospiele;

import android.app.Activity;
import android.os.Bundle;

public class TransitionActivity extends Activity {

    public static int lives;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
    }
}
