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
        if (position == 1) frag_new = secondFragment();
        if (position == 2) frag_new = thirdFragment();
        if (position == 3) frag_new = fourthFragment();

        return frag_new;
    }

    private Fragment firstFragment() {
        FirstFragment firstFragment = new FirstFragment();
        Bundle bundle = new Bundle();
        List<BaseModel> landmarks = dto.landmarks();
        System.out.println(landmarks);
        assert landmarks != null;
        bundle.putParcelableArrayList("landmarks", new ArrayList<>(landmarks));
        firstFragment.setArguments(bundle);
        return firstFragment;
    }

    private Fragment secondFragment() {
        SecondFragment secondFragment = new SecondFragment();
        Bundle bundle2 = new Bundle();
        List<BaseModel> national_parks = dto.national_parks();
        System.out.println(national_parks);
        assert national_parks != null;
        bundle2.putParcelableArrayList("national_parks", new ArrayList<>(national_parks));
        secondFragment.setArguments(bundle2);
        return secondFragment;
    }

    private Fragment thirdFragment() {
        ThirdFragment thirdFragment = new ThirdFragment();
        Bundle bundle3 = new Bundle();
        List<BaseModel> museums = dto.museums();
        System.out.println(museums);
        assert museums != null;
        bundle3.putParcelableArrayList("museums", new ArrayList<>(museums));
        thirdFragment.setArguments(bundle3);
        return thirdFragment;
    }

    private Fragment fourthFragment() {
        FourthFragment fourthFragment = new FourthFragment();
        Bundle bundle4 = new Bundle();
        List<BaseModel> roadtrip = dto.roadtrip();
        System.out.println(roadtrip);
        assert roadtrip != null;
        bundle4.putParcelableArrayList("roadtrip", new ArrayList<>(roadtrip));
        fourthFragment.setArguments(bundle4);
        return fourthFragment;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
