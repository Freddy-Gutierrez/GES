package com.example.mrfre.pova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ConfirmationScreen extends AppCompatActivity {

    TextView orderDetails;
    TextView billingInfo;
    TextView total;

    String textDetails = "";
    String billingText = "";
    String pickUpTime = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_screen);

        orderDetails = (TextView)findViewById(R.id.textViewDetails);
        billingInfo = (TextView)findViewById(R.id.textViewBillingInfo);
        total = (TextView)findViewById(R.id.textViewOrderTotal);

        getTexts();
        setTexts();
    }

    private void getTexts() {
        //use extras passed from checkout activity to create strings that will be used to set the text for textview
        Intent intent = getIntent();
        String firstName = intent.getStringExtra("firstN");
        String lastName = intent.getStringExtra("lastN");
        String middle = intent.getStringExtra("middle");
        String street = intent.getStringExtra("street");
        String city = intent.getStringExtra("city");
        String postal = intent.getStringExtra("postal");
        String country = intent.getStringExtra("country");
        String lastFour = intent.getStringExtra("lastFour");
        pickUpTime = "\nPick Up Time: " + intent.getStringExtra("pickUp");
        billingText = firstName + " " + middle + " " + lastName + "\n"
                      + street + ", " + city + " " + postal + "\n"
                      + country + "\n"
                      + "Payment Ending in " + lastFour;

        //iterate through arraylists from cart activity to get order details
        for(int  i =0; i< RecyclerViewAdapter.itemNames.size(); i++){
            textDetails = textDetails + RecyclerViewAdapter.itemQuantities.get(i) + " " + RecyclerViewAdapter.itemNames.get(i) + " " + RecyclerViewAdapter.toppings.get(i) + "\n";
        }
    }

    private void setTexts() {
        orderDetails.setText(textDetails + pickUpTime);
        billingInfo.setText(billingText);
        total.setText("Order Total: $" + Checkout.total);
    }
}
