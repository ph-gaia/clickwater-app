package br.com.clickwater.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.clickwater.R;
import br.com.clickwater.data.model.Address;

public class AddressesListAdapter extends RecyclerView.Adapter<AddressesListAdapter.MyViewHolder> {

    Context context;
    private List<Address> OfferList;

    public AddressesListAdapter(Context context, List<Address> offerList) {
        this.context = context;
        OfferList = offerList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_address_item, parent,false);
        context = parent.getContext();
        return new AddressesListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Address item = OfferList.get(position);
        holder.tvStreet.setText( item.street );
        holder.tvNumber.setText( item.number.toString() );
        holder.tvZipCode.setText( item.zipCode );
        holder.tvNeighborhood.setText( item.neighborhood );
        holder.tvCity.setText( item.city );
        holder.tvState.setText( item.getStateName(context) );
        holder.tvComplement.setText( item.complement );
    }

    @Override
    public int getItemCount() {
        return OfferList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView tvStreet, tvNumber, tvZipCode, tvNeighborhood, tvCity, tvState, tvComplement, btUpdate, btRemove;
        public MyViewHolder(View view) {
            super(view);
            tvStreet = view.findViewById( R.id.tv_street );
            tvNumber = view.findViewById( R.id.tv_number );
            tvZipCode = view.findViewById( R.id.tv_zip_code );
            tvNeighborhood = view.findViewById( R.id.tv_neighborhood );
            tvCity = view.findViewById( R.id.tv_city );
            tvState = view.findViewById( R.id.tv_state );
            tvComplement = view.findViewById( R.id.tv_complement );

            btUpdate = itemView.findViewById( R.id.bt_update );
            // btUpdate.setOnClickListener( this );

            btRemove = itemView.findViewById( R.id.bt_remove );
            // btRemove.setOnClickListener( this );
        }
    }
}
