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
import br.com.clickwater.data.model.Seller;

public class HomePopularAdapter extends RecyclerView.Adapter<HomePopularAdapter.MyViewHolder> {

    Context context;
    private List<Seller> OfferList;
    private HomePopularAdapter.SellerAdapterListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, address;
        public MyViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.image);
            title = view.findViewById(R.id.title);
            address = view.findViewById(R.id.txtAddress);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onSellerSelected(OfferList.get(getAdapterPosition()));
                }
            });
        }
    }

    public HomePopularAdapter(Context context, List<Seller> offerList, SellerAdapterListener listener) {
        this.OfferList = offerList;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public HomePopularAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_home_popular, parent,false);
        context = parent.getContext();
        return new HomePopularAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final Seller lists = OfferList.get(position);

        Glide.with(context)
            .load(lists.image_url)
            .centerCrop()
            .placeholder(R.drawable.loading_spinner)
            .into(holder.image);

        holder.title.setText(lists.name);
        holder.address.setText("Travessa Manoel Evaristo, 1040 - Umarizal");
    }

    @Override
    public int getItemCount() {
        return OfferList.size();
    }

    public interface SellerAdapterListener {
        void onSellerSelected(Seller seller);
    }

}


