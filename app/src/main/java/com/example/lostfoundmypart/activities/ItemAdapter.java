package com.example.lostfoundmypart.activities;

import com.example.lostfoundmypart.R;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private Context context;
    private List<Item> itemList;

    public ItemAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = itemList.get(position);

        holder.tvItemName.setText(item.getItemName());
        holder.tvCategory.setText(item.getCategory());
        holder.tvLocation.setText(item.getLocation());
        holder.tvDate.setText(item.getDate());
        holder.tvStatus.setText(item.getStatus());

        if (item.getStatus() != null) {
            holder.tvStatus.setText(item.getStatus());
            if (item.getStatus().equalsIgnoreCase("Lost")) {
                holder.tvStatus.setTextColor(Color.parseColor("#DC2626"));
                holder.tvStatus.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#FEE2E2")));
            } else if (item.getStatus().equalsIgnoreCase("Found")) {
                holder.tvStatus.setTextColor(Color.parseColor("#16A34A"));
                holder.tvStatus.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#D1FAE5")));
            } else {
                holder.tvStatus.setTextColor(Color.parseColor("#9333EA"));
                holder.tvStatus.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#F3E8FF")));
            }
        }

        Glide.with(context)
                .load(item.getImageUrl())
                .placeholder(R.drawable.placeholder_item_img)
                .fallback(R.drawable.placeholder_item_img)
                .error(R.drawable.placeholder_item_img)
                .into(holder.ivItemImage);

        holder.btnViewDetails.setOnClickListener(v -> {
            Intent intent = new Intent(context, ItemDetailsActivity.class);
            intent.putExtra("ITEM_DATA", item);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return itemList != null ? itemList.size() : 0;
    }

    public void updateList(List<Item> newList) {
        itemList = newList;
        notifyDataSetChanged();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView ivItemImage;
        TextView tvItemName, tvCategory, tvLocation, tvDate, tvStatus;
        Button btnViewDetails;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ivItemImage = itemView.findViewById(R.id.ivItemImage);
            tvItemName = itemView.findViewById(R.id.tvItemName);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            btnViewDetails = itemView.findViewById(R.id.btnViewDetails);
        }
    }
}
