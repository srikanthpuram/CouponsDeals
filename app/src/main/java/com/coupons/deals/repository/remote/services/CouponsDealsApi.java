package com.coupons.deals.repository.remote.services;

import com.coupons.deals.coupondeals.model.CouponsDealsResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by spuram on 6/3/2018.
 */

public interface CouponsDealsApi {

    @GET("coupons/")
    Observable<CouponsDealsResponse> getCoupons(@Query("status") String status);
    /*@GET("storeOffers/")
    Observable<CouponsDealsResponse> getStoreInfo();*/
}
