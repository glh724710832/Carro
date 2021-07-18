package com.yalemang.bean;

public class ManageSubscriptionBean {
    private int manageSubscriptionIcon;
    private String manageSubscriptionName;

    public ManageSubscriptionBean(int manageSubscriptionIcon, String manageSubscriptionName) {
        this.manageSubscriptionIcon = manageSubscriptionIcon;
        this.manageSubscriptionName = manageSubscriptionName;
    }

    public int getManageSubscriptionIcon() {
        return manageSubscriptionIcon;
    }

    public String getManageSubscriptionName() {
        return manageSubscriptionName;
    }
}


