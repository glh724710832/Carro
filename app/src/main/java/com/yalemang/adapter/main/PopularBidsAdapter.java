package com.yalemang.adapter.main;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yalemang.bean.CarBean;
import com.yalemang.carro.R;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PopularBidsAdapter extends RecyclerView.Adapter<PopularBidsAdapter.PopularBidsViewHolder> {

    private Context context;
    private List<CarBean> carBeanList;
    private OnItemClickListener onItemClickListener;
    Set<Integer> onItemClickSet;

    public PopularBidsAdapter(Context context, List<CarBean> carBeanList, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.carBeanList = carBeanList;
        this.onItemClickListener = onItemClickListener;
        onItemClickSet = new HashSet<>();
    }


    @Override
    public PopularBidsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_popular_bids, null);
        PopularBidsViewHolder popularBidsViewHolder = new PopularBidsViewHolder(view);
        return popularBidsViewHolder;
    }

    @Override
    public void onBindViewHolder(PopularBidsAdapter.PopularBidsViewHolder holder, int position) {

        Glide.with(context).load(carBeanList.get(position).getPhotoPath()).into(holder.ivRecyclerViewPopularBids);

        holder.tvRecyclerViewTjPopularBids.setText(carBeanList.get(position).getTj());
        holder.tvRecyclerViewDatePopularBids.setText(carBeanList.get(position).getDate());
        holder.tvRecyclerViewBelongPopularBids.setText(carBeanList.get(position).getBelong());
        holder.ivRecyclerViewPopularBids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemClick(position, holder.itemView);
                        boolean isAdd = onItemClickSet.add(position);
                        if (!isAdd) {
                            holder.itemView.setBackgroundColor(Color.GRAY);
                            onItemClickSet.remove(position);
                        }
                    }
                });
                if (onItemClickSet.contains(position)) {
                    holder.itemView.setBackgroundColor(Color.RED);
                } else {
                    holder.itemView.setBackgroundColor(Color.GRAY);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return carBeanList.size();
    }

    public static class PopularBidsViewHolder extends RecyclerView.ViewHolder {
        ImageView ivRecyclerViewPopularBids;
        TextView tvRecyclerViewTjPopularBids;
        TextView tvRecyclerViewDatePopularBids;
        TextView tvRecyclerViewBelongPopularBids;

        public PopularBidsViewHolder(View itemView) {
            super(itemView);
            ivRecyclerViewPopularBids = itemView.findViewById(R.id.iv_recycler_popular_bids);
            tvRecyclerViewTjPopularBids = itemView.findViewById(R.id.tv_recycler_tj_popular_bids);
            tvRecyclerViewDatePopularBids = itemView.findViewById(R.id.tv_recycler_date_popular_bids);
            tvRecyclerViewBelongPopularBids = itemView.findViewById(R.id.tv_recycler_belong_popular_bids);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position, View view);
    }


}
