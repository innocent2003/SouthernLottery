package com.example.xosomienbac.adapter;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xosomienbac.R;
import com.example.xosomienbac.model.PrizeRow;

import java.util.List;

public class XSMBAdapter
        extends RecyclerView.Adapter<XSMBAdapter.Holder>{

    List<PrizeRow> list;

    public XSMBAdapter(List<PrizeRow> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(
                        R.layout.item_prize,
                        parent,
                        false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull Holder holder,
            int position) {

        PrizeRow row = list.get(position);

        holder.txtPrize.setText(row.getPrize());

        holder.gridValues.removeAllViews();

        int columnCount =
                getColumnCount(
                        row.getValues().size());

        holder.gridValues.setColumnCount(
                columnCount);

        for (String value : row.getValues()) {

            TextView tv =
                    new TextView(
                            holder.itemView.getContext());

            tv.setText(value);

            tv.setGravity(Gravity.CENTER);

            tv.setTextSize(18);

            GridLayout.LayoutParams params =
                    new GridLayout.LayoutParams();

            params.width = 0;

            params.columnSpec =
                    GridLayout.spec(
                            GridLayout.UNDEFINED,
                            1f);

            tv.setLayoutParams(params);

            holder.gridValues.addView(tv);
        }
    }
    private int getColumnCount(int size) {

        if (size <= 1) return 1;

        if (size == 2) return 2;

        if (size == 3) return 3;

        if (size == 4) return 4;

        if (size == 6) return 3;

        return Math.min(size, 4);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class Holder extends RecyclerView.ViewHolder{

        TextView txtPrize,txtValue;
        GridLayout gridValues;

        public Holder(@NonNull View itemView) {
            super(itemView);

            txtPrize =
                    itemView.findViewById(R.id.txtPrize);

//            txtValue =
//                    itemView.findViewById(R.id.txtValue);
            gridValues =
                    itemView.findViewById(R.id.gridValues);
        }
    }
}
