package com.example.xosomienbac.fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xosomienbac.R;
import com.example.xosomienbac.adapter.MultiProvinceAdapter;
import com.example.xosomienbac.adapter.XSMBAdapter;
import com.example.xosomienbac.crawler.OnCrawlResultListener;
import com.example.xosomienbac.crawler.OnMultiCrawlResultListener;
import com.example.xosomienbac.crawler.XSMBCrawler;
import com.example.xosomienbac.model.PrizeRow;
import com.example.xosomienbac.model.RowData;

import java.util.ArrayList;
import java.util.List;

public class XSMNFragment extends Fragment {

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        return inflater.inflate(
                R.layout.fragment_xsmb,
                container,
                false);
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState) {

        recyclerView =
                view.findViewById(R.id.rvXSMB);

        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext()));


        loadData();
    }
    private void loadData() {

        String url =
                "https://az24.vn/xsmn-sxmn-ket-qua-xo-so-mien-nam.html";

        XSMBCrawler.crawlMultiProvince(
                url,
                new OnMultiCrawlResultListener() {

                    @Override
                    public void onSuccess(
                            List<RowData> data) {

                        requireActivity()
                                .runOnUiThread(() -> {

                                    recyclerView.setAdapter(
                                            new MultiProvinceAdapter(
                                                    data
                                            )
                                    );
                                });
                    }

                    @Override
                    public void onError(
                            Exception e) {

                        Log.e(
                                "XSMN",
                                "Error",
                                e
                        );
                    }
                });
    }
}
