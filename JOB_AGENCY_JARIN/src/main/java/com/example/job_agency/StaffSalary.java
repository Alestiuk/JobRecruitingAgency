package com.example.job_agency;

import javafx.beans.property.*;

import java.io.Serializable;
import java.time.LocalDate;

public class StaffSalary implements Serializable {
    private StringProperty staffId;
    private StringProperty staffName;
    private StringProperty designation;
    private IntegerProperty basicSalary;
    private IntegerProperty bonus;
    private IntegerProperty deductions;
    private ObjectProperty<LocalDate> salaryDate;
    private IntegerProperty totalSalary;

    public StaffSalary(String staffId, String staffName, String designation, int basicSalary, int bonus, int deductions, LocalDate salaryDate) {
        this.staffId = new SimpleStringProperty(staffId);
        this.staffName = new SimpleStringProperty(staffName);
        this.designation = new SimpleStringProperty(designation);
        this.basicSalary = new SimpleIntegerProperty(basicSalary);
        this.bonus = new SimpleIntegerProperty(bonus);
        this.deductions = new SimpleIntegerProperty(deductions);
        this.salaryDate = new SimpleObjectProperty<>(salaryDate);
        this.totalSalary = new SimpleIntegerProperty(calculateTotalSalary());
    }

    private int calculateTotalSalary() {
        return basicSalary.get() + bonus.get() - deductions.get();
    }

    public StringProperty staffIdProperty() {
        return staffId;
    }

    public StringProperty staffNameProperty() {
        return staffName;
    }

    public StringProperty designationProperty() {
        return designation;
    }

    public IntegerProperty basicSalaryProperty() {
        return basicSalary;
    }

    public IntegerProperty bonusProperty() {
        return bonus;
    }

    public IntegerProperty deductionsProperty() {
        return deductions;
    }

    public ObjectProperty<LocalDate> salaryDateProperty() {
        return salaryDate;
    }

    public IntegerProperty totalSalaryProperty() {
        return totalSalary;
    }

    public String getStaffId() {
        return staffId.get();
    }

    public void setStaffId(String staffId) {
        this.staffId.set(staffId);
    }

    public String getStaffName() {
        return staffName.get();
    }

    public void setStaffName(String staffName) {
        this.staffName.set(staffName);
    }

    public String getDesignation() {
        return designation.get();
    }

    public void setDesignation(String designation) {
        this.designation.set(designation);
    }

    public int getBasicSalary() {
        return basicSalary.get();
    }

    public void setBasicSalary(int basicSalary) {
        this.basicSalary.set(basicSalary);
    }

    public int getBonus() {
        return bonus.get();
    }

    public void setBonus(int bonus) {
        this.bonus.set(bonus);
    }

    public int getDeductions() {
        return deductions.get();
    }

    public void setDeductions(int deductions) {
        this.deductions.set(deductions);
    }

    public LocalDate getSalaryDate() {
        return salaryDate.get();
    }

    public void setSalaryDate(LocalDate salaryDate) {
        this.salaryDate.set(salaryDate);
    }

    public int getTotalSalary() {
        return totalSalary.get();
    }

    public void setTotalSalary(int totalSalary) {
        this.totalSalary.set(totalSalary);
    }

    @Override
    public String toString() {
        return "Staff ID: " + staffId.get() + ", Name: " + staffName.get() + ", Designation: " + designation.get() +
                ", Basic Salary: " + basicSalary.get() + ", Bonus: " + bonus.get() + ", Deductions: " + deductions.get() +
                ", Salary Date: " + salaryDate.get() + ", Total Salary: " + totalSalary.get();
    }
}
