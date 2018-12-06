package com.example.mrfre.pova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {


    //vars
    ArrayList<String> itemNames = new ArrayList<>();
    ArrayList<Double> prices = new ArrayList<>();
    ArrayList<Integer> quantity = new ArrayList<>();
    ArrayList<String>toppings = new ArrayList<>();
    private String orderList2 = "";
    ArrayList<Items> myOrder = new ArrayList<Items>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        setTitle("CART");

        myOrder = (ArrayList<Items>) CartLogic.myOrder.clone();
        for (Items ob : myOrder)
        {
            itemNames.add(ob.getName());
            toppings.add(ob.getIngredients());
            quantity.add(ob.quantity);
            double totalPrice = ob.quantity * ob.getPrice();
            prices.add(totalPrice);
        }
        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerListView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,itemNames,toppings,quantity,prices);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void checkoutOnClick(View view) {
        Intent i = new Intent(Cart.this, Checkout.class);
        startActivity(i);
        finish();
    }

    public void backToMenu(View view) {
        Intent i = new Intent(this, CarlsJr.class);
        startActivity(i);
        finish();
    }
}
