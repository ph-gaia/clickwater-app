package br.com.clickwater.mvp.payment;

import br.com.clickwater.data.model.CreditCardList;
import br.com.clickwater.data.network.ApiManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentModel implements PaymentMVP.Model {

    private PaymentMVP.Presenter presenter;

    public PaymentModel(PaymentMVP.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void requestPayments(String token) {
        try {
            Call<CreditCardList> call = ApiManager.get().requestPayments("Bearer " + token);

            call.enqueue(new Callback<CreditCardList>() {
                @Override
                public void onFailure(Call<CreditCardList> call, Throwable t) {
                    t.printStackTrace();
                    presenter.showToast("Erro!" + t.getMessage() );
                }

                @Override
                public void onResponse(Call<CreditCardList> call, Response<CreditCardList> response) {
                    if (response.isSuccessful()) {
                        CreditCardList resource = response.body();
                        assert resource != null;
                        presenter.popularRecyclerView(resource.data);
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
