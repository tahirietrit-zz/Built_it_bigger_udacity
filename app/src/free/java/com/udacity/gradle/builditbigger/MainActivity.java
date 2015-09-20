package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.tahirietrit.jokedisplaylibrary.JokeTellerDisplayActivity;


public class MainActivity extends ActionBarActivity implements GetJokeCallback {
    private ProgressBar jokeLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdView mAdView = (AdView) findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        jokeLoader = (ProgressBar) findViewById(R.id.jokeLoader);
        findViewById(R.id.jokeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), com.tahirietrit.jokedisplaylibrary.JokeTellerDisplayActivity.class);
//                intent.putExtra(com.tahirietrit.jokedisplaylibrary.JokeTellerDisplayActivity.JOKE_INTENT_KEY, "opala");
//                startActivity(intent);
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