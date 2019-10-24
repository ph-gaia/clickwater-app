package br.com.clickwater.mvp.home;

import android.content.Context;

import java.util.List;

import br.com.clickwater.data.model.Seller;

public interface HomeMVP {

    interface View {
        void showSnackbar( String mensagem );
        void popularRecyclerView(final List<Seller> popular);
        void offersRecyclerView(final List<Seller> popular);
        void newsRecyclerView(final List<Seller> popular);
    }

    interface Presenter {
        void showSnackbar( String mensagem );
        void setView( HomeMVP.View view );
        Context getContext();
        void popularRecyclerView(List<Seller> popular);
        void offersRecyclerView(List<Seller> popular);
        void newsRecyclerView(List<Seller> popular);
        void requestPopular(String token);
        void requestNews(String token);
        void requestOffers(String token);
    }

    interface Model {
        void requestPopular(String token);
        void requestNews(String token);
        void requestOffers(String token);
    }

}
