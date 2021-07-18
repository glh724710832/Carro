package com.yalemang.bean;

import android.widget.TextView;

public class CustomizeInsuranceBean {

    private String tvCustomizeInsuranceTitle;
    private String tvCustomizeInsuranceContent;


    public CustomizeInsuranceBean(String tvCustomizeInsuranceTitle, String tvCustomizeInsuranceContent) {

        this.tvCustomizeInsuranceTitle = tvCustomizeInsuranceTitle;
        this.tvCustomizeInsuranceContent = tvCustomizeInsuranceContent;

    }

    public String getTvCustomizeInsuranceTitle() {
        return tvCustomizeInsuranceTitle;
    }

    public String getTvCustomizeInsuranceContent() {
        return tvCustomizeInsuranceContent;
    }
}
