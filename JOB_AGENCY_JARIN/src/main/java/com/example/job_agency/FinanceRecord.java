package com.example.job_agency;

import java.io.Serializable;

public class FinanceRecord implements Serializable {
    private String accountName;
    private String accountNumber;
    private double amount;
    private String transactionType;

    public FinanceRecord(String accountName, String accountNumber, double amount, String transactionType) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return accountName + "," + accountNumber + "," + amount + "," + transactionType;
    }
}
