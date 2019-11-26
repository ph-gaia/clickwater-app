package br.com.clickwater.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<ItemCart> itens = new ArrayList<ItemCart>();

    private Double total = 0.0;

    public void adiciona(ItemCart item) {
        itens.add(item);
        total += item.getTotal();
    }

    public void remove(int indiceItem) {
        ItemCart removido = itens.remove(indiceItem);
        total -= removido.getTotal();
    }
}
