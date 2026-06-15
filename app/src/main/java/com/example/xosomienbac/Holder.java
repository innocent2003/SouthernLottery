package com.example.xosomienbac;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class Holder extends RecyclerView.ViewHolder {

    LinearLayout layoutRoot;
    TextView txtTitle, txtResult;

    public Holder(@NonNull View itemView) {
        super(itemView);

        layoutRoot =
                itemView.findViewById(R.id.layoutRoot);

        txtTitle =
                itemView.findViewById(R.id.txtTitle);

        txtResult =
                itemView.findViewById(R.id.txtResult);
    }
}
