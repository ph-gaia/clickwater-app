package br.com.clickwater.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.clickwater.R;
import br.com.clickwater.data.model.CreditCard;

public class CreditCardsListAdapter extends RecyclerView.Adapter<CreditCardsListAdapter.MyViewHolder> {

    Context context;
    private List<CreditCard> cardList;

    public CreditCardsListAdapter(Context context, List<CreditCard> cardList) {
        this.context = context;
        this.cardList = cardList;
    }

    @NonNull
    @Override
    public CreditCardsListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.credit_card_item, parent, false);
        context = parent.getContext();
        return new CreditCardsListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final CreditCard item = cardList.get(position);
        holder.tvEnterprise.setText( item.enterprise );
        holder.tvNumber.setText( item.getNumberAsHidden() );
        holder.tvOwnerName.setText( item.getOwnerFullNameAsHidden() );
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvEnterprise, tvNumber, tvOwnerName;
        Button btRemove;

        public MyViewHolder(View view) {
            super(view);
            tvEnterprise = view.findViewById( R.id.tv_enterprise );
            tvNumber = view.findViewById( R.id.tv_number );
            tvOwnerName= view.findViewById( R.id.tv_owner_name );
            btRemove = itemView.findViewById( R.id.bt_remove );
        }
    }

}
