package br.com.clickwater.mvp.signup;

import android.content.Context;
import android.util.Patterns;

import br.com.clickwater.R;
import br.com.clickwater.data.model.RequestUser;

public class SignupPresenter implements SignupMVP.Presenter {

    private SignupMVP.Model model;
    private SignupMVP.View view;

    public SignupPresenter() {
        model = new SignupModel( this );
    }

    @Override
    public void setView(SignupMVP.View view) {
        this.view = view;
    }

    @Override
    public void showSnackbar(String mensagem) {
        view.showSnackbar(mensagem);
    }

    @Override
    public void requestCreateUsers(RequestUser user) {

        if(user.getName().isEmpty()) {
            view.showSnackbar(getContext().getString(R.string.name_invalid));
        } else if (!Patterns.EMAIL_ADDRESS.matcher(user.getEmail()).matches()) {
            view.showSnackbar(getContext().getString(R.string.email_invalid));
        } else if (user.getPassword().length() <= 6) {
            view.showSnackbar(getContext().getString(R.string.password_invalid));
        }

        model.requestCreateUsers(user);
    }

    @Override
    public Context getContext() {
        return (Context) view;
    }
}
