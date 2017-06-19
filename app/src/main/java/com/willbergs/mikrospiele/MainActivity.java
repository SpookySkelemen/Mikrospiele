package com.willbergs.mikrospiele;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void toHelpScreen (View view) {
        Intent helpIntent = new Intent(getApplicationContext(), HelpActivity.class);
        startActivity(helpIntent);
        finish();
    }


    public void toBegin (View view) {
        Intent transitionIntent = new Intent(getApplicationContext(), TransitionActivity.class);
        startActivity(transitionIntent);
        finish();
    }
}
