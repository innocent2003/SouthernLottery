package com.example.xosomienbac.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xosomienbac.R;
import com.example.xosomienbac.XSMBResult;

import java.util.List;

public class XSMBPagerAdapter
        extends RecyclerView.Adapter<XSMBPagerAdapter.ViewHolder> {

    private List<XSMBResult> list;

    public XSMBPagerAdapter(List<XSMBResult> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_xsmb, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder,
            int position) {

        XSMBResult item = list.get(position);

        holder.txtDate.setText(item.getDate());
        holder.txtDB.setText("ĐB: " + item.getGiaiDB());
        holder.txtNhat.setText("Giải nhất: " + item.getGiaiNhat());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtDate, txtDB, txtNhat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtDate = itemView.findViewById(R.id.txtDate);
            txtDB = itemView.findViewById(R.id.txtDB);
            txtNhat = itemView.findViewById(R.id.txtNhat);
        }
    }
}
