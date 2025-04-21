package com.example.job_agency;

import java.io.Serializable;
import java.time.LocalDate;

public class PaymentStatus implements Serializable {
    private String paymentType;
    private double paymentAmount;
    private String paymentStatus;
    private LocalDate paymentDate;

    public PaymentStatus(String paymentType, double paymentAmount, String paymentStatus, LocalDate paymentDate) {
        this.paymentType = paymentType;
        this.paymentAmount = paymentAmount;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
    }


    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }


    @Override
    public String toString() {
        return "PaymentStatus{" +
                "paymentType='" + paymentType + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
