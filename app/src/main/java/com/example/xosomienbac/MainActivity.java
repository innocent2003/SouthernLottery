package com.example.xosomienbac;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.xosomienbac.adapter.LotteryPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainActivity extends AppCompatActivity implements OnRegionClickListener {
    private static final String TAG = "JSOUP_TEST";

    ViewPager2 viewPager;
    ImageView btnBack;
    TextView txtTitle;
//    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        txtTitle = findViewById(R.id.txtTitle);
//        tabLayout = findViewById(R.id.tabLayout);

        btnBack = findViewById(R.id.btnBack);
        LotteryPagerAdapter adapter =
                new LotteryPagerAdapter(this);

        viewPager.setAdapter(adapter);


        txtTitle.setText("Trang chủ");
        btnBack.setOnClickListener(v -> {
            viewPager.setCurrentItem(0, true);
        });

        viewPager.registerOnPageChangeCallback(
                new ViewPager2.OnPageChangeCallback() {
                    @Override
                    public void onPageSelected(int position) {
                        switch (position) {
                            case 0:
                                btnBack.setVisibility(View.INVISIBLE);
                                txtTitle.setText("Trang chủ");
                                break;
                            case 1:
                                btnBack.setVisibility(View.VISIBLE);
                                txtTitle.setText("Miền Bắc");
                                break;
                            case 2:
                                btnBack.setVisibility(View.VISIBLE);
                                txtTitle.setText("Miền Trung");
                                break;
                            case 3:
                                btnBack.setVisibility(View.VISIBLE);
                                txtTitle.setText("Miền Nam");
                                break;
                        }
                    }
                });
        crawlData();
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

    private void crawlData() {

        new Thread(() -> {

            try {

                String url = "https://az24.vn/xsmb-sxmb-xo-so-mien-bac.html";

                Document doc = Jsoup.connect(url)
                        .userAgent("Mozilla/5.0")
                        .timeout(10000)
                        .get();

//                Log.d(TAG, "Title = " + doc.title());

                Element table = doc.selectFirst(
                        "table.kqmb.colgiai.extendable"
                );

                if (table == null) {

                    Log.e(TAG, "Khong tim thay bang");
                    return;
                }

                Elements rows = table.select("tr");

                for (Element row : rows) {

                    Element txtGiai =
                            row.selectFirst("td.txt-giai");

                    Element vGiai =
                            row.selectFirst("td.v-giai");

                    if (txtGiai == null || vGiai == null) {
                        continue;
                    }

                    String tenGiai = txtGiai.text();

                    Elements spans =
                            vGiai.select("span");

                    StringBuilder ketQua =
                            new StringBuilder();

                    for (Element span : spans) {

                        ketQua.append(span.text())
                                .append(" ");
                    }

                    Log.d(
                            TAG,
                            "Giai = "
                                    + tenGiai
                                    + " | KetQua = "
                                    + ketQua.toString().trim()
                    );
                }

            } catch (Exception e) {

                Log.e(TAG,
                        "Loi crawl: "
                                + e.getMessage(),
                        e);
            }

        }).start();
    }
}