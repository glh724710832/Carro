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

public class PopularCategorlesAdapter extends RecyclerView.Adapter<PopularCategorlesAdapter.PopularCategorlesViewHolder> {

    private Context context;
    private List<CarBean> carBeanList;
    private OnItemClickListener onItemClickListener;
    Set<Integer> onItemClickSet;

    public PopularCategorlesAdapter(Context context, List<CarBean> carBeanList, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.carBeanList = carBeanList;
        this.onItemClickListener = onItemClickListener;
        onItemClickSet = new HashSet<>();
    }


    @Override
    public PopularCategorlesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_popular_categorles, null);
        PopularCategorlesViewHolder popularCategorlesViewHolder = new PopularCategorlesViewHolder(view);
        return popularCategorlesViewHolder;
    }

    @Override
    public void onBindViewHolder(PopularCategorlesAdapter.PopularCategorlesViewHolder holder, int position) {

        Glide.with(context).load(carBeanList.get(position).getPhotoPath()).into(holder.ivRecyclerViewPopularCategorles);
        holder.tvRecyclerViewModelPopularCategorles.setText(carBeanList.get(position).getModel());
        holder.tvRecyclerViewCarsPopularCategorles.setText(carBeanList.get(position).getViewCars());
        holder.ivRecyclerViewPopularCategorles.setOnClickListener(new View.OnClickListener() {
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

    public static class PopularCategorlesViewHolder extends RecyclerView.ViewHolder {
        ImageView ivRecyclerViewPopularCategorles;
        TextView tvRecyclerViewModelPopularCategorles;
        TextView tvRecyclerViewCarsPopularCategorles;

        public PopularCategorlesViewHolder(View itemView) {
            super(itemView);
            ivRecyclerViewPopularCategorles = itemView.findViewById(R.id.iv_recycler_popular_categorles);
            tvRecyclerViewModelPopularCategorles = itemView.findViewById(R.id.tv_recycler_model_popular_categorles);
            tvRecyclerViewCarsPopularCategorles = itemView.findViewById(R.id.tv_recycler_cars_popular_categorles);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position, View view);
    }
}
