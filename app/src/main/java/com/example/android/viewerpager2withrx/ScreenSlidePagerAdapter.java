package com.example.android.viewerpager2withrx;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.android.viewerpager2withrx.Fragment.FirstFragment;
import com.example.android.viewerpager2withrx.Fragment.FourthFragment;
import com.example.android.viewerpager2withrx.Fragment.SecondFragment;
import com.example.android.viewerpager2withrx.Fragment.ThirdFragment;

public class ScreenSlidePagerAdapter extends FragmentStateAdapter {
    public ScreenSlidePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment frag_new = null;
        if (position == 0) frag_new = new FirstFragment();
        if (position == 1) frag_new = new SecondFragment();
        if (position == 2) frag_new = new ThirdFragment();
        if (position == 3) frag_new = new FourthFragment();

        return frag_new;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
