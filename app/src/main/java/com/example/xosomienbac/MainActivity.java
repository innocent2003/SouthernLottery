package com.example.xosomienbac;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.xosomienbac.adapter.LotteryPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity implements OnRegionClickListener {

    ViewPager2 viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        LotteryPagerAdapter adapter =
                new LotteryPagerAdapter(this);

        viewPager.setAdapter(adapter);

        new TabLayoutMediator(
                tabLayout,
                viewPager,
                (tab, position) -> {

                    switch (position){
                        case 0:
                            tab.setText("Trang chủ");
                            break;
                        case 1:
                            tab.setText("Miền Bắc");
                            break;
                        case 2:
                            tab.setText("Miền Trung");
                            break;
                        case 3:
                            tab.setText("Miền Nam");
                            break;
                    }
                }).attach();
    }

    @Override
    public void openMienBac() {
        viewPager.setCurrentItem(1, true);
    }

    @Override
    public void openMienTrung() {
        viewPager.setCurrentItem(2, true);
    }

    @Override
    public void openMienNam() {
        viewPager.setCurrentItem(3, true);
    }
}