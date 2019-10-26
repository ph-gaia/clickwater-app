package br.com.clickwater.mvp.signin;

import android.content.Context;

public interface SigninMVP {

    interface View {
        void showSnackbar( String mensagem );
        void showProgressBar( int visibilidade );
        void showButtonLogin( int visibilidade );
        void showTextError( String mensagem );
        void showPasswordTextError( String mensagem );
        void startIntent();
    }

    interface Presenter {
        void showSnackbar( String mensagem );
        void showProgressBar( boolean status );
        void showButtonLogin( boolean visibilidade );
        void singupLogin( String username, String password );
        void setView( SigninMVP.View view );
        Context getContext();
        void startIntent();
    }

    interface Model {
        void requestLogin(String username, String password);
    }

}
