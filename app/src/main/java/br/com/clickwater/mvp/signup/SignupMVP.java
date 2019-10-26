package br.com.clickwater.mvp.signup;

import android.content.Context;

import br.com.clickwater.data.model.RequestUser;

public interface SignupMVP {

    interface View {
        void showSnackbar( String mensagem );
    }

    interface Presenter {
        void setView( SignupMVP.View view );
        void showSnackbar( String mensagem );
        void requestCreateUsers(RequestUser user);
        Context getContext();
    }

    interface Model {
        void requestCreateUsers(RequestUser user);
    }
}
