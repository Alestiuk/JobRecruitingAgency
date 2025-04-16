package com.example.jobrecruitingagency;

public class User {
    private Integer phoneNumber;
    private String password;
    private String accountType;

    public User(Integer phoneNumber, String password, String accountType) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.accountType = accountType;
    }
    public boolean isPhoneValid() {
        return phoneNumber != null && String.valueOf(phoneNumber).matches("1\\d{9}");
    }
    public  boolean isPasswordValid(){
        return password!=null && password.matches(("^[0-9];{8}"));
    }

    public boolean isAccountTypeValid(){
        return accountType!=null;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "User{" +
                "phoneNumber=" + phoneNumber +
                ", password='" + password + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }


}