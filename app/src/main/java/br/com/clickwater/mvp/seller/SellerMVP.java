package br.com.clickwater.mvp.seller;

import android.content.Context;

import br.com.clickwater.data.model.Seller;

public interface SellerMVP {

    interface View {
        void showToast( String mensagem );
        void popularSellerDetails(Seller seller);
    }

    interface Presenter {
        void showToast( String mensagem );
        void setView( SellerMVP.View view );
        Context getContext();
        void popularSellerDetails(Seller seller);
        void requestSellerDetails(String token);
    }


    interface Model {
        void requestSellerDetails(String token);
    }
}
