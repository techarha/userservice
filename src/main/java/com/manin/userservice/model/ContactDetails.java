package com.manin.userservice.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ContactDetails {
    @NotBlank(message = "Address not provided")
    private String addressLane;
    @Size(min = 6, max = 6, message = "Pin code can only have 6 characters")
    private String pinCode;
    @NotBlank(message = "Town not provided")
    private String town;
    @NotBlank(message = "City not provided")
    private String city;
    @NotBlank(message = "State not provided")
    private String state;
    @Size(min = 10, max = 10, message = "Phone number can only have 10  characters")
    private String phoneNumber;
    @NotBlank(message = "EmailId not provided")
    //TODO: add email regex validation here.
    private String emailId;

    public String getAddressLane() {
        return addressLane;
    }

    public void setAddressLane(String addressLane) {
        this.addressLane = addressLane;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
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
