package com.example.aptmanage.user;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class userPaymentHistoryPagerAdapter extends FragmentStateAdapter {

    public userPaymentHistoryPagerAdapter(@NonNull userPaymentHistoryActivity fragment) {
        super(fragment);  // Pass fragment context
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;
        if (position == 0) {
            fragment = new userupcoming_payments(); // Fragment for Upcoming Payments
        } else {
            fragment = new userpast_payments(); // Fragment for Past Payments
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;  // Number of tabs (Upcoming & Past)
    }
}
