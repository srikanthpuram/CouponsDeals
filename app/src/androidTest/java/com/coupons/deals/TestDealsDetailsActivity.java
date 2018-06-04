package com.coupons.deals;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.coupons.deals.coupondetails.DealsDetailsActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by spuram on 6/4/2018.
 */

@RunWith(AndroidJUnit4.class)
public class TestDealsDetailsActivity {

    @Rule
    public ActivityTestRule<DealsDetailsActivity> mActivityRule = new ActivityTestRule<>(DealsDetailsActivity.class);

    @Test
    public void TestImageView() {

        onView(withId(R.id.details_store_logo)).check(matches(isDisplayed()));
    }

    @Test
    public void TestStoreNameTextView() {
        onView(withId(R.id.details_store_name)).check(matches(isDisplayed()));
    }

    @Test
    public void TestCouponTextView() {
        onView(withId(R.id.details_coupon)).check(matches(isDisplayed()));
    }

    @Test
    public void TestCouponExpiryTextView() {
        onView(withId(R.id.details_coupon_expiry)).check(matches(isDisplayed()));
    }

    @Test
    public void TestCouponCodeTextView() {
        onView(withId(R.id.details_coupon_code)).check(matches(isDisplayed()));
    }
}
