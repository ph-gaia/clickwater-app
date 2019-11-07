package br.com.clickwater.mvp.newPayment;

import br.com.clickwater.data.model.CreditCard;
import br.com.clickwater.data.network.ApiManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewPaymentModel implements NewPaymentMVP.Model {

    private NewPaymentMVP.Presenter presenter;

    public NewPaymentModel(NewPaymentMVP.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void requestCreateCreditCard(CreditCard creditCard, String token) {
        try {

            Call<CreditCard> call = ApiManager.get().requestNewCreditCard(token, creditCard);

            call.enqueue(new Callback<CreditCard>() {
                @Override
                public void onFailure(Call<CreditCard> call, Throwable t) {
                    t.printStackTrace();
                    presenter.showToast( t.getMessage() );
                }

                @Override
                public void onResponse(Call<CreditCard> call, Response<CreditCard> response) {
                    presenter.showToast("Adicionado com sucesso!");
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            presenter.showToast( e.getMessage() );
        }
    }
}
