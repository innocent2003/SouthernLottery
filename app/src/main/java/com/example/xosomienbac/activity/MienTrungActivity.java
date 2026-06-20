package com.example.xosomienbac.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.xosomienbac.R;
import com.example.xosomienbac.adapter.MienTrungPagerAdapter;

public class MienTrungActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private ImageView btnBack;
    private TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mien_trung);

        viewPager = findViewById(R.id.viewPager);
        btnBack = findViewById(R.id.btnBack);
        txtTitle = findViewById(R.id.txtTitle);

        txtTitle.setText("Miền Trung");

        MienTrungPagerAdapter adapter =
                new MienTrungPagerAdapter(this);

        viewPager.setAdapter(adapter);

        btnBack.setOnClickListener(v -> finish());

        viewPager.registerOnPageChangeCallback(
                new ViewPager2.OnPageChangeCallback() {
                    @Override
                    public void onPageSelected(int position) {

                        switch (position) {
                            case 0:
                                txtTitle.setText("Đà Nẵng");
                                break;

                            case 1:
                                txtTitle.setText("Khánh Hòa");
                                break;

                            case 2:
                                txtTitle.setText("Quảng Nam");
                                break;
                        }
                    }
                });
    }
}