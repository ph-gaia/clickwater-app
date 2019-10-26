package br.com.clickwater.mvp.address;

import br.com.clickwater.data.model.AddressList;
import br.com.clickwater.data.network.ApiManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddressModel implements AddressMVP.Model {

    private AddressMVP.Presenter presenter;

    public AddressModel(AddressMVP.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void requestAddresses(String token) {
        try {
            Call<AddressList> call = ApiManager.get().requestAddress(token);

            call.enqueue(new Callback<AddressList>() {
                @Override
                public void onFailure(Call<AddressList> call, Throwable t) {
                    t.printStackTrace();
                    presenter.showToast("Erro!" + t.getMessage() );
                }

                @Override
                public void onResponse(Call<AddressList> call, Response<AddressList> response) {
                    if (response.isSuccessful()) {
                        AddressList resource = response.body();
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
