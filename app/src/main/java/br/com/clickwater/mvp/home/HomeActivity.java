package br.com.clickwater.mvp.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import br.com.clickwater.R;
import br.com.clickwater.adapter.HomePopularAdapter;
import br.com.clickwater.data.model.Seller;
import br.com.clickwater.mvp.address.AddressActivity;
import br.com.clickwater.mvp.orders.OrdersActivity;
import br.com.clickwater.mvp.payment.PaymentActivity;
import br.com.clickwater.mvp.seller.SellerActivity;
import br.com.clickwater.utils.AppPreference;


public class HomeActivity extends AppCompatActivity implements HomeMVP.View, HomePopularAdapter.SellerAdapterListener {

    private static HomeMVP.Presenter presenter;
    private RecyclerView rclViewPopular, rclViewOffers, rclViewNews;
    private CoordinatorLayout coordinatorLayout;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigator;
    Toolbar actionbar;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        presenter = new HomePresenter();
        presenter.setView(this);
        bindView();

        token = AppPreference.getTokenAuth(this);

        presenter.requestNews(token);
        presenter.requestOffers(token);
        presenter.requestPopular(token);
    }

    private void bindView() {
        actionbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.activity_main);
        navigator = findViewById(R.id.navigator);
        coordinatorLayout = findViewById(R.id.layoutHome);
        rclViewPopular = findViewById(R.id.RecyclerViewPopular);
        rclViewNews = findViewById(R.id.RecyclerViewNews);
        rclViewOffers = findViewById(R.id.RecyclerViewOffers);

        if (null != actionbar) {
            setSupportActionBar(actionbar);
            actionbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);

            actionbar.setTitle(R.string.app_name);

        }

        navigator.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.nav_orders:
                        startActivity(new Intent(getApplicationContext(), OrdersActivity.class));
                        break;
                    case R.id.nav_payments:
                        startActivity(new Intent(getApplicationContext(), PaymentActivity.class));
                        break;
                    case R.id.nav_address:
                        startActivity(new Intent(getApplicationContext(), AddressActivity.class));
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });
    }

    @Override
    public void showSnackbar(String mensagem) {
        Snackbar snackbar = Snackbar.make(coordinatorLayout, mensagem, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    @Override
    public void popularRecyclerView(List<Seller> popular) {
        HomePopularAdapter adapter = new HomePopularAdapter(this, popular, this);
        rclViewPopular.setAdapter(adapter);
        rclViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rclViewPopular.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void offersRecyclerView(List<Seller> popular) {
        HomePopularAdapter adapter = new HomePopularAdapter(this, popular, this);
        rclViewOffers.setAdapter(adapter);
        rclViewOffers.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rclViewOffers.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void newsRecyclerView(List<Seller> popular) {
        HomePopularAdapter adapter = new HomePopularAdapter(this, popular, this);
        rclViewNews.setAdapter(adapter);
        rclViewNews.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rclViewNews.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onSellerSelected(Seller seller) {
        Intent i = new Intent(getApplicationContext(), SellerActivity.class);
        i.putExtra("sellerId", seller.getId());
        startActivity(i);
    }
}
