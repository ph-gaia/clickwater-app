package br.com.clickwater.mvp.payment;

import android.content.Intent;
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
import br.com.clickwater.mvp.newPayment.NewPaymentActivity;
import br.com.clickwater.utils.AppPreference;

public class PaymentActivity extends AppCompatActivity implements PaymentMVP.View, CreditCardsListAdapter.PaymentsAdapterListener {

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
        presenter.requestPayments(token);
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
        CreditCardsListAdapter adapter = new CreditCardsListAdapter(this, payments, this);

        rclViewPayments.setLayoutManager(new LinearLayoutManager(this));
        rclViewPayments.setItemAnimator(new DefaultItemAnimator());
        rclViewPayments.setAdapter(adapter);
    }

    public void addNewPayments(View view) {
        startActivity(new Intent(getApplicationContext(), NewPaymentActivity.class));
    }

    @Override
    public void onPaymentsSelected(CreditCard card) {
        showToast(card.getNumber());
    }
}
