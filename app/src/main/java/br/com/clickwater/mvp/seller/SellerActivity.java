package br.com.clickwater.mvp.seller;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import br.com.clickwater.R;
import br.com.clickwater.data.model.Seller;
import br.com.clickwater.utils.AppPreference;


public class SellerActivity extends AppCompatActivity implements SellerMVP.View {

    private static SellerMVP.Presenter presenter;
    private ImageView img_seller;
    private TextView txtName, txtAddress;
    private RecyclerView rclViewProducts;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);

        presenter = new SellerPresenter();
        presenter.setView( this );

        bindView();

        token = AppPreference.getTokenAuth(this);
        presenter.requestSellerDetails(token);
    }

    private void bindView() {
        img_seller = findViewById(R.id.img_seller);
        txtName = findViewById(R.id.txtName);
        txtAddress = findViewById(R.id.txtAddress);
        rclViewProducts = findViewById(R.id.recyclerViewProducts);
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
}

