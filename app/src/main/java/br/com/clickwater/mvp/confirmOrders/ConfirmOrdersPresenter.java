package br.com.clickwater.mvp.confirmOrders;

import android.content.Context;

public class ConfirmOrdersPresenter implements ConfirmOrdersMVP.Presenter {

    private ConfirmOrdersMVP.View view;

    @Override
    public void showSnackbar(String mensagem) {
        view.showSnackbar(mensagem);
    }

    @Override
    public void setView(ConfirmOrdersMVP.View view) {
        this.view = view;
    }

    @Override
    public Context getContext() {
        return (Context) view;
    }
}
