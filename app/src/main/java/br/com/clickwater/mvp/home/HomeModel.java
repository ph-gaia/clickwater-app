package br.com.clickwater.mvp.home;

import br.com.clickwater.data.model.DepositHome;
import br.com.clickwater.data.model.Seller;
import br.com.clickwater.data.network.ApiManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeModel implements HomeMVP.Model {

    private HomeMVP.Presenter presenter;

    public HomeModel(HomeMVP.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void requestPopular(String token) {
        try {
            Call<DepositHome> call = ApiManager.get().requestPopular(token);

            call.enqueue(new Callback<DepositHome>() {
                @Override
                public void onFailure(Call<DepositHome> call, Throwable t) {
                    t.printStackTrace();
                    presenter.showSnackbar("Erro!" + t.getMessage() );
                }

                @Override
                public void onResponse(Call<DepositHome> call, Response<DepositHome> response) {
                    if (response.isSuccessful()) {
                        DepositHome resource = response.body();
                        presenter.popularRecyclerView(resource.data);
                    } else {
                        presenter.showSnackbar("Erro!" + response.body());
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void requestNews(String token) {
        try {
            Call<DepositHome> call = ApiManager.get().requestNews(token);

            call.enqueue(new Callback<DepositHome>() {
                @Override
                public void onFailure(Call<DepositHome> call, Throwable t) {
                    t.printStackTrace();
                    presenter.showSnackbar("Erro!" + t.getMessage() );
                }

                @Override
                public void onResponse(Call<DepositHome> call, Response<DepositHome> response) {
                    if (response.isSuccessful()) {
                        DepositHome resource = response.body();
                        presenter.newsRecyclerView(resource.data);
                    } else {
                        presenter.showSnackbar("Erro!" + response.body());
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void requestOffers(String token) {
        try {
            Call<DepositHome> call = ApiManager.get().requestOffers(token);

            call.enqueue(new Callback<DepositHome>() {
                @Override
                public void onFailure(Call<DepositHome> call, Throwable t) {
                    t.printStackTrace();
                    presenter.showSnackbar("Erro!" + t.getMessage() );
                }

                @Override
                public void onResponse(Call<DepositHome> call, Response<DepositHome> response) {
                    if (response.isSuccessful()) {
                        DepositHome resource = response.body();
                        presenter.offersRecyclerView(resource.data);
                    } else {
                        presenter.showSnackbar("Erro!" + response.body());
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
