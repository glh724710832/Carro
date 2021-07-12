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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
public class UserInformationHeadAdapter extends RecyclerView.Adapter<UserInformationHeadAdapter.UserInformationHeadViewHolder> {

    private Context context;
    private List<CarroBean> carroBeanList;
    private int areaNumber;


    public UserInformationHeadAdapter(Context context, List<CarroBean> carroBeanList, int areaNumber) {
        this.context = context;
        this.carroBeanList = carroBeanList;
        this.areaNumber = areaNumber;
    }


    @Override
    public UserInformationHeadViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user_information,null);
        UserInformationHeadViewHolder userInformationHeadViewHolder = new UserInformationHeadViewHolder(view);
        return userInformationHeadViewHolder;
    }

    @Override
    public void onBindViewHolder( UserInformationHeadAdapter.UserInformationHeadViewHolder holder, int position) {
        holder.tvMakeModel.setText(carroBeanList.get(position).getData().getMake() + "   " + carroBeanList.get(position).getData().getModel());
        holder.tvCarPlateNumber.setText(carroBeanList.get(position).getData().getCarplate_number());
        holder.pbUserInformation.setMax(100);
        holder.pbUserInformation.setProgress(70);
        holder.tvContentDrivenThisMonth.setText(carroBeanList.get(position).getData().getDriven_this_month() + "  km");
        holder.tvContentUsageDueThisMonth.setText("$" + carroBeanList.get(position).getData().getUsage_due_this_month() + "  / month");
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
        holder.tvLastUpdated.setText(("last updated :" + ft.format(carroBeanList.get(position).getData().getUpdated_at())));
        holder.tvBasePriceContent.setText("$" + carroBeanList.get(position).getData().getPrice() + "  /month");
        holder.tvRoadTaxContent.setText("$" + (carroBeanList.get(position).getData().getRoad_tax()));
        holder.tvUsageBasedInsuranceContent.setText("$" + (carroBeanList.get(position).getData().getInsurance_excess()) + "  / km");
        holder.tvNamedDriversContent.setText(carroBeanList.get(position).getData().getDrivers().get(position).getName());
        holder.tvInsuranceExcessContent.setText("$" + carroBeanList.get(position).getData().getInsurance_excess());
        if (areaNumber == 1) {
            holder.tvCustomizeYourInsurance.setVisibility(View.INVISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return carroBeanList.size();
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


}
