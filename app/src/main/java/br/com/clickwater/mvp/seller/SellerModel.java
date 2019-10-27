package br.com.clickwater.mvp.seller;

import android.util.Log;

import java.util.List;

import br.com.clickwater.data.model.ListProduct;
import br.com.clickwater.data.model.Product;
import br.com.clickwater.data.model.RequestSeller;
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
            Call<RequestSeller> call = ApiManager.get().requestSeller(token);

            call.enqueue(new Callback<RequestSeller>() {
                @Override
                public void onFailure(Call<RequestSeller> call, Throwable t) {
                    t.printStackTrace();
                    presenter.showToast("Erro!" + t.getMessage() );
                }

                @Override
                public void onResponse(Call<RequestSeller> call, Response<RequestSeller> response) {
                    if (response.isSuccessful()) {
                        presenter.popularSellerDetails(response.body().getSeller());
                    } else {
                        presenter.showToast("Erro!" + response.body());
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void requestProductSeller(String token, int sellerId) {
        try {
            Call<ListProduct> call = ApiManager.get().requestProducts(token);

            call.enqueue(new Callback<ListProduct>() {
                @Override
                public void onFailure(Call<ListProduct> call, Throwable t) {
                    t.printStackTrace();
                    presenter.showToast("Erro!" + t.getMessage() );
                }

                @Override
                public void onResponse(Call<ListProduct> call, Response<ListProduct> response) {
                    if (response.isSuccessful()) {
                        List<Product> data = response.body().getData();
                        presenter.populateListProducts(data);
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
