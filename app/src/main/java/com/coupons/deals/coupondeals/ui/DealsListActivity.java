package com.coupons.deals.coupondeals.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.coupons.deals.R;
import com.coupons.deals.application.ui.base.BaseActivity;
import com.coupons.deals.coupondeals.adapter.CouponsAdapter;
import com.coupons.deals.coupondeals.model.Coupon;
import com.coupons.deals.coupondeals.model.CouponsDealsResponse;
import com.coupons.deals.coupondetails.DealsDetailsActivity;
import com.coupons.deals.databinding.ActivityDealsListBinding;
import com.coupons.deals.utils.DialogUtils;

public class DealsListActivity extends BaseActivity<ActivityDealsListBinding> implements DealsListNavigator,
                                                                                        CouponsAdapter.CouponsDealsCallback{

    private static final String TAG = DealsListActivity.class.getName();
    DealsListViewModel mDealsListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        if(mDealsListViewModel.getCouponsDealsResponse() != null){
            Log.d(TAG,"onPostCreate getCouponsDealsResponse() ");
            initDealsListUi(mDealsListViewModel.getCouponsDealsResponse());
        }else{
            Log.d(TAG,"onPostCreate getCouponsDealsFromRepository() ");
            mDealsListViewModel.getCouponsDealsFromRepository();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_deals_list;
    }

    @Override
    protected void setDataBinding() {
        mDealsListViewModel = ViewModelProviders.of(this).get(DealsListViewModel.class);
        mDealsListViewModel.setContext(this);
        mDealsListViewModel.setNavigator(this);
    }

    /**
     * function to update the couponsdeals list with the response data
     * @param couponsDealsResponse the couponsdeals response from ViewModel
     */
    private void initDealsListUi(CouponsDealsResponse couponsDealsResponse) {

        if(couponsDealsResponse.getCoupons() != null) {
            CouponsAdapter couponsAdapter = new CouponsAdapter(couponsDealsResponse.getCoupons(), this,DealsListActivity.this);

            RecyclerView recyclerView = getViewDataBinding().dealsListRecyclerview;
            recyclerView.setAdapter(couponsAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }

    @Override
    public void showLoader() {
        showProgressDialog(R.string.retrieving_coupons_deals);
    }

    @Override
    public void hideLoader() {
        hideProgressDialog();
    }

    @Override
    public void showNoInternetDialog() {
        showNoInternetMessage();
    }

    @Override
    public void showUnableToProcessDialog() {
        DialogUtils.getAlertDialog(DealsListActivity.this, -1, getResources().getString(R.string.unable_to_process_error), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }, true, R.style.alert_dialog_theme).show();
    }

    @Override
    public void updateUI(CouponsDealsResponse couponsDealsResponse) {
        initDealsListUi(couponsDealsResponse);
    }

    @Override
    public void selectedCouponsDealsItem(Coupon coupon) {
        Intent forecastDetailIntent = new Intent(this, DealsDetailsActivity.class);
        forecastDetailIntent.putExtra("couponData", coupon);
        startActivity(forecastDetailIntent);
    }
}
