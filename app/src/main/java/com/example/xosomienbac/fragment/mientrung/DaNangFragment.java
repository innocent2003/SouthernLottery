package com.example.xosomienbac.fragment.mientrung;

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
import com.example.xosomienbac.adapter.XSMBAdapter;
import com.example.xosomienbac.crawler.OnCrawlResultListener;
import com.example.xosomienbac.crawler.XSMBCrawler;
import com.example.xosomienbac.model.PrizeRow;

import java.util.List;

public class DaNangFragment extends Fragment {
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
                view.findViewById(R.id.rvXSMN);

        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext()));

//        List<PrizeRow> data = new ArrayList<>();
//
//        data.add(new PrizeRow("ĐB","47202"));
//        data.add(new PrizeRow("G1","65673"));
//        data.add(new PrizeRow("G2","20007 - 93437"));
//        data.add(new PrizeRow("G3","15277 - 19055"));
//        data.add(new PrizeRow("G4","2797 - 2795"));
//
//        recyclerView.setAdapter(
//                new XSMBAdapter(data));
        loadData();

    }
    private void loadData() {

        XSMBCrawler.crawl(
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
                    public void onError(
                            Exception e) {

                        Log.e(
                                "XSMB",
                                "Crawl error",
                                e
                        );
                    }
                });
    }
}
