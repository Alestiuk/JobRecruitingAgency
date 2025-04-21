package com.example.job_agency;

import java.io.Serializable;

public class CostStatement implements Serializable {
    private String month;
    private String year;
    private String category;
    private int amount;


    public CostStatement(String month, String year, String category, int amount) {
        this.month = month;
        this.year = year;
        this.category = category;
        this.amount = amount;
    }


    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getCategory() {
        return category;
    }

    public int getAmount() {
        return amount;
    }


    @Override
    public String toString() {
        return month + "," + year + "," + category + "," + amount;
    }
}
