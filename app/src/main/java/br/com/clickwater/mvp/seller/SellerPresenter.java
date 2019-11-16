package br.com.clickwater.mvp.seller;

import android.content.Context;

import java.util.List;

import br.com.clickwater.data.model.Product;
import br.com.clickwater.data.model.Seller;

public class SellerPresenter implements SellerMVP.Presenter {

    private SellerMVP.Model model;
    private SellerMVP.View view;

    public SellerPresenter() {
        model = new SellerModel( this );
    }

    @Override
    public void showToast(String mensagem) {
        view.showToast(mensagem);
    }

    @Override
    public void setView(SellerMVP.View view) {
        this.view = view;
    }

    @Override
    public Context getContext() {
        return (Context) view;
    }

    @Override
    public void popularSellerDetails(Seller seller) {
        view.popularSellerDetails(seller);
    }

    @Override
    public void requestSellerDetails(String token, int sellerId) {
        model.requestSellerDetails(token, sellerId);
    }

    @Override
    public void requestProductSeller(String token, int sellerId) {
        model.requestProductSeller(token, sellerId);
    }

    @Override
    public void populateListProducts(List<Product> listProducts) {
        view.populateListProducts(listProducts);
    }
}
