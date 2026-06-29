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
import com.example.xosomienbac.adapter.LotteryAdapter;
import com.example.xosomienbac.adapter.LotteryResult;

import java.util.ArrayList;

public class LotteryFragment extends Fragment {

    private RecyclerView rvResult;

    private LotteryAdapter adapter;

    private ArrayList<LotteryResult> list;

    public LotteryFragment(ArrayList<LotteryResult> list){
        this.list = list;
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lottery,
                container,
                false);

        rvResult = view.findViewById(R.id.rvResult);

        rvResult.setLayoutManager(
                new LinearLayoutManager(getContext()));

        adapter = new LotteryAdapter(getContext(), list);

        rvResult.setAdapter(adapter);

        return view;
    }

}
