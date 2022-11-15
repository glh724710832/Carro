package com.yalemang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yalemang.bean.CarroBean;
import com.yalemang.bean.CustomizeInsuranceBean;
import com.yalemang.bean.EnhanceSubscriptionBean;
import com.yalemang.bean.ManageSubscriptionBean;
import com.yalemang.carro.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class UserInformationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private final List<CarroBean> carroBeanList;
    private List<CustomizeInsuranceBean> customizeInsuranceBeanList;
    private List<ManageSubscriptionBean> manageSubscriptionBeanList;
    private List<EnhanceSubscriptionBean> enhanceSubscriptionBeanList;
    private int countryCode;
    

    private List<ManageSubscriptionBean> subscriptionTwoBeanList;

    private static final int CARINFORMATION = 0;
    private static final int CUSTOMIZE_INSURANCE = 1;
    private static final int MANAGE_SUBSCRIPTION = 2;
    private static final int ENHANCE_SUBSCRIPTION = 3;

    public UserInformationAdapter(Context context, List<CarroBean> carroBeanList,List<CustomizeInsuranceBean> customizeInsuranceBeanList,List<ManageSubscriptionBean> manageSubscriptionBeanList,List<EnhanceSubscriptionBean> enhanceSubscriptionBeanList, int countryCode) {
        this.context = context;
        this.carroBeanList = carroBeanList;
        this.customizeInsuranceBeanList = customizeInsuranceBeanList;
        this.manageSubscriptionBeanList = manageSubscriptionBeanList;
        this.enhanceSubscriptionBeanList = enhanceSubscriptionBeanList;
        this.countryCode = countryCode;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == CARINFORMATION) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_carr_information, parent,false);
            TypeCarInformationViewHolder typeCarInformationViewHolder = new TypeCarInformationViewHolder(view);
            return typeCarInformationViewHolder;
        } else if (viewType ==CUSTOMIZE_INSURANCE){
            View view = LayoutInflater.from(context).inflate(R.layout.item_customize_insurance_information, parent,false);
            TypeCustomizeInsuranceViewHolder typeCustomizeInsuranceViewHolder = new TypeCustomizeInsuranceViewHolder(view);

            return typeCustomizeInsuranceViewHolder;
        } else if (viewType == MANAGE_SUBSCRIPTION) {
            //此处为item_manage_subscription
            View view = LayoutInflater.from(context).inflate(R.layout.item_manage_subscription, parent,false);
            TypeManageSubscriptionViewHolder typeManageSubscriptionViewHolder = new TypeManageSubscriptionViewHolder(view);
            return typeManageSubscriptionViewHolder;
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_enhance_subscription, parent,false);
            TypeEnhanceSubscriptionViewHolder typeEnhanceSubscriptionViewHolder = new TypeEnhanceSubscriptionViewHolder(view);
            return typeEnhanceSubscriptionViewHolder;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof TypeCarInformationViewHolder) {
            TypeCarInformationViewHolder typeCarInformationViewHolder = (TypeCarInformationViewHolder) holder;

            typeCarInformationViewHolder.tvMakeModel.setText(carroBeanList.get(position).getData().getMake() + "   (" + carroBeanList.get(position).getData().getModel()+")");
            typeCarInformationViewHolder.tvCarPlateNumber.setText(carroBeanList.get(position).getData().getCarplate_number());
            typeCarInformationViewHolder.pbUserInformation.setMax(100);
            typeCarInformationViewHolder.pbUserInformation.setProgress(70);
            typeCarInformationViewHolder.tvContentDrivenThisMonth.setText(carroBeanList.get(position).getData().getDriven_this_month() + "  km");
            typeCarInformationViewHolder.tvContentUsageDueThisMonth.setText("$  " + carroBeanList.get(position).getData().getUsage_due_this_month() + "  / month");
            SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
            typeCarInformationViewHolder.tvLastUpdated.setText(("last updated :" + ft.format(carroBeanList.get(position).getData().getUpdated_at())));
        } else if (holder instanceof TypeCustomizeInsuranceViewHolder){
            TypeCustomizeInsuranceViewHolder typeCustomizeInsuranceViewHolder = (TypeCustomizeInsuranceViewHolder) holder;

            customizeInsuranceBeanList = new ArrayList<>();
            if ( carroBeanList.get(0).getData().getBase_price() == null){
                customizeInsuranceBeanList.add(new CustomizeInsuranceBean("Base Price",""));
            }

            customizeInsuranceBeanList.add(new CustomizeInsuranceBean("Road Tax","$ "+String.valueOf(carroBeanList.get(0).getData().getRoad_tax())));
            customizeInsuranceBeanList.add(new CustomizeInsuranceBean("Usage Based insurance","$ "+""));
            customizeInsuranceBeanList.add(new CustomizeInsuranceBean("Named Drivers",carroBeanList.get(0).getData().getDrivers().get(0).getName()));
            customizeInsuranceBeanList.add(new CustomizeInsuranceBean("Insurance Excess","$ "+String.valueOf(carroBeanList.get(0).getData().getInsurance_excess())));

            if(countryCode ==1){
                customizeInsuranceBeanList.set(2,new CustomizeInsuranceBean("Total Fine",""));
                customizeInsuranceBeanList.set(3,new CustomizeInsuranceBean("Total Fine Amount",""));
            }else {

                customizeInsuranceBeanList.set(2,new CustomizeInsuranceBean("Usage Based insurance","$ "+""));
                customizeInsuranceBeanList.set(3,new CustomizeInsuranceBean("Named Drivers",carroBeanList.get(0).getData().getDrivers().get(0).getName()));

            }

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            typeCustomizeInsuranceViewHolder.CustomizeInsuranceRecyclerView.setLayoutManager(linearLayoutManager);
            typeCustomizeInsuranceViewHolder.CustomizeInsuranceRecyclerView.setAdapter(new CustomizeInsuranceAdapter(context,customizeInsuranceBeanList,carroBeanList,countryCode));
            typeCustomizeInsuranceViewHolder.tvCustomizeInsurance.setVisibility(View.VISIBLE);
            if(countryCode == 1){
                typeCustomizeInsuranceViewHolder.tvCustomizeInsurance.setVisibility(View.GONE);
            }

        } else if (holder instanceof TypeManageSubscriptionViewHolder) {

            TypeManageSubscriptionViewHolder typeManageSubscriptionViewHolder = (TypeManageSubscriptionViewHolder) holder;

            manageSubscriptionBeanList = new ArrayList<>();
            manageSubscriptionBeanList.add(new ManageSubscriptionBean(R.mipmap.image_get_help, "Get Help"));
            manageSubscriptionBeanList.add(new ManageSubscriptionBean(R.mipmap.image_view_docs, "View Docs"));
            manageSubscriptionBeanList.add(new ManageSubscriptionBean(R.mipmap.image_payments, "Payments"));
            manageSubscriptionBeanList.add(new ManageSubscriptionBean(R.mipmap.image_cancel_sub, "Cancel Sub"));
            GridLayoutManager gridLayoutManager;

            if(countryCode ==1){
                manageSubscriptionBeanList.remove(1);
                gridLayoutManager = new GridLayoutManager(context,manageSubscriptionBeanList.size());
            }else {
                manageSubscriptionBeanList.clear();
                manageSubscriptionBeanList.add(new ManageSubscriptionBean(R.mipmap.image_get_help, "Get Help"));
                manageSubscriptionBeanList.add(new ManageSubscriptionBean(R.mipmap.image_view_docs, "View Docs"));
                manageSubscriptionBeanList.add(new ManageSubscriptionBean(R.mipmap.image_payments, "Payments"));
                manageSubscriptionBeanList.add(new ManageSubscriptionBean(R.mipmap.image_cancel_sub, "Cancel Sub"));
            }
            gridLayoutManager = new GridLayoutManager(context,manageSubscriptionBeanList.size());
            gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
            typeManageSubscriptionViewHolder.recyclerViewManageSubscription.setLayoutManager(gridLayoutManager);
            typeManageSubscriptionViewHolder.recyclerViewManageSubscription.setAdapter(new ManageSubscriptionAdapter(context, manageSubscriptionBeanList,countryCode));



        }else if (holder instanceof TypeEnhanceSubscriptionViewHolder){
            TypeEnhanceSubscriptionViewHolder typeEnhanceSubscriptionViewHolder = (TypeEnhanceSubscriptionViewHolder) holder;

            enhanceSubscriptionBeanList = new ArrayList<>();
            enhanceSubscriptionBeanList.add(new EnhanceSubscriptionBean(R.mipmap.iv_item_enhance_sub,R.string.concierge_service_title,R.string.concierge_service_content));
            enhanceSubscriptionBeanList.add(new EnhanceSubscriptionBean(R.mipmap.iv_item_enhance_sub,R.string.concierge_service_title,R.string.concierge_service_content));
            enhanceSubscriptionBeanList.add(new EnhanceSubscriptionBean(R.mipmap.iv_item_enhance_sub,R.string.concierge_service_title,R.string.concierge_service_content));

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            typeEnhanceSubscriptionViewHolder.recyclerViewEnhanceSubscription.setLayoutManager(linearLayoutManager);
            typeEnhanceSubscriptionViewHolder.recyclerViewEnhanceSubscription.setAdapter(new EnhanceSubscriptionAdapter(context, enhanceSubscriptionBeanList,countryCode));
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return CARINFORMATION;
        } else if (position == 1){
            return CUSTOMIZE_INSURANCE;
        }else if (position == 2){
            return MANAGE_SUBSCRIPTION;
        }else if (position == 3){
            return  ENHANCE_SUBSCRIPTION;
        }else {
            return  ENHANCE_SUBSCRIPTION;
        }

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class TypeCarInformationViewHolder extends RecyclerView.ViewHolder{

        TextView tvPrompt;
        ImageView ivCar;
        TextView tvMakeModel;
        TextView tvCarPlateNumber;
        ProgressBar pbUserInformation;
        TextView tvProgressBar;
        TextView tvContentDrivenThisMonth;
        TextView tvTitleDrivenThisMonth;
        TextView tvContentUsageDueThisMonth;
        TextView tvTitleUsageDueThisMonth;
        TextView tvLastUpdated;

        public TypeCarInformationViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPrompt = itemView.findViewById(R.id.tv_prompt);
            ivCar = itemView.findViewById(R.id.iv_car);
            tvMakeModel = itemView.findViewById(R.id.tv_make_model);
            tvCarPlateNumber = itemView.findViewById(R.id.tv_carplate_number);
            pbUserInformation = itemView.findViewById(R.id.pb_user_information);
            tvProgressBar = itemView.findViewById(R.id.tv_progress_bar);
            tvContentDrivenThisMonth = itemView.findViewById(R.id.tv_content_driven_this_month);
            tvTitleDrivenThisMonth = itemView.findViewById(R.id.tv_title_driven_this_month);
            tvContentUsageDueThisMonth = itemView.findViewById(R.id.tv_content_usage_due_this_month);
            tvTitleUsageDueThisMonth = itemView.findViewById(R.id.tv_title_usage_due_this_month);
            tvLastUpdated = itemView.findViewById(R.id.tv_last_updated);
        }
    }

    public class TypeCustomizeInsuranceViewHolder extends RecyclerView.ViewHolder{
        RecyclerView CustomizeInsuranceRecyclerView;
        TextView tvCustomizeInsurance;
        public TypeCustomizeInsuranceViewHolder( View itemView) {
            super(itemView);
            CustomizeInsuranceRecyclerView = itemView.findViewById(R.id.recycler_customize_insurance);
            tvCustomizeInsurance = itemView.findViewById(R.id.tv_customize_insurance);

        }
    }

    public class TypeManageSubscriptionViewHolder extends RecyclerView.ViewHolder {

        TextView tvManageYourSubscription;
        RecyclerView recyclerViewManageSubscription;

        public TypeManageSubscriptionViewHolder(View itemView) {
            super(itemView);
            tvManageYourSubscription = itemView.findViewById(R.id.tv_manage_your_subscription);
            recyclerViewManageSubscription = itemView.findViewById(R.id.recycler_manage_subscription);
        }
    }

    public class TypeEnhanceSubscriptionViewHolder extends RecyclerView.ViewHolder {

        TextView tvEnhanceYourSubscription;
        RecyclerView recyclerViewEnhanceSubscription;

        public TypeEnhanceSubscriptionViewHolder(View itemView) {
            super(itemView);
            tvEnhanceYourSubscription = itemView.findViewById(R.id.tv_enhance_your_subscription);
            recyclerViewEnhanceSubscription = itemView.findViewById(R.id.recycler_enhance_your_subscription);
        }
    }
}
