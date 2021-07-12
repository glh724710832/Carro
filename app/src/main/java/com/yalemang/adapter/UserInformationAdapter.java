package com.yalemang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yalemang.bean.CarroBean;
import com.yalemang.bean.SubscriptionBean;
import com.yalemang.carro.R;
import com.yalemang.until.SpacesItemDecoration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
public class UserInformationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<CarroBean> carroBeanList;
    private int areaNumber;
    private List<SubscriptionBean> subscriptionOneBeanList;
    private List<SubscriptionBean> subscriptionTwoBeanList;
    private static final int USERINFORMATION = 0;
    private static final int SUBSCRIPTION = 1;

    public UserInformationAdapter(Context context, List<CarroBean> carroBeanList, int areaNumber) {
        this.context = context;
        this.carroBeanList = carroBeanList;
        this.areaNumber = areaNumber;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        if (viewType == USERINFORMATION ){
            View view = LayoutInflater.from(context).inflate(R.layout.item_user_information,null);
            UserInformationHeadViewHolder userInformationHeadViewHolder = new UserInformationHeadViewHolder(view);
            return userInformationHeadViewHolder;
        }else if (viewType == SUBSCRIPTION){
            View view = LayoutInflater.from(context).inflate(R.layout.item_subscription,null);
            SubscriptionViewHolder subscriptionViewHolder = new SubscriptionViewHolder(view);
            return subscriptionViewHolder;
        }else {
            return null;
        }

    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof UserInformationHeadViewHolder) {
            UserInformationHeadViewHolder userInformationHeadViewHolder = (UserInformationHeadViewHolder) holder;
            userInformationHeadViewHolder.tvMakeModel.setText(carroBeanList.get(position).getData().getMake() + "   " + carroBeanList.get(position).getData().getModel());
            userInformationHeadViewHolder.tvCarPlateNumber.setText(carroBeanList.get(position).getData().getCarplate_number());
            userInformationHeadViewHolder.pbUserInformation.setMax(100);
            userInformationHeadViewHolder.pbUserInformation.setProgress(70);
            userInformationHeadViewHolder.tvContentDrivenThisMonth.setText(carroBeanList.get(position).getData().getDriven_this_month() + "  km");
            userInformationHeadViewHolder.tvContentUsageDueThisMonth.setText("$" + carroBeanList.get(position).getData().getUsage_due_this_month() + "  / month");

            SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
            userInformationHeadViewHolder.tvLastUpdated.setText(("last updated :" + ft.format(carroBeanList.get(position).getData().getUpdated_at())));

            userInformationHeadViewHolder.tvBasePriceContent.setText("$" + carroBeanList.get(position).getData().getPrice() + "  /month");
            userInformationHeadViewHolder.tvRoadTaxContent.setText("$" + (carroBeanList.get(position).getData().getRoad_tax()));
            userInformationHeadViewHolder.tvUsageBasedInsuranceContent.setText("$" + (carroBeanList.get(position).getData().getInsurance_excess()) + "  / km");
            userInformationHeadViewHolder.tvNamedDriversContent.setText(carroBeanList.get(position).getData().getDrivers().get(position).getName());
            userInformationHeadViewHolder.tvInsuranceExcessContent.setText("$" + carroBeanList.get(position).getData().getInsurance_excess());
            if (areaNumber == 1) {
                userInformationHeadViewHolder.tvCustomizeYourInsurance.setVisibility(View.INVISIBLE);
            }

        } else if (holder instanceof SubscriptionViewHolder) {

            SubscriptionViewHolder subscriptionViewHolder = (SubscriptionViewHolder) holder;


            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            subscriptionViewHolder.recyclerViewSubscription.setLayoutManager(linearLayoutManager);

            if (areaNumber == 0) {
                subscriptionOneBeanList = new ArrayList<>();
                subscriptionOneBeanList.add(new SubscriptionBean(R.mipmap.telephone_h, "Get Help"));
                subscriptionOneBeanList.add(new SubscriptionBean(R.mipmap.docs, "View Docs"));
                subscriptionOneBeanList.add(new SubscriptionBean(R.mipmap.pay_ments, "Payments"));
                subscriptionOneBeanList.add(new SubscriptionBean(R.mipmap.cancel, "Cancel Sub"));

                subscriptionViewHolder.recyclerViewSubscription.setAdapter(new SubscriptionAdapter(context, subscriptionOneBeanList));
                int space = 15;
                subscriptionViewHolder.recyclerViewSubscription.addItemDecoration(new SpacesItemDecoration(space));
            } else {
                subscriptionTwoBeanList = new ArrayList<>();
                subscriptionTwoBeanList.add(new SubscriptionBean(R.mipmap.telephone_h, "Get Help"));
                subscriptionTwoBeanList.add(new SubscriptionBean(R.mipmap.cancel, "Cancel Sub"));
                subscriptionTwoBeanList.add(new SubscriptionBean(R.mipmap.docs, "Total Fine"));
                subscriptionTwoBeanList.add(new SubscriptionBean(R.mipmap.pay_ments, "Total Amount Of Fines"));


                subscriptionViewHolder.recyclerViewSubscription.setAdapter(new SubscriptionAdapter(context, subscriptionTwoBeanList));
                int space = 15;
                subscriptionViewHolder.recyclerViewSubscription.addItemDecoration(new SpacesItemDecoration(space));
            }
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return USERINFORMATION;
        } else {
            return SUBSCRIPTION;
        }

    }



    @Override
    public int getItemCount() {
        return carroBeanList.size() +1;
    }

    public class UserInformationHeadViewHolder extends RecyclerView.ViewHolder {
        ImageView ivCar;
        TextView tvMakeModel;
        TextView tvCarPlateNumber;
        ProgressBar pbUserInformation;
        TextView tvContentDrivenThisMonth;
        TextView tvTitleDrivenThisMonth;
        TextView tvContentUsageDueThisMonth;
        TextView tvTitleUsageDueThisMonth;
        TextView tvLastUpdated;
        TextView tvBasePriceContent;
        TextView tvRoadTaxContent;
        TextView tvUsageBasedInsuranceContent;
        TextView tvNamedDriversContent;
        TextView tvInsuranceExcessContent;
        TextView tvCustomizeYourInsurance;


        public UserInformationHeadViewHolder(View itemView) {
            super(itemView);
            ivCar = itemView.findViewById(R.id.iv_car);
            tvMakeModel = itemView.findViewById(R.id.tv_make_model);
            tvCarPlateNumber = itemView.findViewById(R.id.tv_carplate_number);
            pbUserInformation = itemView.findViewById(R.id.pb_user_information);
            tvContentDrivenThisMonth = itemView.findViewById(R.id.tv_content_driven_this_month);
            tvTitleDrivenThisMonth = itemView.findViewById(R.id.tv_title_driven_this_month);
            tvContentUsageDueThisMonth = itemView.findViewById(R.id.tv_content_usage_due_this_month);
            tvTitleUsageDueThisMonth = itemView.findViewById(R.id.tv_title_usage_due_this_month);
            tvLastUpdated = itemView.findViewById(R.id.tv_last_updated);
            tvBasePriceContent = itemView.findViewById(R.id.tv_base_price_content);
            tvRoadTaxContent = itemView.findViewById(R.id.tv_road_tax_content);
            tvUsageBasedInsuranceContent = itemView.findViewById(R.id.tv_usage_based_insurance_content);
            tvNamedDriversContent = itemView.findViewById(R.id.tv_named_drivers_content);
            tvInsuranceExcessContent = itemView.findViewById(R.id.tv_insurance_excess_content);
            tvCustomizeYourInsurance = itemView.findViewById(R.id.tv_customize_insurance);
        }
    }

    public class SubscriptionViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerViewSubscription;

        public SubscriptionViewHolder(View itemView) {
            super(itemView);

            recyclerViewSubscription = itemView.findViewById(R.id.recycler_subscription);
        }
    }
}
