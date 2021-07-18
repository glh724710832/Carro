package com.yalemang.bean;

public class EnhanceSubscriptionBean {
    private int enhanceSubscriptionIcon;
    private int enhanceSubscriptionTitle;
    private int enhanceSubscriptionContent;

    public EnhanceSubscriptionBean(int enhanceSubscriptionIcon, int enhanceSubscriptionTitle, int enhanceSubscriptionContent) {
        this.enhanceSubscriptionIcon = enhanceSubscriptionIcon;
        this.enhanceSubscriptionTitle = enhanceSubscriptionTitle;
        this.enhanceSubscriptionContent = enhanceSubscriptionContent;
    }

    public int getEnhanceSubscriptionIcon() {
        return enhanceSubscriptionIcon;
    }

    public int getEnhanceSubscriptionTitle() {
        return enhanceSubscriptionTitle;
    }

    public int getEnhanceSubscriptionContent() {
        return enhanceSubscriptionContent;
    }
}


