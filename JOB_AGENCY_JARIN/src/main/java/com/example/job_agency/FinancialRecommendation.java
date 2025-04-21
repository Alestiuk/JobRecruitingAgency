package com.example.job_agency;

import java.io.Serializable;
import java.time.LocalDate;

public class FinancialRecommendation implements Serializable {
    private String title;
    private String description;
    private String type;
    private double amount;
    private String approvalStatus;
    private LocalDate recommendationDate;

    public FinancialRecommendation(String title, String description, String type, double amount, String approvalStatus, LocalDate recommendationDate) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.approvalStatus = approvalStatus;
        this.recommendationDate = recommendationDate;
    }


    public String getTitle() { return title; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public String getApprovalStatus() { return approvalStatus; }
    public String toString() {
        return title + "," + type + "," + amount + "," + approvalStatus + "," + recommendationDate;
    }
}
