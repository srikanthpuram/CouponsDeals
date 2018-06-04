package com.coupons.deals.coupondeals.ui;

import com.coupons.deals.coupondeals.model.CouponsDealsResponse;

/**
 * Created by spuram on 6/3/2018.
 */

public interface DealsListNavigator {

    public void showLoader();

    public void hideLoader();

    public void showNoInternetDialog();

    public void showUnableToProcessDialog();

    public void updateUI(CouponsDealsResponse couponsDealsResponse);

}
