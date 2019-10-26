package br.com.clickwater.mvp.address;

import android.content.Context;

import java.util.List;

import br.com.clickwater.data.model.Address;

public interface AddressMVP {

    interface View {
        void showToast( String mensagem );
        void popularRecyclerView(List<Address> addresses);
    }

    interface Presenter {
        void showToast( String mensagem );
        void setView( AddressMVP.View view );
        Context getContext();
        void requestAddresses(String token);
        void popularRecyclerView(List<Address> addresses);
    }

    interface Model {
        void requestAddresses(String token);
    }
}
