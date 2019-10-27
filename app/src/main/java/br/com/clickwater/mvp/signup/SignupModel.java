package br.com.clickwater.mvp.signup;

import android.util.Log;

import br.com.clickwater.data.model.Address;
import br.com.clickwater.data.model.RequestUser;
import br.com.clickwater.data.network.ApiManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupModel implements SignupMVP.Model {

    private SignupMVP.Presenter presenter;

    public SignupModel(SignupMVP.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void requestCreateUsers(RequestUser user) {
        try {

            Call<RequestUser> call = ApiManager.get().requestCreateUsers(user);

            call.enqueue(new Callback<RequestUser>() {
                @Override
                public void onFailure(Call<RequestUser> call, Throwable t) {
                    t.printStackTrace();
                    presenter.showSnackbar( t.getMessage() );
                }

                @Override
                public void onResponse(Call<RequestUser> call, Response<RequestUser> response) {
                    Log.i("INFO", "data: " + response.body());
                    presenter.showSnackbar("Usuário inserido com sucesso");
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            presenter.showSnackbar( e.getMessage() );
        }
    }
}
