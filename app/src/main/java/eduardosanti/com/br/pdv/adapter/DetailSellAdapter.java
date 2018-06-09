package eduardosanti.com.br.pdv.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import eduardosanti.com.br.pdv.R;
import eduardosanti.com.br.pdv.model.Product;
import eduardosanti.com.br.pdv.util.Util;

public class DetailSellAdapter extends RecyclerView.Adapter<DetailSellAdapter.ViewHolder> {

    private ArrayList<Product> arrayList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewProduct;
        public TextView textViewQuantity;
        public TextView textViewPrice;
        public TextView textViewAmount;

        public ViewHolder(View view) {
            super(view);

            textViewProduct = (TextView) view.findViewById(R.id.textViewProduct);
            textViewQuantity = (TextView) view.findViewById(R.id.textViewQuantity);
            textViewPrice = (TextView) view.findViewById(R.id.textViewPrice);
            textViewAmount = (TextView) view.findViewById(R.id.textViewAmount);
        }
    }

    public DetailSellAdapter(ArrayList<Product> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public DetailSellAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.detail_sell_adapter_layout, parent, false);

        DetailSellAdapter.ViewHolder viewHolder = new DetailSellAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final DetailSellAdapter.ViewHolder holder, final int position) {
        holder.textViewProduct.setText(arrayList.get(position).getName());
        holder.textViewQuantity.setText(String.valueOf(arrayList.get(position).getQuantity()) + "UN");
        holder.textViewPrice.setText(Util.currencyFormat(arrayList.get(position).getPrice()));
        holder.textViewAmount.setText(Util.currencyFormat(arrayList.get(position).getAmount()));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
