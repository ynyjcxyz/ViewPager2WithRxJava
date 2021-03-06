package com.example.android.viewerpager2withrx;

import static android.widget.Toast.LENGTH_SHORT;
import static com.example.android.viewerpager2withrx.DtoRepository.getDto;
import static com.uber.autodispose.AutoDispose.autoDisposable;
import static com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider.from;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.Toast;

import com.codeboy.pager2_transformers.Pager2_AccordionTransformer;
import com.codeboy.pager2_transformers.Pager2_AntiClockSpinTransformer;
import com.codeboy.pager2_transformers.Pager2_BackDrawTransformer;
import com.example.android.viewerpager2withrx.DataModel.CategoryDto;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private final String[] fragmentTitles = new String[]
            {"Landmarks", "National parks", "Museums", "RoadTrip"};
    public static final String UUID = "f60dd98c-466f-44e7-a5dc-f5258dc4f513";
    TabLayout tabLayout;
    ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewpager);

        viewPager.setPageTransformer(new Pager2_BackDrawTransformer());

        initListener();
        loadData();
    }

    private void initListener() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
    }

    private void loadData() {
        getDto(UUID)
                .subscribeOn(Schedulers.io()) //for IO-bound work of network
                .observeOn(AndroidSchedulers.mainThread())
                .as(autoDisposable(from(this)))
                .subscribe(this::onSuccess, this::onError);
    }

    private void onSuccess(CategoryDto categoryDto) {
        bindViewPagerWithData(categoryDto);
    }

    private void onError(Throwable throwable) {
        Toast.makeText(getApplication(), throwable.getMessage(), LENGTH_SHORT).show();
    }

    private void bindViewPagerWithData(CategoryDto categoryDto) {
        viewPager.setAdapter(new ScreenSlidePagerAdapter(categoryDto, this));
        viewPager.setCurrentItem(0);
        bindTab();
    }

    private void bindTab() {
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) ->
                tab.setText(fragmentTitles[position])).attach();
    }
}