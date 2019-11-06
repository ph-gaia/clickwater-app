package br.com.clickwater.mvp.orders;

import android.content.Context;

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
    public Context getContext() {
        return (Context) view;
    }
}
