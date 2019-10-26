package br.com.clickwater.mvp.payment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import br.com.clickwater.R;
import br.com.clickwater.utils.AppPreference;

public class PaymentActivity extends AppCompatActivity implements PaymentMVP.View {

    private static PaymentMVP.Presenter presenter;
    private RecyclerView rclViewPayments;
    private String token;
    private Button addAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments_list);

        presenter = new PaymentPresenter();
        presenter.setView( this );

        bindView();

        token = AppPreference.getTokenAuth(this);
    }

    private void bindView() {
        rclViewPayments = findViewById(R.id.recyclerViewPayments);
        addAddress = findViewById(R.id.add_new_payments);
    }

    @Override
    public void showToast(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }
}
