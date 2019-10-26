package br.com.clickwater.data.model;

import com.google.gson.annotations.SerializedName;

public class CreditCard {

    @SerializedName("number")
    public String number;

    @SerializedName("enterprise")
    public String enterprise;

    @SerializedName("ownerFullName")
    public String ownerFullName;

    @SerializedName("ownerRegNumber")
    public String ownerRegNumber;

    @SerializedName("expiryMonth")
    public Integer expiryMonth;

    @SerializedName("expiryYear")
    public Integer expiryYear;

    @SerializedName("securityNumber")
    public String securityNumber;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getOwnerFullName() {
        return ownerFullName;
    }

    public void setOwnerFullName(String ownerFullName) {
        this.ownerFullName = ownerFullName;
    }

    public String getOwnerRegNumber() {
        return ownerRegNumber;
    }

    public void setOwnerRegNumber(String ownerRegNumber) {
        this.ownerRegNumber = ownerRegNumber;
    }

    public Integer getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(Integer expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public Integer getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(Integer expiryYear) {
        this.expiryYear = expiryYear;
    }

    public String getSecurityNumber() {
        return securityNumber;
    }

    public void setSecurityNumber(String securityNumber) {
        this.securityNumber = securityNumber;
    }
}
