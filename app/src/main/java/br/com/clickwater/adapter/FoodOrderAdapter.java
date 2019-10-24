package br.com.clickwater.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import br.com.clickwater.mvp.BookOrderActivity;
import br.com.clickwater.mvp.home.HomeActivity;
import br.com.clickwater.R;
import br.com.clickwater.mvp.ReviewActivity;
import br.com.clickwater.mvp.splash.SplashActivity;
import br.com.clickwater.data.model.Food;


public class FoodOrderAdapter extends RecyclerView.Adapter<FoodOrderAdapter.MyViewHolder> {

    Context context;
    private List<Food> OfferList;
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
        }
    }

    public FoodOrderAdapter(Context context, List<Food> offerList) {
        this.OfferList = offerList;
        this.context = context;
    }

    @Override
    public FoodOrderAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.raw_food_order, parent, false);
        return new FoodOrderAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Food lists = OfferList.get(position);
        holder.title.setText(lists.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (position == 0) {
                    Intent i = new Intent(context, SplashActivity.class);
                    context.startActivity(i);
                    ((Activity)context).finish();
                }else if (position == 1) {
                    Intent i = new Intent(context, HomeActivity.class);
                    context.startActivity(i);
                }else if (position ==2){
                    Intent i = new Intent(context, BookOrderActivity.class);
                    context.startActivity(i);
                }else if (position ==5){
                    Intent i = new Intent(context, ReviewActivity.class);
                    context.startActivity(i);
                }
            }

        });

    }

    @Override
    public int getItemCount() {
        return OfferList.size();
    }

}


