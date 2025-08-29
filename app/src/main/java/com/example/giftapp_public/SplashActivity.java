package com.example.giftapp_public;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

/**
 * SplashActivity: This is the first screen of the app.
 * - Plays a short video (birthday.mp4) stored in res/raw folder.
 * - Allows skipping the video with a button.
 * - Navigates to MainActivity after video ends or when skipped.
 *
 * Public-friendly notes:
 * 1. Video file must be placed in `res/raw/birthday.mp4`.
 * 2. UI elements: VideoView (id: videoView1), Button (id: skipButton)
 * 3. System UI is hidden for immersive full-screen experience.
 */
public class SplashActivity extends AppCompatActivity {

    private VideoView videoView;
    private Button skipButton;
    private boolean skipped = false; // tracks if user pressed skip

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Hide system bars for full-screen (cinema mode)
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );

        videoView = findViewById(R.id.videoView1);
        skipButton = findViewById(R.id.skipButton);

        // Load video from raw resources
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.birthday);
        videoView.setVideoURI(videoUri);

        // When video completes, go to MainActivity
        videoView.setOnCompletionListener(mp -> {
            if (!skipped) {
                goToMain();
            }
        });

        // Skip button pressed -> go to MainActivity immediately
        skipButton.setOnClickListener(v -> {
            skipped = true;
            videoView.stopPlayback();
            goToMain();
        });

        // Start video playback
        videoView.start();
    }

    // Navigate to MainActivity and finish SplashActivity
    private void goToMain() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
