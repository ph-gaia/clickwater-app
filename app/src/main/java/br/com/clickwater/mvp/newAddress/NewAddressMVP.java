package br.com.clickwater.mvp.newAddress;

import android.content.Context;

import br.com.clickwater.data.model.Address;

public interface NewAddressMVP {

    interface View {
        void showToast( String mensagem );
    }

    interface Presenter {
        void showToast( String mensagem );
        void setView( NewAddressMVP.View view );
        Context getContext();
        void requestCreateNewAddress(Address address, String token);
    }

    interface Model {
        void requestCreateNewAddress(Address address, String token);
    }
}
