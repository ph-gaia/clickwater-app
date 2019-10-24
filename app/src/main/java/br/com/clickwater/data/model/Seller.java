package br.com.clickwater.data.model;

import com.google.gson.annotations.SerializedName;

public class Seller {

    @SerializedName("id")
    public Integer id;

    @SerializedName("name")
    public String name;

    @SerializedName("image_url")
    public String image_url;

    @SerializedName("open_time")
    public String open_time;

    @SerializedName("close_time")
    public String close_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
