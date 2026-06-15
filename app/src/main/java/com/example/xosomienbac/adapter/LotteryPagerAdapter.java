package com.example.xosomienbac.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.xosomienbac.fragment.HomeFragment;
import com.example.xosomienbac.fragment.XSMBFragment;
import com.example.xosomienbac.fragment.XSMNFragment;
import com.example.xosomienbac.fragment.XSMTFragment;

public class LotteryPagerAdapter extends FragmentStateAdapter {

    public LotteryPagerAdapter(@NonNull FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new HomeFragment();

            case 1:
                return new XSMBFragment();

            case 2:
                return new XSMTFragment();

            default:
                return new XSMNFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
