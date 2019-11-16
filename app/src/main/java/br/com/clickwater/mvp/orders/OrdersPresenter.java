package br.com.clickwater.mvp.orders;

import android.content.Context;

import java.util.List;

import br.com.clickwater.data.model.Order;

public class OrdersPresenter implements OrdersMVP.Presenter {

    private OrdersMVP.Model model;
    private OrdersMVP.View view;

    @Override
    public void showToast(String mensagem) {
        view.showToast(mensagem);
    }

    @Override
    public void setView(OrdersMVP.View view) {
        this.view = view;
    }

    @Override
    public void popularRecyclerView(List<Order> orders) {
        view.popularRecyclerView(orders);
    }

    @Override
    public Context getContext() {
        return (Context) view;
    }
}
