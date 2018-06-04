package com.coupons.deals.coupondeals.ui;

import android.content.Context;
import android.databinding.DataBindingUtil;

import com.coupons.deals.coupondeals.ParseJson;

import org.junit.Before;
import org.junit.runner.RunWith;

/**
 * Created by spuram on 6/4/2018.
 */
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;

import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DealsListViewModel.class, DataBindingUtil.class})
@PowerMockIgnore({"javax.net.ssl.*", "javax.security.*"})
public class DealsListViewModelTest extends ParseJson {

    public MockWebServer mMockWebServer = new MockWebServer();
    private DealsListViewModel dealsListViewModel = new DealsListViewModel();

    private Retrofit retrofit;

    @Mock
    public Context context;

    private String mCouponsDealsResponse;

    @Before
    public void init() {
        //setRxJavaThread();

        try {
            mMockWebServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
