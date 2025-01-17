package com.example.aptmanage.user;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aptmanage.R;

import java.util.List;

public class userMaintenanceAdapter extends RecyclerView.Adapter<userMaintenanceAdapter.MaintenanceViewHolder> {

    private List<userMaintenanceIssue> userMaintenanceIssues;

    // Constructor to pass the data
    public userMaintenanceAdapter(List<userMaintenanceIssue> userMaintenanceIssues) {
        this.userMaintenanceIssues = userMaintenanceIssues;
    }

    @NonNull
    @Override
    public MaintenanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each item in the list
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_user_maintenance_item, parent, false);
        return new MaintenanceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MaintenanceViewHolder holder, int position) {
        // Get the maintenance issue at the current position
        userMaintenanceIssue currentIssue = userMaintenanceIssues.get(position);

        // Set the data for each view in the item layout
        holder.issueTypeTextView.setText(currentIssue.getIssueType());
        holder.issueDescriptionTextView.setText(currentIssue.getIssueDescription());
        holder.issueStatusTextView.setText("Status: " + currentIssue.getIssueStatus());
    }

    @Override
    public int getItemCount() {
        // Return the size of the list
        return userMaintenanceIssues.size();
    }

    // ViewHolder class to hold references to the views
    public static class MaintenanceViewHolder extends RecyclerView.ViewHolder {

        TextView issueTypeTextView;
        TextView issueDescriptionTextView;
        TextView issueStatusTextView;

        public MaintenanceViewHolder(View itemView) {
            super(itemView);
            // Initialize the views
            issueTypeTextView = itemView.findViewById(R.id.itemIssueType);
            issueDescriptionTextView = itemView.findViewById(R.id.itemIssueDescription);
            issueStatusTextView = itemView.findViewById(R.id.itemIssueStatus);
        }
    }
}
