package com.example.xosomienbac.fragment.mientrung;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xosomienbac.R;
import com.example.xosomienbac.adapter.XSMBAdapter;
import com.example.xosomienbac.adapter.XSMTAdapter;
import com.example.xosomienbac.crawler.OnCrawlResultListener;
import com.example.xosomienbac.crawler.XSMBCrawler;
import com.example.xosomienbac.crawler.XSMTCrawler;
import com.example.xosomienbac.model.PrizeRow;

import java.util.List;

public class KhanhHoaFragment extends Fragment {
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        return inflater.inflate(
                R.layout.fragment_danang,
                container,
                false);
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState) {

        recyclerView =
                view.findViewById(R.id.rvXSMT);

        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext()));


        loadData();

    }
    private void loadData() {

        String url =
                "https://az24.vn/xsmb-sxmb-xo-so-mien-bac.html";

        XSMBCrawler.crawl(
                url,
                new OnCrawlResultListener() {

                    @Override
                    public void onSuccess(
                            List<PrizeRow> data) {

                        requireActivity()
                                .runOnUiThread(() -> {

                                    recyclerView.setAdapter(
                                            new XSMBAdapter(data)
                                    );
                                });
                    }

                    @Override
                    public void onError(Exception e) {
                        Log.e("XSMB", "Error", e);
                    }
                });
    }
}
