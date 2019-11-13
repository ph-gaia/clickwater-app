package br.com.clickwater.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.clickwater.R;
import br.com.clickwater.data.model.Order;


public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.MyViewHolder> {

    Context context;
    private List<Order> OrderList;

    public OrderListAdapter(Context context, List<Order> OrderList) {
        this.OrderList = OrderList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.raw_order_item, parent, false);
        return new OrderListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Order order = OrderList.get(position);
        holder.tv_seller.setText(order.getSeller().name);
        holder.tv_count.setText(String.valueOf(order.getTotal_amount()));
        holder.tv_data.setText(order.getRequest_delivery_time());
        holder.tv_amount.setText(String.valueOf(order.getTotal_amount()));
        holder.tv_address.setText(order.getAddress().getStreet());
        holder.tv_status.setText(order.getStatus());
    }

    @Override
    public int getItemCount() {
        return OrderList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_seller, tv_count, tv_data, tv_amount, tv_address, tv_status;

        public MyViewHolder(View view) {
            super(view);
            tv_seller = view.findViewById(R.id.tv_seller);
            tv_count = view.findViewById(R.id.tv_count);
            tv_data = view.findViewById(R.id.tv_data);
            tv_amount = view.findViewById(R.id.tv_amount);
            tv_address = view.findViewById(R.id.tv_address);
            tv_status = view.findViewById(R.id.tv_status);
        }
    }
}
