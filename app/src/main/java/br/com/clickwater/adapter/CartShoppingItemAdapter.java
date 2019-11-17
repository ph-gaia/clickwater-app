package br.com.clickwater.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.clickwater.R;
import br.com.clickwater.data.model.Cart;

public class CartShoppingItemAdapter extends RecyclerView.Adapter<CartShoppingItemAdapter.MyViewHolder> {

    Context context;
    private List<Cart> OfferList;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_confirm_order_item, parent,false);
        context = parent.getContext();
        return new CartShoppingItemAdapter.MyViewHolder(itemView);
    }

    public CartShoppingItemAdapter(Context context, List<Cart> offerList) {
        this.context = context;
        OfferList = offerList;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Cart item = OfferList.get(position);

        Glide.with(context)
                .load("")
                .centerCrop()
                .placeholder(R.drawable.loading_spinner)
                .into(holder.image);

        holder.product.setText("");
        holder.quantity.setText("");
        holder.subtotal.setText("");
    }

    @Override
    public int getItemCount() {
        return OfferList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView product, quantity, subtotal;
        public MyViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.icon);
            product = view.findViewById(R.id.product);
            quantity = view.findViewById(R.id.quantity);
            subtotal = view.findViewById(R.id.subtotal);
        }
    }
}
