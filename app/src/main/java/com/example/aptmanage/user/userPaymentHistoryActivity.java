package com.example.aptmanage.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aptmanage.R;
import com.example.aptmanage.userDashboard;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class userPaymentHistoryActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_payment_history);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.navigation_payments_user) {
                    return true; // Already on this screen
                } else if (itemId == R.id.navigation_home_user) {
                    startActivity(new Intent(userPaymentHistoryActivity.this, userDashboard.class));
                    return true;
                } else if (itemId == R.id.navigation_maintenance_user) {
                    startActivity(new Intent(userPaymentHistoryActivity.this, userMaintenanceActivity.class));
                    return true;
                } else if (itemId == R.id.navigation_me_user) {
                    startActivity(new Intent(userPaymentHistoryActivity.this, userProfileActivity.class));
                    return true;
                }
                return false;
            }
        });
    }
}
