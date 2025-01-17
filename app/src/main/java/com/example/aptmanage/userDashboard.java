package com.example.aptmanage;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aptmanage.user.userMaintenanceActivity;
import com.example.aptmanage.user.userProfileActivity;
import com.example.aptmanage.user.userpayment_history;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class userDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_dashboard);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.navigation_home_user) {
                    // We are already on the home screen, so do nothing or refresh if needed.
                    return true;
                } else if (itemId == R.id.navigation_payments_user) {
                    startActivity(new Intent(userDashboard.this, userpayment_history.class));
                    return true;
                } else if (itemId == R.id.navigation_maintenance_user) {
                    startActivity(new Intent(userDashboard.this, userMaintenanceActivity.class));
                    return true;
                } else if (itemId == R.id.navigation_me_user) {
                    startActivity(new Intent(userDashboard.this, userProfileActivity.class));
                    return true;
                }
                return false;
            }
        });
    }
}