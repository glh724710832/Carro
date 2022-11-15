package com.yalemang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yalemang.bean.ManageSubscriptionBean;
import com.yalemang.carro.R;

import java.util.List;

/**
 * @author Administrator
 */
public class ManageSubscriptionAdapter extends RecyclerView.Adapter<ManageSubscriptionAdapter.ManageSubscriptionViewHolder> {

    private Context context;
    private List<ManageSubscriptionBean> subscriptionBeanList;
    private int countryCode;

    public ManageSubscriptionAdapter(Context context, List<ManageSubscriptionBean> subscriptionBeanList, int countryCode) {
        this.context = context;
        this.subscriptionBeanList = subscriptionBeanList;
        this.countryCode = countryCode;
    }


    @Override
    public ManageSubscriptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_item_manage_subscription_layout, parent, false);
        ManageSubscriptionViewHolder manageSubscriptionViewHolder = new ManageSubscriptionViewHolder(view);

//        if (countryCode ==0){
//            int parentWidth= parent.getWidth();
//            parent.getHeight();
//            ViewGroup.LayoutParams layoutParams = manageSubscriptionViewHolder.itemView.getLayoutParams();
//            layoutParams.width =  (parentWidth/ 4);
//        }else {
//            int parentWidth= parent.getWidth();
//            parent.getHeight();
//            ViewGroup.LayoutParams layoutParams = manageSubscriptionViewHolder.itemView.getLayoutParams();
//            layoutParams.width =  (parentWidth/ 3);
//        }


        return manageSubscriptionViewHolder;
    }

    @Override
    public void onBindViewHolder(ManageSubscriptionAdapter.ManageSubscriptionViewHolder holder, int position) {
        Glide.with(context).load(subscriptionBeanList.get(position).getManageSubscriptionIcon()).into(holder.ivManageSubscriptionIcon);
        holder.tvManageSubscriptionItemName.setText(subscriptionBeanList.get(position).getManageSubscriptionName());

    }

    @Override
    public int getItemCount() {
        return subscriptionBeanList.size();
    }

    public class ManageSubscriptionViewHolder extends RecyclerView.ViewHolder {

        ImageView ivManageSubscriptionIcon;
        TextView tvManageSubscriptionItemName;
        RelativeLayout llManageSubscription;

        public ManageSubscriptionViewHolder(View itemView) {
            super(itemView);

            ivManageSubscriptionIcon = itemView.findViewById(R.id.iv_manage_subscription_icon);
            tvManageSubscriptionItemName = itemView.findViewById(R.id.tv_manage_subscription_item_name);
            llManageSubscription = itemView.findViewById(R.id.ll_manage_subscription);
        }
    }

}
