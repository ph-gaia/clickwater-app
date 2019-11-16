package br.com.clickwater.mvp.orders;

import android.content.Context;

import java.util.List;

import br.com.clickwater.data.model.Order;

public interface OrdersMVP {

    interface View {
        void showToast( String mensagem );
        void popularRecyclerView(List<Order> orders);
    }

    interface Presenter {
        void showToast( String mensagem );
        void setView( OrdersMVP.View view );
        void popularRecyclerView(List<Order> orders);
        Context getContext();
    }

    interface Model {

    }
}
