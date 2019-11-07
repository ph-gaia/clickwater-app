package br.com.clickwater.mvp.newAddress;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.snackbar.Snackbar;

import br.com.clickwater.R;
import br.com.clickwater.data.model.Address;
import br.com.clickwater.utils.AppPreference;

public class NewAddressActivity extends AppCompatActivity implements NewAddressMVP.View {

    private static NewAddressMVP.Presenter presenter;
    private String token;
    private Button btn_address;
    private CoordinatorLayout coordinatorLayout;
    private EditText et_street, et_number, et_complement, et_zip_code, et_neighborhood, et_city;
    private Spinner sp_state;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_address);

        presenter = new NewAddressPresenter();
        presenter.setView( this );

        bindView();

        token = AppPreference.getTokenAuth(this);
    }

    private void bindView() {
        coordinatorLayout = findViewById(R.id.layout_address);
        btn_address = findViewById(R.id.bt_nu_address);
        et_street = findViewById(R.id.et_street);
        et_number = findViewById(R.id.et_number);
        et_complement = findViewById(R.id.et_complement);
        et_zip_code = findViewById(R.id.et_zip_code);
        et_neighborhood = findViewById(R.id.et_neighborhood);
        et_city = findViewById(R.id.et_city);
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

    public void requestNewAddress(View view) {
        Address address = new Address();
        address.setStreet(et_street.getText().toString());
        address.setNumber(Integer.parseInt(et_number.getText().toString()));
        address.setComplement(et_complement.getText().toString());
        address.setZipCode(et_number.getText().toString());
        address.setNeighborhood(et_neighborhood.getText().toString());
        address.setCity(et_city.getText().toString());

        presenter.requestCreateNewAddress(address, token);
    }

    @Override
    public void showToast(String mensagem) {
        Snackbar snackbar = Snackbar.make(coordinatorLayout, mensagem, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }
}
