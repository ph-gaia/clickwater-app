package br.com.clickwater.mvp.orders;

import android.content.Context;

public interface OrdersMVP {

    interface View {
        void showToast( String mensagem );
    }

    interface Presenter {
        void showToast( String mensagem );
        void setView( OrdersMVP.View view );
        Context getContext();
    }

    interface Model {

    }
}
