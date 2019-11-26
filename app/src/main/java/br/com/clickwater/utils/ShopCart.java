package br.com.clickwater.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import br.com.clickwater.data.model.ItemCart;

public class ShopCart {

    public static final String SHOP_CART = "shop_cart";

    static SharedPreferences getPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public ItemCart getCart(Context context) {
        String object = getPreferences(context).getString(SHOP_CART,"");

        Gson gson = new Gson();
        return gson.fromJson(object, ItemCart.class);
    }

    public void addItem(Context context, ItemCart item) {
        SharedPreferences.Editor editor = getPreferences(context).edit();

        Gson gson = new Gson();
        String jsonObject = gson.toJson(item);
        editor.putString(SHOP_CART, jsonObject);
        editor.apply();
    }

    public void updateItem(Context context, ItemCart item) {
        SharedPreferences.Editor editor = getPreferences(context).edit();

        Gson gson = new Gson();
        String jsonObject = gson.toJson(item);
        editor.putString(SHOP_CART, jsonObject);
        editor.apply();
    }

    public void removeItem(Context context) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.clear();
        editor.apply();
    }
}
