package com.tahirietrit.jokedisplaylibrary;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

public class JokeTellerDisplayActivity extends FragmentActivity {

    public static final String JOKE_INTENT_KEY = "JOKE_INTENT_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_display_activity);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            TextView jokesView = (TextView) findViewById(R.id.jokesTextview);
            jokesView.setText(extras.getString(JOKE_INTENT_KEY));
        }
    }
}
