package com.example.mrfre.pova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Cart extends AppCompatActivity {


    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        display = (TextView)findViewById(R.id.displayOrder);
        updateDisplay();
    }

    private void updateDisplay() {
        Intent i = getIntent();
        String displayOrder = i.getStringExtra("Order");
        Double displayPrice = Math.round(i.getDoubleExtra("Total",0)*100)/100.;

        display.setText(displayOrder + "\n" + "Total: " + displayPrice);

    }

    public void checkoutOnClick(View view) {
        Intent i = new Intent(Cart.this, Checkout.class);
        startActivity(i);
        finish();
    }
}
