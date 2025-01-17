package com.example.aptmanage.user;

public class userMaintenanceIssue {

    private String issueType;
    private String issueDescription;
    private String issueStatus;

    // Constructor
    public userMaintenanceIssue(String issueType, String issueDescription, String issueStatus) {
        this.issueType = issueType;
        this.issueDescription = issueDescription;
        this.issueStatus = issueStatus;
    }

    // Getters
    public String getIssueType() {
        return issueType;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public String getIssueStatus() {
        return issueStatus;
    }

    // Setters
    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public void setIssueStatus(String issueStatus) {
        this.issueStatus = issueStatus;
    }
}
