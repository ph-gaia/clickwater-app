package br.com.clickwater.mvp.payment;

import android.content.Context;

import java.util.List;

import br.com.clickwater.data.model.CreditCard;

public class PaymentPresenter implements PaymentMVP.Presenter {

    private PaymentMVP.Model model;
    private PaymentMVP.View view;

    @Override
    public void showToast(String mensagem) {
        view.showToast(mensagem);
    }

    @Override
    public void setView(PaymentMVP.View view) {
        this.view = view;
    }

    @Override
    public Context getContext() {
        return (Context) view;
    }

    @Override
    public void popularRecyclerView(List<CreditCard> payments) {
        view.popularRecyclerView(payments);
    }
}
