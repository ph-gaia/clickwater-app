package br.com.clickwater.mvp.newAddress;

import br.com.clickwater.data.model.Address;
import br.com.clickwater.data.network.ApiManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewAddressModel implements NewAddressMVP.Model {

    private NewAddressMVP.Presenter presenter;

    public NewAddressModel(NewAddressMVP.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void requestCreateNewAddress(Address address) {
        try {

            Call<Address> call = ApiManager.get().requestNewAddress(address);

            call.enqueue(new Callback<Address>() {
                @Override
                public void onFailure(Call<Address> call, Throwable t) {
                    t.printStackTrace();
                    presenter.showToast( t.getMessage() );
                }

                @Override
                public void onResponse(Call<Address> call, Response<Address> response) {

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            presenter.showToast( e.getMessage() );
        }
    }
}
