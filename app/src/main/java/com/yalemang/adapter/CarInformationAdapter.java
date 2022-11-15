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

import com.yalemang.bean.CarroBean;
import com.yalemang.carro.R;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author Administrator
 *
 * 此处错误，不需要CarInformationAdapter
 */
public class CarInformationAdapter extends RecyclerView.Adapter<CarInformationAdapter.CarInformationViewHolder> {

    private Context context;
    private List<CarroBean> carroBeanList;
    private int countryNumber;

    public CarInformationAdapter(Context context, List<CarroBean> carroBeanList, int countryNumber) {
        this.context = context;
        this.carroBeanList = carroBeanList;
        this.countryNumber = countryNumber;
    }

    @Override
    public CarInformationViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_carr_information,parent,false);
        CarInformationViewHolder carInformationViewHolder = new CarInformationViewHolder(view);
        return carInformationViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CarInformationAdapter.CarInformationViewHolder holder, int position) {
        holder.tvMakeModel.setText(carroBeanList.get(position).getData().getMake() + "   (" + carroBeanList.get(position).getData().getModel()+")");
        holder.tvCarPlateNumber.setText(carroBeanList.get(position).getData().getCarplate_number());
        holder.pbUserInformation.setMax(100);
        holder.pbUserInformation.setProgress(70);
        holder.tvContentDrivenThisMonth.setText(carroBeanList.get(position).getData().getDriven_this_month() + "  km");
        holder.tvContentUsageDueThisMonth.setText("$" + carroBeanList.get(position).getData().getUsage_due_this_month() + "  / month");
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
        holder.tvLastUpdated.setText(("last updated :" + ft.format(carroBeanList.get(position).getData().getUpdated_at())));

    }

    @Override
    public int getItemCount() {
        return carroBeanList.size();
    }

    public class CarInformationViewHolder extends RecyclerView.ViewHolder{

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

        public CarInformationViewHolder(@NonNull View itemView) {
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
}
