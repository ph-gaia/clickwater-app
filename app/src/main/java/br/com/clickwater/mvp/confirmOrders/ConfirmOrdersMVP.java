package br.com.clickwater.mvp.confirmOrders;

import android.content.Context;

public interface ConfirmOrdersMVP {

    interface View {
        void showSnackbar( String mensagem );
    }

    interface Presenter {
        void showSnackbar(String mensagem);

        void setView(ConfirmOrdersMVP.View view);

        Context getContext();
    }
}
