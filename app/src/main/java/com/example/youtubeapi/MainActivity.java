package com.example.youtubeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity {
    public static final String API_KEY_GOOGGLE_CLOUD_PLATFORM_PROJECT = "AIzaSyADXZVlMulcvbO7Y7k-DiBelLbkacuMnl0";

    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    Button btnPlay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        youTubePlayerView = findViewById(R.id.youtube_view);
        btnPlay = findViewById(R.id.btn_play);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("usA25ulAFXc"); //https://www.youtube.com/watch?v=usA25ulAFXc&ab_channel=M%C3%A1tPh%E1%BB%91EDM

                Log.d("123123", "success");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        btnPlay.setOnClickListener(v -> {
            youTubePlayerView.initialize(API_KEY_GOOGGLE_CLOUD_PLATFORM_PROJECT, onInitializedListener);
        });

    }
}
//https://www.youtube.com/watch?v=usA25ulAFXc&ab_channel=M%C3%A1tPh%E1%BB%91EDM   //usA25ulAFXc

//Error when rotate screen -> fix: file manifest
// android:name=".MainActivity"
//android:configChanges="orientation|screenSize"