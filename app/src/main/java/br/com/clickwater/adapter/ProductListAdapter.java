package br.com.clickwater.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.clickwater.R;
import br.com.clickwater.data.model.Product;


public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.MyViewHolder> {

    Context context;
    private List<Product> ProductList;
    int myPos = 0;
    private ProductListAdapter.ProductAdapterListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;
        LinearLayout linear;

        public MyViewHolder(View view) {
            super(view);

            image = view.findViewById(R.id.image);
            title = view.findViewById(R.id.title);
            linear = view.findViewById(R.id.linear);

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
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final Product lists = ProductList.get(position);

        Glide.with(context)
                .load(lists.getImage_url())
                .centerCrop()
                .placeholder(R.drawable.loading_spinner)
                .into(holder.image);
        holder.title.setText(lists.getName());

        if (myPos == position) {
            holder.title.setTextColor(Color.parseColor("#000000"));
            holder.linear.setBackgroundResource(R.drawable.ic_selector_1);
        } else {
            holder.title.setTextColor(Color.parseColor("#484646"));
            holder.linear.setBackgroundResource(R.drawable.ic_selector_2);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myPos = position;
                notifyDataSetChanged();
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


