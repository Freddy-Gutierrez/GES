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
    public static ArrayList<String> itemNames = new ArrayList<>();
    public static ArrayList<Double> prices = new ArrayList<>();
    public static ArrayList<Integer> quantity = new ArrayList<>();
    public static ArrayList<String>toppings = new ArrayList<>();
    public static double total = 0.0;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        setTitle("CART");


        itemNames.add("Double Western Bacon Cheeseburger®");itemNames.add("burgerTwo");itemNames.add("Burger3");itemNames.add("burger4");

        toppings.add("Cheese,BBQ");toppings.add("");toppings.add("Large");toppings.add("Small");

        prices.add(2.56);prices.add(6.45);prices.add(2.34);prices.add(9.78);

        quantity.add(2);quantity.add(4);quantity.add(3);quantity.add(12);

        initRecyclerView();
        calculateTotal();

    }

    private void calculateTotal() {
        for(int i = 0; i < prices.size(); i++){
            total += prices.get(i);
        }
        total = Math.round(total*100.0)/100.0;
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

}
