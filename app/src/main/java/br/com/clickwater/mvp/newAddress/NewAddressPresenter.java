package br.com.clickwater.mvp.newAddress;

import android.content.Context;

import br.com.clickwater.data.model.Address;

public class NewAddressPresenter implements NewAddressMVP.Presenter {

    private NewAddressMVP.Model model;
    private NewAddressMVP.View view;

    @Override
    public void showToast(String mensagem) {
        view.showToast(mensagem);
    }

    @Override
    public void setView(NewAddressMVP.View view) {
        this.view = view;
    }

    @Override
    public Context getContext() {
        return (Context) view;
    }

    @Override
    public void requestCreateNewAddress(Address address) {
        model.requestCreateNewAddress(address);
    }
}
