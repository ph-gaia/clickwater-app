package br.com.clickwater.mvp.seller;

import android.content.Context;

import java.util.List;

import br.com.clickwater.data.model.ListProduct;
import br.com.clickwater.data.model.Product;
import br.com.clickwater.data.model.Seller;

public interface SellerMVP {

    interface View {
        void showToast( String mensagem );
        void popularSellerDetails(Seller seller);
        void populateListProducts(List<Product> listProducts);
    }

    interface Presenter {
        void showToast( String mensagem );
        void setView( SellerMVP.View view );
        Context getContext();
        void popularSellerDetails(Seller seller);
        void requestSellerDetails(String token, int sellerId);
        void requestProductSeller(String token, int sellerId);
        void populateListProducts(List<Product> listProducts);
    }


    interface Model {
        void requestSellerDetails(String token, int sellerId);
        void requestProductSeller(String token, int sellerId);
    }
}
