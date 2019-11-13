package br.com.clickwater.data.model;

import com.google.gson.annotations.SerializedName;

public class Order {

    @SerializedName("id")
    private int id;

    @SerializedName("user")
    private User users;

    @SerializedName("seller")
    private Seller seller;

    @SerializedName("address")
    private Address address;

    @SerializedName("status")
    private String status;

    @SerializedName("delivery_tax")
    private float delivery_tax;

    @SerializedName("not_available_amount")
    private float not_available_amount;

    @SerializedName("total_amount")
    private float total_amount;

    @SerializedName("amount_payable")
    private float amount_payable;

    @SerializedName("request_delivery_time")
    private String request_delivery_time;

    @SerializedName("accepted_delivery_time")
    private String accepted_delivery_time;

    @SerializedName("started_delivery_time")
    private String started_delivery_time;

    @SerializedName("finished_delivery_time")
    private String finished_delivery_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getDelivery_tax() {
        return delivery_tax;
    }

    public void setDelivery_tax(float delivery_tax) {
        this.delivery_tax = delivery_tax;
    }

    public float getNot_available_amount() {
        return not_available_amount;
    }

    public void setNot_available_amount(float not_available_amount) {
        this.not_available_amount = not_available_amount;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    public float getAmount_payable() {
        return amount_payable;
    }

    public void setAmount_payable(float amount_payable) {
        this.amount_payable = amount_payable;
    }

    public String getRequest_delivery_time() {
        return request_delivery_time;
    }

    public void setRequest_delivery_time(String request_delivery_time) {
        this.request_delivery_time = request_delivery_time;
    }

    public String getAccepted_delivery_time() {
        return accepted_delivery_time;
    }

    public void setAccepted_delivery_time(String accepted_delivery_time) {
        this.accepted_delivery_time = accepted_delivery_time;
    }

    public String getStarted_delivery_time() {
        return started_delivery_time;
    }

    public void setStarted_delivery_time(String started_delivery_time) {
        this.started_delivery_time = started_delivery_time;
    }

    public String getFinished_delivery_time() {
        return finished_delivery_time;
    }

    public void setFinished_delivery_time(String finished_delivery_time) {
        this.finished_delivery_time = finished_delivery_time;
    }
}
