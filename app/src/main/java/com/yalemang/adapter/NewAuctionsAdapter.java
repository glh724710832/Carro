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

public class NewAuctionsAdapter extends RecyclerView.Adapter<NewAuctionsAdapter.NewAuctionsViewHolder> {

    private Context context;
    private List<CarBean> carBeanList;
    private OnItemClickListener onItemClickListener;
    Set<Integer> onItemClickSet;;

    public NewAuctionsAdapter(Context context, List<CarBean> carBeanList, OnItemClickListener onItemClickListener){
        this.context = context;
        this.carBeanList = carBeanList;
        this.onItemClickListener = onItemClickListener;
        onItemClickSet = new HashSet<>();
    }


    @Override
    public NewAuctionsViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_new_auctions,null);
        NewAuctionsViewHolder newAuctionsViewHolder = new NewAuctionsViewHolder(view);
        return newAuctionsViewHolder;
    }

    @Override
    public void onBindViewHolder(NewAuctionsAdapter.NewAuctionsViewHolder holder, int position) {

        Glide.with(context).load(carBeanList.get(position).getPhotoPath()).into(holder.iv_recycler_new_auctions);

        holder.tv_recycler_tj_new_auctions.setText(carBeanList.get(position).getTj());
        holder.tv_recycler_date_new_auctions.setText(carBeanList.get(position).getDate());
        holder.tv_recycler_belong_new_auctions.setText(carBeanList.get(position).getBelong());
        holder.iv_recycler_new_auctions.setOnClickListener(new View.OnClickListener() {
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

    public static class NewAuctionsViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_recycler_new_auctions ;
        TextView tv_recycler_tj_new_auctions;
        TextView tv_recycler_date_new_auctions;
        TextView tv_recycler_belong_new_auctions;
        public NewAuctionsViewHolder( View itemView) {
            super(itemView);
            iv_recycler_new_auctions = itemView.findViewById(R.id.iv_recycler_new_auctions);
            tv_recycler_tj_new_auctions = itemView.findViewById(R.id.tv_recycler_tj_new_auctions);
            tv_recycler_date_new_auctions = itemView.findViewById(R.id.tv_recycler_date_new_auctions);
            tv_recycler_belong_new_auctions = itemView.findViewById(R.id.tv_recycler_belong_new_auctions);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position,View view);
    }


}
