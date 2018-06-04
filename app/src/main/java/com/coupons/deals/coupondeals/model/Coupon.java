package com.coupons.deals.coupondeals.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by spuram on 6/3/2018.
 */

public class Coupon implements Parcelable{

    private String store;
    private String coupon;
    private String expiryDate;
    private String couponCode;

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public Coupon(Parcel parcel){
        store = parcel.readString();
        coupon = parcel.readString();
        expiryDate = parcel.readString();
        couponCode = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(store);
        parcel.writeString(coupon);
        parcel.writeString(expiryDate);
        parcel.writeString(couponCode);
    }

    public static final Creator<Coupon> CREATOR = new Creator<Coupon>() {
        @Override
        public Coupon createFromParcel(Parcel parcel) {
            return new Coupon(parcel);
        }

        @Override
        public Coupon[] newArray(int i) {
            return new Coupon[1];
        }
    };
}
