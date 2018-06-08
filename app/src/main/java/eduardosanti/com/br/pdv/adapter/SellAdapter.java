package eduardosanti.com.br.pdv.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import eduardosanti.com.br.pdv.R;
import eduardosanti.com.br.pdv.model.Sell;

public class SellAdapter extends RecyclerView.Adapter<SellAdapter.ViewHolder> {

    public interface SellOnClickListener {
        public void onClick(View view, int position);
    }

    private ArrayList<Sell> arrayList;
    public SellOnClickListener sellOnClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewBuyer;
        public TextView textViewQuantity;

        public ViewHolder(View view) {
            super(view);

            textViewBuyer = (TextView) view.findViewById(R.id.textViewBuyer);
            textViewQuantity = (TextView) view.findViewById(R.id.textViewQuantity);
        }

    }

    public SellAdapter(ArrayList<Sell> arrayList, SellOnClickListener sellOnClickListener) {
        this.arrayList = arrayList;
        this.sellOnClickListener = sellOnClickListener;
    }

    @Override
    public SellAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sell_adapter_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.textViewBuyer.setText(arrayList.get(position).getUser().getEmail());
        holder.textViewQuantity.setText(String.valueOf(arrayList.get(position).getProducts().size()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sellOnClickListener.onClick(holder.itemView, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}
