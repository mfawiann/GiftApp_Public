package com.example.giftapp_public;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Random;

/**
 * GameFragment
 *
 * A simple "catch the image" mini game.
 * Uses placeholder icons (ic_launcher) instead of personal images.
 */
public class GameFragment extends Fragment {

    private TextView tvScore, tvTimer;
    private ImageView[] cells;
    private LinearLayout difficultyLayout;

    // Placeholder images (use same icon for demo)
    private final int[] gameImages = {
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher
    };

    private Handler handler;
    private Runnable loop;
    private CountDownTimer timer;

    private int score = 0;
    private long delay = 800;
    private boolean running = false;
    private final Random rnd = new Random();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_game, container, false);

        tvScore          = v.findViewById(R.id.tvScore);
        tvTimer          = v.findViewById(R.id.tvTimer);
        difficultyLayout = v.findViewById(R.id.difficultyLayout);

        cells = new ImageView[]{
                v.findViewById(R.id.cell1), v.findViewById(R.id.cell2), v.findViewById(R.id.cell3),
                v.findViewById(R.id.cell4), v.findViewById(R.id.cell5), v.findViewById(R.id.cell6),
                v.findViewById(R.id.cell7), v.findViewById(R.id.cell8), v.findViewById(R.id.cell9)
        };

        for (ImageView img : cells) {
            img.setOnClickListener(c -> {
                if (running && img.getVisibility() == View.VISIBLE) {
                    score++;
                    tvScore.setText("Score: " + score);
                    img.setVisibility(View.INVISIBLE);
                }
            });
        }

        v.findViewById(R.id.btnEasy).setOnClickListener(b -> startGame(1200));
        v.findViewById(R.id.btnMedium).setOnClickListener(b -> startGame(800));
        v.findViewById(R.id.btnHard).setOnClickListener(b -> startGame(500));

        return v;
    }

    private void startGame(long msDelay) {
        delay = msDelay;
        score = 0;
        tvScore.setText("Score: 0");
        difficultyLayout.setVisibility(View.GONE);
        running = true;

        startTimer();
        startLoop();
    }

    private void startTimer() {
        timer = new CountDownTimer(20_000, 1000) {
            @Override public void onTick(long l)  { tvTimer.setText("Time: " + l / 1000); }
            @Override public void onFinish()      { tvTimer.setText("Time: 0"); stopGame(); }
        }.start();
    }

    private void startLoop() {
        handler = new Handler();
        loop = new Runnable() {
            @Override public void run() {
                if (!running) return;
                for (ImageView c : cells) c.setVisibility(View.INVISIBLE);

                int cellIx = rnd.nextInt(cells.length);
                int imgIx  = rnd.nextInt(gameImages.length);
                cells[cellIx].setImageResource(gameImages[imgIx]);
                cells[cellIx].setVisibility(View.VISIBLE);

                handler.postDelayed(this, delay);
            }
        };
        handler.post(loop);
    }

    private void stopGame() {
        running = false;
        if (handler != null && loop != null) handler.removeCallbacks(loop);
        if (timer   != null) timer.cancel();

        for (ImageView c : cells) c.setVisibility(View.INVISIBLE);

        Toast.makeText(requireContext(), "Game over! Your score: " + score, Toast.LENGTH_LONG).show();
        difficultyLayout.setVisibility(View.VISIBLE);
    }

    @Override public void onPause() {
        super.onPause();
        stopGame();
    }
}

