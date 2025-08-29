package com.example.giftapp_public;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * MainActivity
 *
 * This is the main screen of the app.
 * It contains a TabLayout with ViewPager2 to navigate between three main sections:
 * - Notes section
 * - Mini game section
 * - Letter section
 */
public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enable immersive mode (fullscreen, hide navigation bar)
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);

        // Initialize TabLayout and ViewPager2
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        // Set adapter for ViewPager2
        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        // Attach TabLayout with ViewPager2 and set tab titles
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Notes"); // First tab - Notes section
                    break;
                case 1:
                    tab.setText("Catch Game"); // Second tab - Mini game section
                    break;
                case 2:
                    tab.setText("Letter"); // Third tab - Letter / Message section
                    break;
            }
        }).attach();
    }

    /**
     * Method to show or hide the TabLayout with animation
     * @param show true to show, false to hide
     */
    public void showTabs(boolean show) {
        if (show) {
            tabLayout.animate().translationY(0).setDuration(200);
        } else {
            tabLayout.animate().translationY(tabLayout.getHeight()).setDuration(200);
        }
    }
}
