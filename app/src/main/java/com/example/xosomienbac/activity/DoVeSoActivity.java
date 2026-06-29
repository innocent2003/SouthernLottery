package com.example.xosomienbac.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.xosomienbac.R;
import com.example.xosomienbac.adapter.DoVeSoPagerAdapter;
import com.example.xosomienbac.adapter.LotteryAdapter;
import com.example.xosomienbac.adapter.LotteryPagerAdapter;
import com.example.xosomienbac.adapter.LotteryResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoVeSoActivity extends AppCompatActivity {
    private RecyclerView rvResult;
    private LotteryAdapter adapter;
    private List<LotteryResult> list;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_do_ve_so);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//        initView();
//        loadData();

        viewPager = findViewById(R.id.viewPager);

        ArrayList<LotteryResult> day1 = loadDataNgay1();
        ArrayList<LotteryResult> day2 = loadDataNgay1();
        ArrayList<LotteryResult> day3 = loadDataNgay1();

        List<ArrayList<LotteryResult>> pages = new ArrayList<>();

        pages.add(day1);
        pages.add(day2);
        pages.add(day3);

        DoVeSoPagerAdapter pagerAdapter =
                new DoVeSoPagerAdapter(this, pages);

        viewPager.setAdapter(pagerAdapter);
        TextView txtDate = findViewById(R.id.txtDate);

        String[] dates = {
                "2026-06-28",
                "2026-06-27",
                "2026-06-26"
        };

        viewPager.registerOnPageChangeCallback(
                new ViewPager2.OnPageChangeCallback() {

                    @Override
                    public void onPageSelected(int position) {

                        txtDate.setText("📅 Kết quả XSMB ngày " + dates[position]);

                    }

                });
    }
    private void initView() {
        rvResult = findViewById(R.id.rvResult);

        rvResult.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        adapter = new LotteryAdapter(this, list);

        rvResult.setAdapter(adapter);
    }

    private void loadData() {

        list.add(new LotteryResult("ĐB",
                Arrays.asList("12452"), 1));

        list.add(new LotteryResult("G1",
                Arrays.asList("17149"), 1));

        list.add(new LotteryResult("G2",
                Arrays.asList("78543", "09227"), 2));

        list.add(new LotteryResult("G3",
                Arrays.asList(
                        "04630", "04283", "69042",
                        "24619", "93901", "21143"), 3));

        list.add(new LotteryResult("G4",
                Arrays.asList(
                        "6660", "5298", "1396", "4449"), 4));

        list.add(new LotteryResult("G5",
                Arrays.asList(
                        "3504", "0054", "1193",
                        "2284", "8711", "5407"), 3));

        list.add(new LotteryResult("G6",
                Arrays.asList(
                        "006", "473", "114"), 3));

        list.add(new LotteryResult("G7",
                Arrays.asList(
                        "85", "41", "55", "36"), 4));

        adapter.notifyDataSetChanged();
    }
    private ArrayList<LotteryResult> loadDataNgay1() {

        ArrayList<LotteryResult> list = new ArrayList<>();

        list.add(new LotteryResult("ĐB",
                Arrays.asList("12452"), 1));

        list.add(new LotteryResult("G1",
                Arrays.asList("17149"), 1));

        list.add(new LotteryResult("G2",
                Arrays.asList("78543", "09227"), 2));

        list.add(new LotteryResult("G3",
                Arrays.asList(
                        "04630", "04283", "69042",
                        "24619", "93901", "21143"), 3));

        list.add(new LotteryResult("G4",
                Arrays.asList(
                        "6660", "5298", "1396", "4449"), 4));

        list.add(new LotteryResult("G5",
                Arrays.asList(
                        "3504", "0054", "1193",
                        "2284", "8711", "5407"), 3));

        list.add(new LotteryResult("G6",
                Arrays.asList(
                        "006", "473", "114"), 3));

        list.add(new LotteryResult("G7",
                Arrays.asList(
                        "85", "41", "55", "36"), 4));

        return list;
    }
}