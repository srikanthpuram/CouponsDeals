package com.coupons.deals.coupondeals.model;

import java.util.List;

/**
 * Created by spuram on 6/3/2018.
 */

public class CouponsDealsResponse {

    private String store;
    private String totalCoupons ;
    private String maxCashback;
    private List<Coupon> coupons;

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getTotalCoupons() {
        return totalCoupons;
    }

    public void setTotalCoupons(String totalCoupons) {
        this.totalCoupons = totalCoupons;
    }

    public String getMaxCashback() {
        return maxCashback;
    }

    public void setMaxCashback(String maxCashback) {
        this.maxCashback = maxCashback;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }
}
