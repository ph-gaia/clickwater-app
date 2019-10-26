package br.com.clickwater.mvp.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import java.util.List;
import br.com.clickwater.R;
import br.com.clickwater.adapter.HomePopularAdapter;
import br.com.clickwater.data.model.Seller;
import br.com.clickwater.utils.AppPreference;


public class HomeActivity extends AppCompatActivity implements HomeMVP.View {

    private static HomeMVP.Presenter presenter;
    private RecyclerView rclViewPopular, rclViewOffers, rclViewNews;
    private CoordinatorLayout coordinatorLayout;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        presenter = new HomePresenter();
        presenter.setView( this );
        bindView();

        token = AppPreference.getTokenAuth(this);

        presenter.requestNews(token);
        presenter.requestOffers(token);
        presenter.requestPopular(token);
    }

    private void bindView() {
        coordinatorLayout = findViewById(R.id.layoutLogin);
        rclViewPopular = findViewById(R.id.RecyclerViewPopular);
        rclViewNews = findViewById(R.id.RecyclerViewNews);
        rclViewOffers = findViewById(R.id.RecyclerViewOffers);
    }

    @Override
    public void showSnackbar(String mensagem) {
        Snackbar snackbar = Snackbar.make(coordinatorLayout, mensagem, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    @Override
    public void popularRecyclerView(List<Seller> popular) {
        HomePopularAdapter adapter = new HomePopularAdapter(this, popular);
        rclViewPopular.setAdapter(adapter);
    }

    @Override
    public void offersRecyclerView(List<Seller> popular) {
        HomePopularAdapter adapter = new HomePopularAdapter(this, popular);
        rclViewOffers.setAdapter(adapter);
    }

    @Override
    public void newsRecyclerView(List<Seller> popular) {
        HomePopularAdapter adapter = new HomePopularAdapter(this, popular);
        rclViewNews.setAdapter(adapter);
    }
}
