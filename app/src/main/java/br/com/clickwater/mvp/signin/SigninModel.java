package br.com.clickwater.mvp.signin;

import br.com.clickwater.data.model.Login;
import br.com.clickwater.data.model.RequestLogin;
import br.com.clickwater.data.model.User;
import br.com.clickwater.data.network.ApiManager;
import br.com.clickwater.utils.AppPreference;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SigninModel implements SigninMVP.Model {

    private SigninMVP.Presenter presenter;

    public SigninModel(SigninMVP.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void requestLogin(String username, String password) {
        try {
            presenter.showProgressBar(true);
            presenter.showButtonLogin(false);

            Call<Login> call = ApiManager.get().requestLogin(new RequestLogin(username, password));

            call.enqueue(new Callback<Login>() {
                @Override
                public void onFailure(Call<Login> call, Throwable t) {
                    t.printStackTrace();
                    presenter.showProgressBar(false);
                    presenter.showButtonLogin(true);
                    presenter.showSnackbar( t.getMessage() );
                }

                @Override
                public void onResponse(Call<Login> call, Response<Login> response) {
                    User user = response.body().getUser();

                    saveTokenAndEmailUser(user);

                    presenter.showProgressBar(false);
                    presenter.showButtonLogin(true);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            presenter.showProgressBar(false);
            presenter.showButtonLogin(true);
        }
    }

    private void saveTokenAndEmailUser(User user) {
        AppPreference.setSaveUser(presenter.getContext(), user);
        presenter.startIntent();
    }
}
