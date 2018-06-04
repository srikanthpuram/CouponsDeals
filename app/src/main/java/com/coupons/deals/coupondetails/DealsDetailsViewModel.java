package com.coupons.deals.coupondetails;

import com.coupons.deals.application.ui.base.BaseViewModel;
import com.coupons.deals.coupondeals.model.Coupon;

/**
 * Created by spuram on 6/3/2018.
 */

public class DealsDetailsViewModel extends BaseViewModel<DealsDetailsNavigator> {

    private Coupon mCoupon;

    public void setCouponData(Coupon coupon){
        this.mCoupon = coupon;
        getNavigator().updateDealsDetailsUi();
    }

    public Coupon getCouponData(){
        return mCoupon;
    }

}
