package com.yalemang.bean;

public class CarBean {

    private int photoPath;
    private String model;
    private String viewCars;
    private String tj;
    private String date;
    private String belong;
    private String type;
    private String rp;
    private String qty;


    public CarBean(int photoPath, String model, String viewCars, String tj, String date, String belong, String type, String rp, String qty) {

        this.photoPath = photoPath;
        this.model = model;
        this.viewCars = viewCars;
        this.tj = tj;
        this.date = date;
        this.belong = belong;
        this.type = type;
        this.rp = rp;
        this.qty = qty;
    }


    public int getPhotoPath() {
        return photoPath;
    }

    public String getModel() {
        return model;
    }

    public String getViewCars() {
        return viewCars;
    }

    public String getTj() {
        return tj;
    }

    public String getDate() {
        return date;
    }

    public String getBelong() {
        return belong;
    }

    public String getType() {
        return type;
    }

    public String getRp() {
        return rp;
    }

    public String getQty() {
        return qty;
    }
}
