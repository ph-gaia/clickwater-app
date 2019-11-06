package br.com.clickwater.mvp.payment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.clickwater.R;
import br.com.clickwater.adapter.CreditCardsListAdapter;
import br.com.clickwater.data.model.CreditCard;
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

    @Override
    public void popularRecyclerView(List<CreditCard> payments) {
        CreditCardsListAdapter adapter = new CreditCardsListAdapter(this, payments);
        rclViewPayments.setAdapter(adapter);
        rclViewPayments.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rclViewPayments.setItemAnimator(new DefaultItemAnimator());
    }

    public void addNewPayments(View view) {
        //
    }
}
