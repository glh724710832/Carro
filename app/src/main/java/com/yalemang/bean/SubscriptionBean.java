package com.yalemang.bean;

public class SubscriptionBean {
    private int subscriptionIcon;
    private String subscriptionItemName;

    public SubscriptionBean(int subscriptionIcon,String subscriptionItemName){
        this.subscriptionIcon = subscriptionIcon;
        this.subscriptionItemName = subscriptionItemName;
    }

    public int getSubscriptionIcon() {
        return subscriptionIcon;
    }

    public String getSubscriptionItemName() {
        return subscriptionItemName;
    }
}
