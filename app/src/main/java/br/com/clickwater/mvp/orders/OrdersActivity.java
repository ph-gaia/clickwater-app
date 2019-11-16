package br.com.clickwater.mvp.orders;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.clickwater.R;
import br.com.clickwater.adapter.OrderListAdapter;
import br.com.clickwater.data.model.Order;
import br.com.clickwater.utils.AppPreference;

public class OrdersActivity extends AppCompatActivity implements OrdersMVP.View {

    private static OrdersMVP.Presenter presenter;
    private String token;
    private RecyclerView rclOrders;
    Toolbar toolbar;

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
        rclOrders = findViewById(R.id.recyclerViewOrders);
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
    public void popularRecyclerView(List<Order> orders) {
        OrderListAdapter adapter = new OrderListAdapter(this, orders);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rclOrders.setLayoutManager(llm);
        rclOrders.setItemAnimator(new DefaultItemAnimator());
        rclOrders.setAdapter(adapter);
    }
}
