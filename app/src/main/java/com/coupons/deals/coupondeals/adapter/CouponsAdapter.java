package com.coupons.deals.coupondeals.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.coupons.deals.R;
import com.coupons.deals.coupondeals.model.Coupon;
import com.coupons.deals.coupondeals.model.CouponsDealsResponse;
import com.coupons.deals.utils.CouponDealsUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by spuram on 6/3/2018.
 */

public class CouponsAdapter extends RecyclerView.Adapter<CouponsAdapter.ViewHolder>{

    private CouponsDealsCallback mCallback;
    private List<Coupon> mCouponList;
    private Context mContext;

    public interface CouponsDealsCallback {
        void selectedCouponsDealsItem(Coupon coupon);
    }

    public CouponsAdapter(List<Coupon> couponList, CouponsDealsCallback couponsDealsCallback, Context context) {
        this.mCouponList = couponList;
        this.mCallback = couponsDealsCallback;
        this.mContext = context;
    }

    @Override
    public CouponsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coupon_item, parent, false);

        CouponsAdapter.ViewHolder viewHolder = new CouponsAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CouponsAdapter.ViewHolder holder, int position) {
        Coupon coupon = mCouponList.get(position);
        int resourceIdofImage = CouponDealsUtils.getResourceIdofStore(coupon.getStore());
        Picasso.get().load(resourceIdofImage).into(holder.storeLogo);
        holder.store.setText(coupon.getStore());
        holder.coupon.setText(coupon.getCoupon());
        holder.expiry.setText("Expiry: "+coupon.getExpiryDate());
        holder.code.setText("CODE: "+coupon.getCouponCode());

    }

    @Override
    public int getItemCount() {
        return mCouponList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        final ImageView storeLogo;
        final TextView store;
        final TextView coupon;
        final TextView expiry;
        final TextView code;

        public ViewHolder(View view) {
            super(view);

            storeLogo = (ImageView) view.findViewById(R.id.list_store_logo);
            store = (TextView) view.findViewById(R.id.store);
            coupon = (TextView) view.findViewById(R.id.coupon);
            expiry = (TextView) view.findViewById(R.id.expiry);
            code = (TextView) view.findViewById(R.id.coupon_code);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mCallback.selectedCouponsDealsItem(mCouponList.get(getAdapterPosition()));
        }
    }
}
