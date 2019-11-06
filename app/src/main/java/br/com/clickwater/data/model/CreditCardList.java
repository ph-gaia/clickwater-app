package br.com.clickwater.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CreditCardList {
    @SerializedName("data")
    public List<CreditCard> data = new ArrayList();
}
