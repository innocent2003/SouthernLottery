package com.example.xosomienbac.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xosomienbac.R;
import com.example.xosomienbac.model.RowData;

import java.util.List;

public class MultiProvinceAdapter
        extends RecyclerView.Adapter<
        MultiProvinceAdapter.ViewHolder> {

    private final List<RowData> list;

    public MultiProvinceAdapter(
            List<RowData> list) {

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
                                R.layout.item_row,
                                parent,
                                false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder,
            int position) {

        RowData row =
                list.get(position);

        holder.rowContainer.removeAllViews();

        for (String text :
                row.getCells()) {

            TextView tv =
                    (TextView) LayoutInflater
                            .from(holder.itemView.getContext())
                            .inflate(
                                    R.layout.item_cell,
                                    holder.rowContainer,
                                    false);

            tv.setText(text);

            holder.rowContainer.addView(tv);
        }
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    static class ViewHolder
            extends RecyclerView.ViewHolder {

        LinearLayout rowContainer;

        public ViewHolder(
                @NonNull View itemView) {

            super(itemView);

            rowContainer =
                    itemView.findViewById(
                            R.id.rowContainer);
        }
    }
}
