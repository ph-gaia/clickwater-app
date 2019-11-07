package br.com.clickwater.mvp.newPayment;

import android.content.Context;

import br.com.clickwater.data.model.CreditCard;

public interface NewPaymentMVP {

    interface View {
        void showToast( String mensagem );
    }

    interface Presenter {
        void showToast( String mensagem );
        void setView( NewPaymentMVP.View view );
        Context getContext();
        void requestCreateCreditCard(CreditCard creditCard, String token);
    }

    interface Model {
        void requestCreateCreditCard(CreditCard creditCard, String token);
    }
}
