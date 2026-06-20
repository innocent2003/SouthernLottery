package com.example.xosomienbac.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.xosomienbac.fragment.mientrung.DaNangFragment;
import com.example.xosomienbac.fragment.mientrung.KhanhHoaFragment;
import com.example.xosomienbac.fragment.mientrung.QuangNamFragment;

public class MienTrungPagerAdapter
        extends FragmentStateAdapter {

    public MienTrungPagerAdapter(
            @NonNull FragmentActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {

            case 0:
                return new DaNangFragment();

            case 1:
                return new KhanhHoaFragment();

            case 2:
                return new QuangNamFragment();

            default:
                return new DaNangFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}