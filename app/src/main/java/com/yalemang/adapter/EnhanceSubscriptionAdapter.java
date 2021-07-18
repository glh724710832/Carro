package com.yalemang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yalemang.bean.CarroBean;
import com.yalemang.bean.CustomizeInsuranceBean;
import com.yalemang.bean.EnhanceSubscriptionBean;
import com.yalemang.carro.R;

import java.util.List;

/**
 * @author Administrator
 */
public class EnhanceSubscriptionAdapter extends RecyclerView.Adapter<EnhanceSubscriptionAdapter.EnhanceSubscriptionViewHolder> {

    private Context context;
    private List<EnhanceSubscriptionBean> enhanceSubscriptionBeanList;
    private int countryCode;


    public EnhanceSubscriptionAdapter(Context context, List<EnhanceSubscriptionBean> enhanceSubscriptionBeanList, int countryCode) {
        this.context = context;
        this.enhanceSubscriptionBeanList = enhanceSubscriptionBeanList;
        this.countryCode = countryCode;
    }

    @Override
    public EnhanceSubscriptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_enhance_subscription, null);
        EnhanceSubscriptionViewHolder enhanceSubscriptionViewHolder = new EnhanceSubscriptionViewHolder(view);
        return enhanceSubscriptionViewHolder;
    }

    @Override
    public void onBindViewHolder(EnhanceSubscriptionAdapter.EnhanceSubscriptionViewHolder holder, int position) {
        Glide.with(context).load(enhanceSubscriptionBeanList.get(position).getEnhanceSubscriptionIcon()).into(holder.ivEnhanceSubscription);
        holder.tvEnhanceSubscriptionTitle.setText(enhanceSubscriptionBeanList.get(position).getEnhanceSubscriptionTitle());
        holder.tvEnhanceSubscriptionContent.setText(enhanceSubscriptionBeanList.get(position).getEnhanceSubscriptionContent());

    }

    @Override
    public int getItemCount() {
        return enhanceSubscriptionBeanList.size();
    }

    public class EnhanceSubscriptionViewHolder extends RecyclerView.ViewHolder {

        ImageView ivEnhanceSubscription;
        TextView tvEnhanceSubscriptionTitle;
        TextView tvEnhanceSubscriptionContent;

        public EnhanceSubscriptionViewHolder(@NonNull View itemView) {
            super(itemView);
            ivEnhanceSubscription = itemView.findViewById(R.id.iv_enhance_subscription);
            tvEnhanceSubscriptionTitle = itemView.findViewById(R.id.tv_enhance_subscription_title);
            tvEnhanceSubscriptionContent = itemView.findViewById(R.id.tv_enhance_subscription_content);
        }
    }
}
