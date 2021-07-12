package com.yalemang.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yalemang.bean.SubscriptionBean;
import com.yalemang.carro.R;

import java.util.List;

/**
 * @author Administrator
 */
public class SubscriptionAdapter extends RecyclerView.Adapter<SubscriptionAdapter.SubscriptionViewHolder> {

    private Context context;
    private List<SubscriptionBean> subscriptionBeanList;

    public SubscriptionAdapter(Context context, List<SubscriptionBean> subscriptionBeanList) {
        this.context = context;
        this.subscriptionBeanList = subscriptionBeanList;
    }


    @Override
    public SubscriptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_subscription_layout, null);
        SubscriptionViewHolder subscriptionViewHolder = new SubscriptionViewHolder(view);
        return subscriptionViewHolder;
    }

    @Override
    public void onBindViewHolder(SubscriptionAdapter.SubscriptionViewHolder holder, int position) {
        Glide.with(context).load(subscriptionBeanList.get(position).getSubscriptionIcon()).into(holder.ivSubscriptionIcon);
        holder.tvSubscriptionItemName.setText(subscriptionBeanList.get(position).getSubscriptionItemName());
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_subscription_layout, null);
        switch (position) {
            case 0:
                view.setBackgroundColor(Color.YELLOW);
                holder.llSubscription.setBackgroundResource(R.drawable.subscription_yellow);
                break;
            case 1:
            case 2:
                view.setBackgroundColor(Color.BLUE);
                holder.llSubscription.setBackgroundResource(R.drawable.subscription_blue);
                break;
            case 3:
                view.setBackgroundColor(Color.RED);
                holder.llSubscription.setBackgroundResource(R.drawable.subscription_red);
                break;
            default:
        }
    }

    @Override
    public int getItemCount() {
        return subscriptionBeanList.size();
    }

    public class SubscriptionViewHolder extends RecyclerView.ViewHolder {

        ImageView ivSubscriptionIcon;
        TextView tvSubscriptionItemName;
        LinearLayout llSubscription;
        public SubscriptionViewHolder(View itemView) {
            super(itemView);

            ivSubscriptionIcon = itemView.findViewById(R.id.iv_subscription_icon);
            tvSubscriptionItemName = itemView.findViewById(R.id.tv_subscription_item_name);
            llSubscription = itemView.findViewById(R.id.ll_subscription);
        }
    }

}
