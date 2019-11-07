package br.com.clickwater.mvp.newPayment;

import android.content.Context;

import br.com.clickwater.data.model.CreditCard;

public class NewPaymentPresenter implements NewPaymentMVP.Presenter {

    private NewPaymentMVP.Model model;
    private NewPaymentMVP.View view;

    public NewPaymentPresenter() {
        model = new NewPaymentModel(this);
    }

    @Override
    public void showToast(String mensagem) {
        view.showToast(mensagem);
    }

    @Override
    public void setView(NewPaymentMVP.View view) {
        this.view = view;
    }

    @Override
    public Context getContext() {
        return (Context) view;
    }

    @Override
    public void requestCreateCreditCard(CreditCard creditCard, String token) {
        model.requestCreateCreditCard(creditCard, token);
    }

}
