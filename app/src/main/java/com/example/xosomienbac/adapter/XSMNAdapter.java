package com.example.xosomienbac.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xosomienbac.R;
import com.example.xosomienbac.model.PrizeRow;

import java.util.List;

public class XSMNAdapter
        extends RecyclerView.Adapter<XSMNAdapter.ViewHolder> {

    private List<PrizeRow> list;

    public XSMNAdapter(List<PrizeRow> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(
                                R.layout.item_xsmn,
                                parent,
                                false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder,
            int position) {

       PrizeRow item = list.get(position);

        holder.txtPrize.setText(item.getPrize());

        holder.txtResult.setText(
                TextUtils.join(
                        " | ",
                        item.getValues()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder
            extends RecyclerView.ViewHolder {

        TextView txtPrize;
        TextView txtResult;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtPrize =
                    itemView.findViewById(
                            R.id.txtPrize);

            txtResult =
                    itemView.findViewById(
                            R.id.txtResult);
        }
    }
}
