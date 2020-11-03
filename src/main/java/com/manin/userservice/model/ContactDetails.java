package com.manin.userservice.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ContactDetails {
    public static final String ADDRESS_VALIDATION_MSG = "Address not provided";
    public static final String PIN_CODE_VALIDATION_MSG = "Pin code can only have 6 characters";
    public static final String TOWN_VALIDATION_MSG = "Town not provided";
    public static final String CITY_VALIDATION_MSG = "City not provided";
    public static final String STATE_VALIDATION_MSG = "State not provided";
    public static final String PHONE_NUMBER_VALIDATION_MSG = "Phone number can only have 10  characters";
    public static final String EMAIL_ID_VALIDATION_MSG = "EmailId not provided";


    @NotBlank(message = ADDRESS_VALIDATION_MSG)
    private String addressLane;
    @Size(min = 6, max = 6, message = PIN_CODE_VALIDATION_MSG)
    private String pinCode;
    @NotBlank(message = TOWN_VALIDATION_MSG)
    private String town;
    @NotBlank(message = CITY_VALIDATION_MSG)
    private String city;
    @NotBlank(message = STATE_VALIDATION_MSG)
    private String state;
    @Size(min = 10, max = 10, message = PHONE_NUMBER_VALIDATION_MSG)
    private String phoneNumber;
    @NotBlank(message = EMAIL_ID_VALIDATION_MSG)
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
