package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.tahirietrit.jokedisplaylibrary.JokeTellerDisplayActivity;


public class MainActivity extends ActionBarActivity implements GetJokeCallback {
    private ProgressBar jokeLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jokeLoader = (ProgressBar) findViewById(R.id.jokeLoader);
        findViewById(R.id.jokeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GetJokeTask(MainActivity.this).execute();
                jokeLoader.setVisibility(View.VISIBLE);
            }
        });
    }
    @Override
    public void onJokeRetrived(String joke) {

        Intent intent = new Intent(MainActivity.this, JokeTellerDisplayActivity.class);
        intent.putExtra(JokeTellerDisplayActivity.JOKE_INTENT_KEY, joke);
        startActivity(intent);
    }
}
