package com.yalemang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yalemang.bean.CarBean;
import com.yalemang.bean.CarroBean;
import com.yalemang.carro.R;

import java.util.Date;
import java.util.List;

public class UserInformationAdapter extends RecyclerView.Adapter<UserInformationAdapter.UserInformationViewHolder> {

    private Context context;
    private List<CarroBean> carroBeanList;
    private int gone;

    public UserInformationAdapter(Context context,List<CarroBean> carroBeanList,int gone){
        this.context = context;
        this.carroBeanList = carroBeanList;
        this.gone = gone;
    }


    @Override
    public UserInformationViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user_information,null);
        UserInformationViewHolder userInformationViewHolder = new UserInformationViewHolder(view);
        return userInformationViewHolder;
    }

    @Override
    public void onBindViewHolder( UserInformationAdapter.UserInformationViewHolder holder, int position) {

        holder.tvMakeModel.setText(carroBeanList.get(position).getData().getMake()+""+carroBeanList.get(position).getData().getModel());
        holder.tvCarplatenumber.setText(carroBeanList.get(position).getData().getCarplate_number());
        holder.pbUserInformation.setMax(carroBeanList.get(position).getData().getEnd_time());
        holder.pbUserInformation.setProgress(carroBeanList.get(position).getData().getStart_time());
        holder.tvContentDriventhismonth.setText(carroBeanList.get(position).getData().getDriven_this_month()+"  km");
        holder.tvContentUsageDueThisMonth.setText("$"+carroBeanList.get(position).getData().getUsage_due_this_month()+"  /month");
        Date date = new Date(carroBeanList.get(position).getData().getUpdated_at());
        holder.tvLastUpdated.setText(("月/日/年格式：%tD%n"+date));
        holder.tvBasePriceContent.setText("$"+String.valueOf(carroBeanList.get(position).getData().getPrice())+"  /month");
        holder.tvRoadTaxContent.setText("$"+String.valueOf(carroBeanList.get(position).getData().getRoad_tax()));
        //holder.tvUsageBasedInsuranceContent.setText("$"+String.valueOf(carroBeanList.get(position).getData().getInsurance_excess())+"  /km");
        holder.tvNamedDriversContent.setText(carroBeanList.get(position).getData().getDrivers().get(position).getName());
        holder.tvInsuranceExcessContent.setText("$"+carroBeanList.get(position).getData().getInsurance_excess());
        if (gone ==8){
            holder.tvCustomizeYourInsurance.setVisibility(gone);
        }

        //holder.recyclerViewSubscription;



    }

    @Override
    public int getItemCount() {
        return carroBeanList.size();
    }

    public class UserInformationViewHolder extends RecyclerView.ViewHolder {
        ImageView ivCar;
        TextView tvMakeModel;
        TextView tvCarplatenumber;
        ProgressBar pbUserInformation;
        TextView tvContentDriventhismonth;
        TextView tvTitleDriventhismonth;
        TextView tvContentUsageDueThisMonth;
        TextView tvTitleUsageDueThisMonth;
        TextView tvLastUpdated;
        TextView tvBasePriceContent;
        TextView tvRoadTaxContent;
        TextView tvUsageBasedInsuranceContent;
        TextView tvNamedDriversContent;
        TextView tvInsuranceExcessContent;
        TextView tvCustomizeYourInsurance;
        //TextView recyclerViewSubscription;

        public UserInformationViewHolder( View itemView) {
            super(itemView);
            ivCar = itemView.findViewById(R.id.iv_car);
            tvMakeModel = itemView.findViewById(R.id.tv_make_model);
            tvCarplatenumber = itemView.findViewById(R.id.tv_carplate_number);
            pbUserInformation = itemView.findViewById(R.id.pb_user_information);
            tvContentDriventhismonth = itemView.findViewById(R.id.tv_content_driven_this_month);
            tvTitleDriventhismonth = itemView.findViewById(R.id.tv_title_driven_this_month);
            tvContentUsageDueThisMonth = itemView.findViewById(R.id.tv_content_usage_due_this_month);
            tvTitleUsageDueThisMonth = itemView.findViewById(R.id.tv_title_usage_due_this_month);
            tvLastUpdated = itemView.findViewById(R.id.tv_last_updated);
            tvBasePriceContent = itemView.findViewById(R.id.tv_base_price_content);
            tvRoadTaxContent = itemView.findViewById(R.id.tv_road_tax_content);
            tvUsageBasedInsuranceContent = itemView.findViewById(R.id.tv_usage_based_insurance_content);
            tvNamedDriversContent = itemView.findViewById(R.id.tv_named_drivers_content);
            tvInsuranceExcessContent = itemView.findViewById(R.id.tv_insurance_excess_content);
            tvCustomizeYourInsurance = itemView.findViewById(R.id.tv_customize_insurance);
            //recyclerViewSubscription = itemView.findViewById(R.id.recycler_view_subscription);
        }
    }
}
