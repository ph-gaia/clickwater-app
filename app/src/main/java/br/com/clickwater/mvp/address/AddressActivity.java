package br.com.clickwater.mvp.address;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.clickwater.R;
import br.com.clickwater.adapter.AddressesListAdapter;
import br.com.clickwater.data.model.Address;
import br.com.clickwater.mvp.newAddress.NewAddressActivity;
import br.com.clickwater.utils.AppPreference;


public class AddressActivity extends AppCompatActivity implements AddressMVP.View {

    private static AddressMVP.Presenter presenter;
    private RecyclerView rclViewAddress;
    Toolbar toolbar;
    private String token;
    private Button addAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_list);

        presenter = new AddressPresenter();
        presenter.setView( this );

        bindView();

        token = AppPreference.getTokenAuth(this);
        presenter.requestAddresses(token);
    }

    private void bindView() {
        rclViewAddress = findViewById(R.id.recyclerViewAddress);
        addAddress = findViewById(R.id.add_new_address);
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
    public void popularRecyclerView(List<Address> addresses) {
        AddressesListAdapter adapter = new AddressesListAdapter(this, addresses);
        rclViewAddress.setAdapter(adapter);
        rclViewAddress.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rclViewAddress.setItemAnimator(new DefaultItemAnimator());
    }

    public void addNewAddress(View view) {
        Intent intent = new Intent(getApplicationContext(), NewAddressActivity.class);
        startActivity(intent);
    }
}
