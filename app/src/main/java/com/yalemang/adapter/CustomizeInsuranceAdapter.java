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
import com.yalemang.bean.CustomizeInsuranceBean;
import com.yalemang.carro.R;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author Administrator
 */
public class CustomizeInsuranceAdapter extends RecyclerView.Adapter<CustomizeInsuranceAdapter.CustomizeInsuranceViewHolder> {

    private Context context;
    private List<CustomizeInsuranceBean> customizeInsuranceBeanList;
    private List<CarroBean> carroBeanList;
    private int countryCode;


    public CustomizeInsuranceAdapter(Context context, List<CustomizeInsuranceBean> customizeInsuranceBeanList, List<CarroBean> carroBeanList, int countryCode) {
        this.context = context;
        this.customizeInsuranceBeanList = customizeInsuranceBeanList;
        this.carroBeanList = carroBeanList;
        this.countryCode = countryCode;
    }

    @Override
    public CustomizeInsuranceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view__customize_insurance_list, parent, false);
        CustomizeInsuranceViewHolder customizeInsuranceViewHolder = new CustomizeInsuranceViewHolder(view);
        return customizeInsuranceViewHolder;
    }


    @Override
    public void onBindViewHolder(CustomizeInsuranceAdapter.CustomizeInsuranceViewHolder holder, int position) {
        holder.tvCustomizeInsuranceTitle.setText(customizeInsuranceBeanList.get(position).getTvCustomizeInsuranceTitle());
        holder.tvCustomizeInsuranceContent.setText(customizeInsuranceBeanList.get(position).getTvCustomizeInsuranceContent());
        if (position == customizeInsuranceBeanList.size() - 1) {
            holder.viewCustomizeInsurance.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return customizeInsuranceBeanList.size();
    }


    public class CustomizeInsuranceViewHolder extends RecyclerView.ViewHolder {

        TextView tvCustomizeInsuranceTitle;
        TextView tvCustomizeInsuranceContent;
        View viewCustomizeInsurance;

        public CustomizeInsuranceViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCustomizeInsuranceTitle = itemView.findViewById(R.id.tv_customize_insurance_title);
            tvCustomizeInsuranceContent = itemView.findViewById(R.id.tv_customize_insurance_content);
            viewCustomizeInsurance = itemView.findViewById(R.id.view_customize_insurance);


        }
    }
}
