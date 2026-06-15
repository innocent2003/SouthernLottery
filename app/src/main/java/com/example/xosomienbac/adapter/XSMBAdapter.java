package com.example.xosomienbac.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        holder.txtValue.setText(row.getValue());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class Holder extends RecyclerView.ViewHolder{

        TextView txtPrize,txtValue;

        public Holder(@NonNull View itemView) {
            super(itemView);

            txtPrize =
                    itemView.findViewById(R.id.txtPrize);

            txtValue =
                    itemView.findViewById(R.id.txtValue);
        }
    }
}
