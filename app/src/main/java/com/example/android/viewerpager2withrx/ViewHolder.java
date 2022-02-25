package com.example.android.viewerpager2withrx;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder{
    RelativeLayout parent_layout;
    ImageView title_image;
    TextView title;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        parent_layout = itemView.findViewById(R.id.list_item);
        title_image = itemView.findViewById(R.id.title_image);
        title = itemView.findViewById(R.id.title);
    }
}
