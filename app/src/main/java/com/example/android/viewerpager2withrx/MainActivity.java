 package com.example.android.viewerpager2withrx;

import static android.widget.Toast.LENGTH_SHORT;
import static com.example.android.viewerpager2withrx.DtoRepository.getDto;
import static com.uber.autodispose.AutoDispose.autoDisposable;
import static com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider.from;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.android.viewerpager2withrx.DataModel.BaseModel;
import com.example.android.viewerpager2withrx.DataModel.CategoryDto;
import com.example.android.viewerpager2withrx.Fragment.FirstFragment;
import com.example.android.viewerpager2withrx.Fragment.FourthFragment;
import com.example.android.viewerpager2withrx.Fragment.SecondFragment;
import com.example.android.viewerpager2withrx.Fragment.ThirdFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.io.Serializable;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

 public class MainActivity extends AppCompatActivity {
     public static final String UUID = "f60dd98c-466f-44e7-a5dc-f5258dc4f513";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tab);
        ViewPager2 viewPager = findViewById(R.id.viewpager);

        tabLayout.addTab(tabLayout.newTab().setText("Frag 1"), 0);
        tabLayout.addTab(tabLayout.newTab().setText("Frag 2"), 1);
        tabLayout.addTab(tabLayout.newTab().setText("Frag 3"), 2);
        tabLayout.addTab(tabLayout.newTab().setText("Frag 4"), 3);

        FragmentStateAdapter pagerAdapter = new ScreenSlidePagerAdapter(MainActivity.this);
        viewPager.setAdapter(pagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            if (position == 0) tab.setText("Frag 1");
            if (position == 1) tab.setText("Frag 2");
            if (position == 2) tab.setText("Frag 3");
            if (position == 3) tab.setText("Frag 4");
        }).attach();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.setCurrentItem(0);

        bindData();
    }

     private void bindData() {
         getDto(UUID)
                 .subscribeOn(Schedulers.io()) //for IO-bound work of network
                 .observeOn(AndroidSchedulers.mainThread())
                 .as(autoDisposable(from(this)))
                 .subscribe(this::onSuccess,this::onError);
     }

     private void onSuccess(CategoryDto categoryDto) {
         List<BaseModel> landmarks = categoryDto.landmarks();
         List<BaseModel> national_parks = categoryDto.national_parks();
         List<BaseModel> museums = categoryDto.museums();
         List<BaseModel> roadtrip = categoryDto.roadtrip();

//         System.out.println(landmarks);

         FirstFragment Fragment1 = new FirstFragment();
         Bundle bundle = new Bundle();
         bundle.putSerializable("landmarks", (Serializable) landmarks);
         Fragment1.setArguments(bundle);

         SecondFragment Fragment2 = new SecondFragment();
         Bundle bundle2 = new Bundle();
         bundle2.putSerializable("national_parks", (Serializable) national_parks);
         Fragment2.setArguments(bundle2);

         ThirdFragment Fragment3 = new ThirdFragment();
         Bundle bundle3 = new Bundle();
         bundle3.putSerializable("museums", (Serializable) museums);
         Fragment3.setArguments(bundle3);

         FourthFragment Fragment4 = new FourthFragment();
         Bundle bundle4 = new Bundle();
         bundle4.putSerializable("roadtrip", (Serializable) roadtrip);
         Fragment4.setArguments(bundle4);
     }

     private void onError(Throwable throwable) {
         Toast.makeText(getApplication(), throwable.getMessage(), LENGTH_SHORT).show();
     }


 }