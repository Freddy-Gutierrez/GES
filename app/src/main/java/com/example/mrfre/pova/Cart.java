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
    private ArrayList<String> itemNames = new ArrayList<>();
    private ArrayList<Double> prices = new ArrayList<>();
    private ArrayList<Integer> quantity = new ArrayList<>();
    private ArrayList<String>toppings = new ArrayList<>();
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        setTitle("CART");


        itemNames.add("Double Western Bacon Cheeseburger®");itemNames.add("burgerTwo");itemNames.add("Burger3");itemNames.add("burger4");
        itemNames.add("Burger5");itemNames.add("burger6");itemNames.add("Burger7");itemNames.add("burger8");
        itemNames.add("Burger9");itemNames.add("burger10");itemNames.add("Burger11");itemNames.add("burger12");

        toppings.add("Cheese,BBQ");toppings.add("");toppings.add("Large");toppings.add("Small");
        toppings.add("BBQ,Cheese,Onion Rings");toppings.add("");toppings.add("");toppings.add("");toppings.add("");
        toppings.add("");toppings.add("");toppings.add("");toppings.add("");toppings.add("");

        prices.add(2.56);prices.add(6.45);prices.add(2.34);prices.add(9.78);
        prices.add(10.23);prices.add(11.00);prices.add(12.34);prices.add(19.56);
        prices.add(2.56);prices.add(2.33);prices.add(86.34);prices.add(100.23);

        quantity.add(2);quantity.add(4);quantity.add(3);quantity.add(12);
        quantity.add(122);quantity.add(98);quantity.add(35);quantity.add(43);
        quantity.add(3);quantity.add(67);quantity.add(6);quantity.add(33);

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

}
