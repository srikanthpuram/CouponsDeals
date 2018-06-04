package com.coupons.deals.utils;

import com.coupons.deals.R;

/**
 * Created by spuram on 6/3/2018.
 */

public class CouponDealsUtils {

    public static int getResourceIdofStore(String storeName) {
        /*
         * based on store name, return the corresping image id
         */
        if (storeName.equalsIgnoreCase("amazon")) {
            return R.drawable.amazon;
        } else if (storeName.equalsIgnoreCase("ebay")) {
            return R.drawable.ebay;
        } else if (storeName.equalsIgnoreCase("walmart")) {
            return R.drawable.walmart;
        } else {
            //default: for all other stores since logos are not available use the default place holder image
            return R.drawable.placeholder_image;
        }
    }

}
