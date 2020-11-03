package com.manin.userservice.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TaxDetails {
    // TODO: should use a pattern here like builder ?
    @Size(min = 15, max = 15, message = "GST number can only have 15 characters")
    private String gstNumber;
    @Size(min = 10, max = 10, message = "PAN number can only have 10 characters")
    private String panNumber;

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }
}
