package com.example.enviro2;

public class Reward_Model {

    private String title;
    private String Expirydate;
    private String couponbody;


    public Reward_Model(String title, String expirydate, String couponbody) {
        this.title = title;
        this.Expirydate = expirydate;
        this.couponbody = couponbody;
    }

    public String getTitle() {
        return  title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExpirydate() {
        return Expirydate;
    }

    public void setExpirydate(String expirydate) {
        this.Expirydate = expirydate;
    }

    public String getCouponbody() {
        return couponbody;
    }

    public void setCouponbody(String couponbody) {
        this.couponbody = couponbody;
    }
}
