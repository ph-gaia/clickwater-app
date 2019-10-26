package br.com.clickwater.mvp.address;

import android.content.Context;

import java.util.List;

import br.com.clickwater.data.model.Address;

public class AddressPresenter implements AddressMVP.Presenter {

    private AddressMVP.Model model;
    private AddressMVP.View view;

    public AddressPresenter() {
        model = new AddressModel(this);
    }

    @Override
    public void showToast(String mensagem) {
        view.showToast(mensagem);
    }

    @Override
    public void setView(AddressMVP.View view) {
        this.view = view;
    }

    @Override
    public Context getContext() {
        return (Context) view;
    }

    @Override
    public void requestAddresses(String token) {
        model.requestAddresses(token);
    }

    @Override
    public void popularRecyclerView(List<Address> addresses) {
        view.popularRecyclerView(addresses);
    }
}
