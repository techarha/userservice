package com.manin.userservice.model;

public class ContactDetails {
    private String addressLaneOne;
    private String addressLaneTwo;
    private String pinCode;
    private String city;
    private String state;
    private String phoneNumber;
    private String emailId;

    public String getAddressLaneOne() {
        return addressLaneOne;
    }

    public void setAddressLaneOne(String addressLaneOne) {
        this.addressLaneOne = addressLaneOne;
    }

    public String getAddressLaneTwo() {
        return addressLaneTwo;
    }

    public void setAddressLaneTwo(String addressLaneTwo) {
        this.addressLaneTwo = addressLaneTwo;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
