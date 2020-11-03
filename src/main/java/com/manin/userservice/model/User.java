package com.manin.userservice.model;

import org.springframework.data.annotation.Id;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class User {
    public static final String BUSINESS_NAME_VALIDATION_MSG = "Business name not provided";
    public static final String OWNER_NAME_VALIDATION_MSG = "Owner name not provided";
    public static final String CONTACT_DETAILS_VALIDATION_MSG = "Contact Details not provided";
    public static final String TAX_DETAILS_VALIDATION_MSG = "Tax Details not provided";

    @Id
    private String id;
    @NotBlank(message = BUSINESS_NAME_VALIDATION_MSG)
    private String businessName;
    @NotBlank(message = OWNER_NAME_VALIDATION_MSG)
    private String ownerName;
    @NotNull(message = CONTACT_DETAILS_VALIDATION_MSG)
    @Valid
    private ContactDetails businessContactDetails;
    @NotNull(message = TAX_DETAILS_VALIDATION_MSG)
    @Valid
    private TaxDetails taxDetails;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public ContactDetails getBusinessContactDetails() {
        return businessContactDetails;
    }

    public void setBusinessContactDetails(ContactDetails businessContactDetails) {
        this.businessContactDetails = businessContactDetails;
    }

    public TaxDetails getTaxDetails() {
        return taxDetails;
    }

    public void setTaxDetails(TaxDetails taxDetails) {
        this.taxDetails = taxDetails;
    }
}
