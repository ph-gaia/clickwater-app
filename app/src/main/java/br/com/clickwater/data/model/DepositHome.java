package br.com.clickwater.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DepositHome {

    @SerializedName("data")
    public List<Seller> data = new ArrayList();
}
