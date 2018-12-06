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
    static ArrayList<Items> myOrder = new ArrayList<Items>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        setTitle("CART");


        Intent i = getIntent();
        orderList2 = i.getStringExtra("orderList");
        checkList(myOrder, orderList2);

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

    //checks for dups, if there is a dup qty is incremented by 1, if not new item is added
    public static void checkList(ArrayList<Items> myOrder, String order)
    {
        //Temporary declarations
        boolean isSame = false;
        Items dummyOrder = new Items();
        dummyOrder.addItem(order);

        //Empty List
        if (myOrder.size() == 0)
        {
            isSame= true;
            dummyOrder.quantity += 1;
            myOrder.add(dummyOrder);
        }

        //Non Empty List checks for duplicate
        else
        {
            for(Items obj : myOrder)
            {
                if (dummyOrder.name.equals(obj.name) && dummyOrder.ingredients.equals(obj.ingredients))
                {
                    isSame = true;
                    obj.quantity += 1;
                }
            }
        }

        //Adds to list if duplicate does not exist
        if (isSame == false)
        {
            dummyOrder.quantity += 1;
            myOrder.add(dummyOrder);
        }
    }

    public static void removeItem(ArrayList<Items> myOrder, String order) {
        Items dummyOrder2 = new Items();
        dummyOrder2.addItem(order);


        if (myOrder.size() != 0) {
            for (Items obj : myOrder) {
                if (dummyOrder2.name.equals(obj.name) && dummyOrder2.ingredients.equals(obj.ingredients)) {
                    obj.quantity -= 1;

                }
            }
        }
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
