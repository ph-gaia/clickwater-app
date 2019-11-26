package br.com.clickwater.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.clickwater.R;
import br.com.clickwater.data.model.Cart;
import br.com.clickwater.data.model.ItemCart;
import br.com.clickwater.data.model.Product;
import br.com.clickwater.utils.ShopCart;


public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.MyViewHolder> {

    Context context;
    private List<Product> ProductList;
    int myPos = 0;
    Cart cart = new Cart();
    private ProductListAdapter.ProductAdapterListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;
        LinearLayout linear;
        EditText et_quantity;
        TextView price;
        Button btnPlus, btnLess;

        public MyViewHolder(View view) {
            super(view);

            image = view.findViewById(R.id.image);
            title = view.findViewById(R.id.title);
            linear = view.findViewById(R.id.linear);
            price = view.findViewById(R.id.price);
            btnLess = view.findViewById(R.id.btnLess);
            btnPlus = view.findViewById(R.id.btnPlus);
            et_quantity = view.findViewById(R.id.et_quantity);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onProductSelected(ProductList.get(getAdapterPosition()));
                }
            });
        }
    }

    public ProductListAdapter(Context context, List<Product> ProductList, ProductAdapterListener listener) {
        this.ProductList = ProductList;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public ProductListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.raw_product_seller, parent, false);
        return new ProductListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final Product product = ProductList.get(position);
        ItemCart item = new ItemCart();

        int count = Integer.parseInt(holder.et_quantity.getText().toString());

        Glide.with(context)
                .load(product.getImage_url())
                .centerCrop()
                .placeholder(R.drawable.loading_spinner)
                .into(holder.image);
        holder.title.setText(product.getName());
        holder.price.setText(String.valueOf(product.getPrice()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myPos = position;
                notifyDataSetChanged();
            }
        });

        holder.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(holder.et_quantity.getText().toString());
                String counter = String.valueOf(count + 1);
                holder.et_quantity.setText(counter);

            }
        });

        holder.btnLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(holder.et_quantity.getText().toString());
                String counter = String.valueOf(count - 1);
                holder.et_quantity.setText(counter);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ProductList.size();
    }

    public interface ProductAdapterListener {
        void onProductSelected(Product product);
    }
}


