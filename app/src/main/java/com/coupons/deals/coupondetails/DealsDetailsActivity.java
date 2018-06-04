package com.coupons.deals.coupondetails;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.coupons.deals.R;
import com.coupons.deals.application.ui.base.BaseActivity;
import com.coupons.deals.coupondeals.model.Coupon;
import com.coupons.deals.databinding.ActivityDealsDetailsBinding;
import com.coupons.deals.utils.CouponDealsUtils;
import com.squareup.picasso.Picasso;

/**
 * This activity displays individual deals details, when the user clicks on a particular deal
 */

public class DealsDetailsActivity extends BaseActivity<ActivityDealsDetailsBinding> implements DealsDetailsNavigator{

    private DealsDetailsViewModel mDealsDetailsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Coupon coupon = getIntent().getParcelableExtra("couponData");
        if(coupon != null) {
            mDealsDetailsViewModel.setCouponData(coupon);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_deals_details;
    }

    @Override
    protected void setDataBinding() {
        mDealsDetailsViewModel = ViewModelProviders.of(this).get(DealsDetailsViewModel.class);
        mDealsDetailsViewModel.setContext(this);
        mDealsDetailsViewModel.setNavigator(this);
    }


    @Override
    public void updateDealsDetailsUi() {
        Coupon coupon = mDealsDetailsViewModel.getCouponData();
        if(coupon == null){
            return;
        }

        int imageResourceId = CouponDealsUtils.getResourceIdofStore(coupon.getStore());
        Picasso.get().load(imageResourceId).into(getViewDataBinding().detailsStoreLogo);
        getViewDataBinding().detailsStoreName.setText(coupon.getStore());
        getViewDataBinding().detailsCoupon.setText(getResources().getString(R.string.coupon)+" "+coupon.getCoupon());
        getViewDataBinding().detailsCouponExpiry.setText(getResources().getString(R.string.expires)+" "+coupon.getExpiryDate());
        getViewDataBinding().detailsCouponCode.setText(getResources().getString(R.string.code)+" "+coupon.getCouponCode());
    }
}
