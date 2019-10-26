package br.com.clickwater.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AddressList {
    @SerializedName("data")
    public List<Address> data = new ArrayList();
}