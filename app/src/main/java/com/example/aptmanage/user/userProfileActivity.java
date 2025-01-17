package com.example.aptmanage.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aptmanage.R;
import com.example.aptmanage.userDashboard;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class userProfileActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Highlight the Profile tab
        bottomNavigationView.setSelectedItemId(R.id.navigation_me_user);

        // Handle navigation item clicks
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.navigation_me_user) {
                    return true; // Already on this screen
                } else if (itemId == R.id.navigation_home_user) {
                    startActivity(new Intent(userProfileActivity.this, userDashboard.class));
                    finish();
                    return true;
                } else if (itemId == R.id.navigation_payments_user) {
                    startActivity(new Intent(userProfileActivity.this, userpayment_history.class));
                    finish();
                    return true;
                } else if (itemId == R.id.navigation_maintenance_user) {
                    startActivity(new Intent(userProfileActivity.this, userMaintenanceActivity.class));
                    finish();
                    return true;
                }
                return false;
            }
        });
    }
}