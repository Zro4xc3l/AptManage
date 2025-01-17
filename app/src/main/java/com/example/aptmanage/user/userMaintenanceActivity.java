package com.example.aptmanage.user;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aptmanage.R;
import com.example.aptmanage.userDashboard;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class userMaintenanceActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    private RecyclerView reportedIssuesRecyclerView;
    private userMaintenanceAdapter userMaintenanceAdapter;
    private List<userMaintenanceIssue> userMaintenanceIssuesList;

    // UI components for the maintenance form
    private TextInputLayout issueTypeLayout;
    private TextInputEditText issueDescriptionEditText;
    private Button uploadPhotoButton;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_maintenance);

        // Initialize the UI components for maintenance issue form
        issueTypeLayout = findViewById(R.id.issueTypeLayout);
        issueDescriptionEditText = findViewById(R.id.issueDescriptionEditText);
        uploadPhotoButton = findViewById(R.id.uploadPhotoButton);
        submitButton = findViewById(R.id.submitButton);

        // Initialize the RecyclerView
        reportedIssuesRecyclerView = findViewById(R.id.reportedIssuesRecyclerView);
        reportedIssuesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the list and adapter for the RecyclerView
        userMaintenanceIssuesList = new ArrayList<>();
        userMaintenanceAdapter = new userMaintenanceAdapter(userMaintenanceIssuesList);
        reportedIssuesRecyclerView.setAdapter(userMaintenanceAdapter);

        // Handle Submit Button Click for submitting new issue
        submitButton.setOnClickListener(v -> {
            String issueDescription = issueDescriptionEditText.getText().toString();
            if (!issueDescription.isEmpty()) {
                userMaintenanceIssue newIssue = new userMaintenanceIssue("Plumbing Issue", issueDescription, "Pending");
                userMaintenanceIssuesList.add(newIssue);
                userMaintenanceAdapter.notifyDataSetChanged();  // Notify adapter of data change
                issueDescriptionEditText.setText(""); // Clear the input field
                Toast.makeText(userMaintenanceActivity.this, "Issue reported!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(userMaintenanceActivity.this, "Please provide an issue description", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle Upload Photo Button (currently placeholder)
        uploadPhotoButton.setOnClickListener(v -> {
            // Logic to upload a photo (this part can be expanded further)
            Toast.makeText(userMaintenanceActivity.this, "Upload photo feature coming soon!", Toast.LENGTH_SHORT).show();
        });

        // Bottom Navigation setup
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.navigation_maintenance_user);  // Highlight Maintenance tab

        // Handle navigation item clicks
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.navigation_maintenance_user) {
                return true; // Already on this screen
            } else if (itemId == R.id.navigation_home_user) {
                startActivity(new Intent(userMaintenanceActivity.this, userDashboard.class));
                finish();
                return true;
            } else if (itemId == R.id.navigation_payments_user) {
                startActivity(new Intent(userMaintenanceActivity.this, userpayment_history.class));
                finish();
                return true;
            } else if (itemId == R.id.navigation_me_user) {
                startActivity(new Intent(userMaintenanceActivity.this, userProfileActivity.class));
                finish();
                return true;
            }
            return false;
        });
    }
}
