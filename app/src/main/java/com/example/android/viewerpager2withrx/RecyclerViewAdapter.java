package com.example.android.viewerpager2withrx;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.android.viewerpager2withrx.DataModel.BaseModel;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final Context context;
    private List<BaseModel> itemList;

    public RecyclerViewAdapter(Context context, List<BaseModel> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    public void setItemList(List<BaseModel> listAdd){
        this.itemList = listAdd;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context)
                .asBitmap()
                .load(itemList.get(position).image_url())
                .error(R.drawable.ic_baseline_error_24)
                .into(holder.title_image);
        holder.title.setText(itemList.get(position).name());

        holder.parent_layout.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(itemList.get(position).tripadvisor_url()));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        if (itemList != null) {
            return itemList.size();
        }
        return 0;
    }
}
