package com.example.xosomienbac.fragment;
import android.os.Bundle;
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
import com.example.xosomienbac.model.PrizeRow;

import java.util.ArrayList;
import java.util.List;
public class XSMTFragment extends Fragment {

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

        List<PrizeRow> data = new ArrayList<>();

//        data.add(new PrizeRow("G8",
//                "39 | 70 | 33"));
//
//        data.add(new PrizeRow("G7",
//                "444 | 807 | 903"));
//
//        data.add(new PrizeRow("G6",
//                "5027 | 8890 | 9413"));

        recyclerView.setAdapter(
                new XSMBAdapter(data));
    }
}
