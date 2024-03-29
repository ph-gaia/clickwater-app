package br.com.clickwater.mvp.signin;

import android.content.Context;
import android.view.View;
import br.com.clickwater.R;

public class SigninPresenter implements SigninMVP.Presenter {

    private SigninMVP.Model model;
    private SigninMVP.View view;

    public SigninPresenter() {
        model = new SigninModel( this );
    }

    @Override
    public void showSnackbar(String mensagem) {
        view.showSnackbar(mensagem);
    }

    @Override
    public void showProgressBar(boolean status) {
        int visibilidade = status ? View.VISIBLE : View.GONE;
        view.showProgressBar( visibilidade );
    }

    @Override
    public void showButtonLogin(boolean status) {
        int visibilidade = status ? View.VISIBLE : View.GONE;
        view.showButtonLogin( visibilidade );
    }

    @Override
    public void setView(SigninMVP.View view) {
        this.view = view;
    }

    @Override
    public Context getContext() {
        return (Context) view;
    }

    @Override
    public void singupLogin(String username, String password) {
        if (!username.isEmpty() || !password.isEmpty())
            if (username.length() <= 6)
                view.showTextError(getContext().getString(R.string.email_invalid));
            else if (password.length() <= 6) {
                view.showPasswordTextError(getContext().getString(R.string.password_invalid));
            } else {
                model.requestLogin(username, password);
            }
        else
            view.showTextError(getContext().getString(R.string.field_empty));

    }

    @Override
    public void startIntent() {
        view.startIntent();
    }
}
