package br.com.clickwater.mvp.payment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import br.com.clickwater.R;
import br.com.clickwater.utils.AppPreference;

public class PaymentActivity extends AppCompatActivity implements PaymentMVP.View {

    private static PaymentMVP.Presenter presenter;
    private RecyclerView rclViewPayments;
    private String token;
    private Button addAddress;
    Toolbar toolbar;

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
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void showToast(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }

    public void addNewPayments(View view) {
        //
    }
}
