package com.coupons.deals.coupondeals.ui;

import android.util.Log;

import com.coupons.deals.application.ui.base.BaseViewModel;
import com.coupons.deals.coupondeals.model.CouponsDealsResponse;
import com.coupons.deals.repository.remote.services.CouponsDealsApi;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.coupons.deals.application.constants.constants.BASE_URL;

/**
 * Created by spuram on 6/3/2018.
 */

public class DealsListViewModel extends BaseViewModel<DealsListNavigator>{

    private static String TAG = DealsListViewModel.class.getName();
    private CouponsDealsResponse mCouponsDealsResponse;
    private Retrofit mRetrofit;

    public void getCouponsDealsFromRepository() {
        Log.d(TAG,"getCouponsDealsFromRepository called");
        getNavigator().showLoader();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mRetrofit.create(CouponsDealsApi.class).getCoupons("topcoupons")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError );
    }

    public CouponsDealsResponse getCouponsDealsResponse() {
        return mCouponsDealsResponse;
    }

    /**
     * Success scenario when the observable emits data
     * @param couponsDealsResponse the response data, it has tobe shown in the UI
     */
    private void handleResults(CouponsDealsResponse couponsDealsResponse){
        Log.d(TAG,"handleResults called");
        mCouponsDealsResponse = couponsDealsResponse;
        getNavigator().hideLoader();
        if(mCouponsDealsResponse != null){
            getNavigator().updateUI(couponsDealsResponse);
        }else{
            getNavigator().showUnableToProcessDialog();
        }

    }

    /**
     *Error scenario when the observables emits error
     * @param t exception thrown
     */
    private void handleError(Throwable t) {
        getNavigator().hideLoader();
        //show some error message, for now were are showing unable to process dialog, but needs to show some generic messages
        //based on error code
        getNavigator().showUnableToProcessDialog();
    }

}
