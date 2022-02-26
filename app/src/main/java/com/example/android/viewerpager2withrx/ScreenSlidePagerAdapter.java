package com.example.android.viewerpager2withrx;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.android.viewerpager2withrx.DataModel.BaseModel;
import com.example.android.viewerpager2withrx.DataModel.CategoryDto;
import com.example.android.viewerpager2withrx.Fragment.FirstFragment;
import com.example.android.viewerpager2withrx.Fragment.FourthFragment;
import com.example.android.viewerpager2withrx.Fragment.SecondFragment;
import com.example.android.viewerpager2withrx.Fragment.ThirdFragment;
import java.util.ArrayList;
import java.util.List;

public class ScreenSlidePagerAdapter extends FragmentStateAdapter {

    private final CategoryDto dto;

    public ScreenSlidePagerAdapter(CategoryDto dto, @NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.dto = dto;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment frag_new = null;
        if (position == 0) frag_new = firstFragment();
        if (position == 1) frag_new = new SecondFragment();
        if (position == 2) frag_new = new ThirdFragment();
        if (position == 3) frag_new = new FourthFragment();

        return frag_new;
    }

    private FirstFragment firstFragment() {
        FirstFragment firstFragment = new FirstFragment();
        Bundle bundle = new Bundle();
        List<BaseModel> landmarks = dto.landmarks();
        System.out.println(landmarks);
        bundle.putParcelableArrayList("landmarks", new ArrayList<>(landmarks));
        firstFragment.setArguments(bundle);
        return firstFragment;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
