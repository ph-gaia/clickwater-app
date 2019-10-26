package br.com.clickwater.mvp.seller;

import br.com.clickwater.data.model.Seller;
import br.com.clickwater.data.network.ApiManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SellerModel implements SellerMVP.Model {

    private SellerMVP.Presenter presenter;

    public SellerModel(SellerMVP.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void requestSellerDetails(String token) {
        try {
            Call<Seller> call = ApiManager.get().requestSeller(token);

            call.enqueue(new Callback<Seller>() {
                @Override
                public void onFailure(Call<Seller> call, Throwable t) {
                    t.printStackTrace();
                    presenter.showToast("Erro!" + t.getMessage() );
                }

                @Override
                public void onResponse(Call<Seller> call, Response<Seller> response) {
                    if (response.isSuccessful()) {
                        presenter.popularSellerDetails(response.body());
                    } else {
                        presenter.showToast("Erro!" + response.body());
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
