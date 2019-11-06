package br.com.clickwater.mvp.orders;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.com.clickwater.R;
import br.com.clickwater.utils.AppPreference;

public class OrdersActivity extends AppCompatActivity implements OrdersMVP.View {

    private static OrdersMVP.Presenter presenter;
    private String token;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        presenter = new OrdersPresenter();
        presenter.setView( this );

        bindView();

        token = AppPreference.getTokenAuth(this);
    }

    private void bindView() {

    }

    @Override
    public void showToast(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }
}
