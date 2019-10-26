package br.com.clickwater.mvp.payment;

import android.content.Context;

public interface PaymentMVP {

    interface View {
        void showToast( String mensagem );
    }

    interface Presenter {
        void showToast( String mensagem );
        void setView( PaymentMVP.View view );
        Context getContext();
    }

    interface Model {

    }
}
