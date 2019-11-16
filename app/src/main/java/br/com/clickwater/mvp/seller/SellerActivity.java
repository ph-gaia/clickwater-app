package br.com.clickwater.mvp.seller;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import java.util.List;

import br.com.clickwater.R;
import br.com.clickwater.adapter.ProductListAdapter;
import br.com.clickwater.data.model.Product;
import br.com.clickwater.data.model.Seller;
import br.com.clickwater.utils.AppPreference;


public class SellerActivity extends AppCompatActivity implements SellerMVP.View, ProductListAdapter.ProductAdapterListener {

    private static SellerMVP.Presenter presenter;
    private ImageView img_seller;
    private TextView txtName, txtAddress;
    private RecyclerView rclViewProducts;
    private String token;
    private Toolbar actionbar;
    private int sellerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);

        presenter = new SellerPresenter();
        presenter.setView( this );

        bindView();

        sellerId = getIntent().getIntExtra("sellerId",1);
        token = AppPreference.getTokenAuth(this);
        presenter.requestSellerDetails(token, sellerId);
        presenter.requestProductSeller(token, sellerId);
    }

    private void bindView() {
        img_seller = findViewById(R.id.img_seller);
        txtName = findViewById(R.id.txtName);
        txtAddress = findViewById(R.id.txtAddress);
        rclViewProducts = findViewById(R.id.recyclerViewProducts);
        actionbar = findViewById(R.id.toolbar);
        if (null != actionbar) {
            actionbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

            actionbar.setTitle(R.string.sellers);
            actionbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    @Override
    public void showToast(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void popularSellerDetails(Seller seller) {
        txtName.setText(seller.name);
        txtAddress.setText(seller.close_time);
        Glide.with(this)
                .load(seller.image_url)
                .centerCrop()
                .placeholder(R.drawable.loading_spinner)
                .into(img_seller);
    }

    @Override
    public void populateListProducts(List<Product> listProducts) {
        ProductListAdapter adapter = new ProductListAdapter(this, listProducts, this);
        rclViewProducts.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(SellerActivity.this,2);
        rclViewProducts.setLayoutManager(layoutManager);
        rclViewProducts.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onProductSelected(Product product) {
        showToast(product.getName());
    }
}

