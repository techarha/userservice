package com.manin.userservice.model;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    private String id;
    private String businessName;
    private String ownerName;
    private ContactDetails businessContactDetails;
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
