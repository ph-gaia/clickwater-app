package br.com.clickwater.mvp.payment;

import android.content.Context;

import java.util.List;

import br.com.clickwater.data.model.CreditCard;

public interface PaymentMVP {

    interface View {
        void showToast( String mensagem );
        void popularRecyclerView(List<CreditCard> payments);
    }

    interface Presenter {
        void showToast( String mensagem );
        void setView( PaymentMVP.View view );
        Context getContext();
        void popularRecyclerView(List<CreditCard> payments);
    }

    interface Model {
        void requestPayments(String token);
    }
}
