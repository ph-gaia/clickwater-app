package br.com.clickwater.mvp.home;

import android.content.Context;
import java.util.List;
import br.com.clickwater.data.model.Seller;

public class HomePresenter implements HomeMVP.Presenter {

    private HomeMVP.Model model;
    private HomeMVP.View view;

    public HomePresenter() {
        model = new HomeModel( this );
    }

    @Override
    public void showSnackbar(String mensagem) {
        view.showSnackbar(mensagem);
    }

    @Override
    public void setView(HomeMVP.View view) {
        this.view = view;
    }

    @Override
    public Context getContext() {
        return (Context) view;
    }

    @Override
    public void popularRecyclerView(List<Seller> popular) {
        view.popularRecyclerView(popular);
    }

    @Override
    public void offersRecyclerView(List<Seller> popular) {
        view.offersRecyclerView(popular);
    }

    @Override
    public void newsRecyclerView(List<Seller> popular) {
        view.newsRecyclerView(popular);
    }

    @Override
    public void requestPopular(String token) {
        model.requestPopular(token);
    }

    @Override
    public void requestNews(String token) {
        model.requestNews(token);
    }

    @Override
    public void requestOffers(String token) {
        model.requestOffers(token);
    }


}
