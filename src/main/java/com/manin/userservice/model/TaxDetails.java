package com.manin.userservice.model;

public class TaxDetails {
    // TODO: should use a pattern here like builder ?
    private String gstNumber;
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
