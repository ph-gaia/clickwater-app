package br.com.clickwater.data.model;

import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("brand")
    private String brand;

    @SerializedName("image_url")
    private String image_url;

    @SerializedName("addtional_info")
    private String addtional_info;

    @SerializedName("price")
    private float price;

    @SerializedName("promotional_price")
    private float promotional_price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getAddtional_info() {
        return addtional_info;
    }

    public void setAddtional_info(String addtional_info) {
        this.addtional_info = addtional_info;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPromotional_price() {
        return promotional_price;
    }

    public void setPromotional_price(float promotional_price) {
        this.promotional_price = promotional_price;
    }
}
