package com.example.xosomienbac.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.xosomienbac.R;
import com.example.xosomienbac.adapter.LotteryPagerAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements OnRegionClickListener {
    private static final String TAG = "JSOUP_TEST";

    ViewPager2 viewPager;
    ImageView btnBack;
    TextView txtTitle;
    String thu = getTodayThu();
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
                                viewPager.setUserInputEnabled(false);
                                break;
                            case 1:
                                btnBack.setVisibility(View.VISIBLE);
                                txtTitle.setText("Miền Bắc");
                                viewPager.setUserInputEnabled(true);
                                break;
                            case 2:
                                btnBack.setVisibility(View.VISIBLE);
                                txtTitle.setText("Miền Trung");
                                viewPager.setUserInputEnabled(true);
                                break;
                            case 3:
                                btnBack.setVisibility(View.VISIBLE);
                                txtTitle.setText("Miền Nam");
                                viewPager.setUserInputEnabled(true);
                                break;
                        }
                    }
                });
        crawlData(thu);
        SimpleDateFormat sdf =
                new SimpleDateFormat(
                        "EEEE, dd/MM/yyyy",
                        new Locale("vi", "VN"));

        String today = sdf.format(new Date());

        Log.d("DATE_TEST", today);

    }


    @Override
    public void openMienBac() {
        viewPager.setCurrentItem(1, true);
    }

//    @Override
//    public void openMienTrung() {
//        viewPager.setCurrentItem(2, true);
//    }
//
//    @Override
//    public void openMienNam() {
//        viewPager.setCurrentItem(3, true);
//    }

    private String getTodayThu() {

        Calendar calendar = Calendar.getInstance();

        int dayOfWeek =
                calendar.get(Calendar.DAY_OF_WEEK);

        switch (dayOfWeek) {

            case Calendar.MONDAY:
                return "2";

            case Calendar.TUESDAY:
                return "3";

            case Calendar.WEDNESDAY:
                return "4";

            case Calendar.THURSDAY:
                return "5";

            case Calendar.FRIDAY:
                return "6";

            case Calendar.SATURDAY:
                return "7";

            default:
                return "chu-nhat";
        }
    }
    private void crawlData(String thu) {

        new Thread(() -> {

            try {

                String url = "https://az24.vn/xsmb-"+thu+".html";

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