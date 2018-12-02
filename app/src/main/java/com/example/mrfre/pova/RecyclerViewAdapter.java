package com.example.mrfre.pova;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<String> itemNames = new ArrayList<>();
    private ArrayList<Integer> itemQuantities = new ArrayList<>();
    private ArrayList<Double> prices = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(Context context,ArrayList<String> itemNames, ArrayList<Integer> itemQuantities, ArrayList<Double> prices) {
        this.itemNames = itemNames;
        this.itemQuantities = itemQuantities;
        this.prices = prices;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitems, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.itemName.setText(itemNames.get(i));
        viewHolder.price.setText("$" + Double.toString(prices.get(i)));
        viewHolder.quantity.setText(Integer.toString(itemQuantities.get(i)));
    }

    @Override
    public int getItemCount() {
        return itemNames.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        TextView quantity;
        TextView price;
        RelativeLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = (TextView) itemView.findViewById(R.id.itemName);
            quantity = (TextView) itemView.findViewById(R.id.quantity);
            price = (TextView) itemView.findViewById(R.id.price);
            parentLayout = (RelativeLayout) itemView.findViewById(R.id.parent_layout);
        }
    }
}
