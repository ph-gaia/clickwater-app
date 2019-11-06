package br.com.clickwater.data.model;

import android.content.Context;

import com.google.gson.annotations.SerializedName;

import br.com.clickwater.R;

public class Address {

    @SerializedName("street")
    public String street;

    @SerializedName("number")
    public Integer number;

    @SerializedName("complement")
    public String complement;

    @SerializedName("zipCode")
    public String zipCode;

    @SerializedName("neighborhood")
    public String neighborhood;

    @SerializedName("city")
    public String city;

    @SerializedName("state")
    public Integer state;

    public String getStateName( Context context ) {
        return context.getResources().getStringArray( R.array.states )[ 1 ];
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
