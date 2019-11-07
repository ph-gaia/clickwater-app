package br.com.clickwater.mvp.newPayment;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.snackbar.Snackbar;

import br.com.clickwater.R;
import br.com.clickwater.data.model.CreditCard;
import br.com.clickwater.utils.AppPreference;

public class NewPaymentActivity extends AppCompatActivity implements NewPaymentMVP.View {

    private static NewPaymentMVP.Presenter presenter;
    private String token;
    private CoordinatorLayout coordinatorLayout;
    Spinner card_enterprise, card_expiry_month;
    EditText card_owner_name, card_owner_reg, card_security_code, card_expiry_year, card_number;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_credit_card);

        presenter = new NewPaymentPresenter();
        presenter.setView( this );

        bindView();

        token = AppPreference.getTokenAuth(this);
    }

    private void bindView() {
        toolbar = findViewById(R.id.toolbar);
        coordinatorLayout = findViewById(R.id.layout_credit_card);
        card_number = findViewById(R.id.met_credit_card_number);
        card_enterprise = findViewById(R.id.sp_credit_card_enterprise);
        card_owner_name = findViewById(R.id.et_credit_card_owner_name);
        card_owner_reg = findViewById(R.id.met_credit_card_owner_reg);
        card_expiry_month = findViewById(R.id.sp_credit_card_expiry_month);
        card_expiry_year = findViewById(R.id.et_credit_card_expiry_year);
        card_security_code = findViewById(R.id.et_credit_card_security_code);

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
        Snackbar snackbar = Snackbar.make(coordinatorLayout, mensagem, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    public void addNewCard(View view) {
        CreditCard card = new CreditCard();
        card.setNumber(card_number.getText().toString().trim());
        card.setEnterprise(card_enterprise.getSelectedItem().toString());
        card.setOwnerFullName(card_owner_name.getText().toString());
        card.setOwnerRegNumber(card_owner_reg.getText().toString());
        card.setExpiryMonth(Integer.parseInt(card_expiry_month.getSelectedItem().toString()));
        card.setExpiryYear(Integer.parseInt(card_expiry_year.getText().toString()));
        card.setSecurityNumber(card_security_code.getText().toString());

        presenter.requestCreateCreditCard(card, token);
    }
}
