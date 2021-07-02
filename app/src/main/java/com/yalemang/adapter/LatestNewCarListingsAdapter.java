package com.yalemang.adapter;

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

public class LatestNewCarListingsAdapter extends RecyclerView.Adapter<LatestNewCarListingsAdapter.LatestNewCarListingsViewHolder> {

    private Context context;
    private List<CarBean> carBeanList;
    private OnItemClickListener onItemClickListener;
    Set<Integer> onItemClickSet;;

    public LatestNewCarListingsAdapter(Context context, List<CarBean> carBeanList, OnItemClickListener onItemClickListener){
        this.context = context;
        this.carBeanList = carBeanList;
        this.onItemClickListener = onItemClickListener;
        onItemClickSet = new HashSet<>();
    }


    @Override
    public LatestNewCarListingsViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_latest_new_car_listings,null);
        LatestNewCarListingsViewHolder latestNewCarListingsViewHolder = new LatestNewCarListingsViewHolder(view);
        return latestNewCarListingsViewHolder;
    }

    @Override
    public void onBindViewHolder(LatestNewCarListingsAdapter.LatestNewCarListingsViewHolder holder, int position) {

        Glide.with(context).load(carBeanList.get(position).getPhotoPath()).into(holder.iv_recycler_latest_new_car_listings);
        holder.tv_recycler_type_latest_new_car_listings.setText(carBeanList.get(position).getType());
        holder.tv_recycler_rp_latest_new_car_listings.setText(carBeanList.get(position).getRp());
        holder.tv_recycler_qty_latest_new_car_listings.setText(carBeanList.get(position).getQty());
        holder.iv_recycler_latest_new_car_listings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemClick(position,holder.itemView);
                        boolean isAdd = onItemClickSet.add(position);
                        if(!isAdd){
                            holder.itemView.setBackgroundColor(Color.GRAY);
                            onItemClickSet.remove(position);
                        }
                    }
                });
                if(onItemClickSet.contains(position)){
                    holder.itemView.setBackgroundColor(Color.RED);
                }else {
                    holder.itemView.setBackgroundColor(Color.GRAY);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return carBeanList.size();
    }

    public static class LatestNewCarListingsViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_recycler_latest_new_car_listings;
        TextView tv_recycler_type_latest_new_car_listings;
        TextView tv_recycler_rp_latest_new_car_listings;
        TextView tv_recycler_qty_latest_new_car_listings;
        public LatestNewCarListingsViewHolder( View itemView) {
            super(itemView);
            iv_recycler_latest_new_car_listings = itemView.findViewById(R.id.iv_recycler_latest_new_car_listings);
            tv_recycler_type_latest_new_car_listings = itemView.findViewById(R.id.tv_recycler_type_latest_new_car_listings);
            tv_recycler_rp_latest_new_car_listings = itemView.findViewById(R.id.tv_recycler_rp_latest_new_car_listings);
            tv_recycler_qty_latest_new_car_listings = itemView.findViewById(R.id.tv_recycler_qty_latest_new_car_listings);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position,View view);
    }
}
