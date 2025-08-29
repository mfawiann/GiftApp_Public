package com.example.giftapp_public;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new PhotosFragment(); // Fotoğraflar sekmesi
            case 1:
                return new GameFragment();   // Oyun sekmesi
            case 2:
                return new BirthdayTextFragment(); // Yeni Yaş sekmesi
            default:
                return new PhotosFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3; // toplam sekme sayısı
    }
}
