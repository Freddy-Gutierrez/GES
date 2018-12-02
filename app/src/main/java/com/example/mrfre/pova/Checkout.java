package com.example.mrfre.pova;

import android.arch.core.internal.FastSafeIterableMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class Checkout extends AppCompatActivity {

    EditText firstNameET;
    EditText lastNameET;
    EditText cardNumET;
    EditText monthET;
    EditText yearET;
    EditText cscET;
    EditText cardHolderNameET;
    EditText middleIET;
    EditText streetET;
    EditText cityET;
    EditText stateET;
    EditText postalET;
    EditText countryET;

    String firstName;
    String lastName;
    String cardNum;
    int month;
    int year;
    String csc;
    String cardHolderName;
    String middleI;
    String street;
    String city;
    String state;
    String postal;
    String country;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        firstNameET = (EditText)findViewById(R.id.editTextFirstName);
        lastNameET = (EditText)findViewById(R.id.editTextLastName);
        cardNumET = (EditText)findViewById(R.id.editTextCardNum);
        monthET = (EditText)findViewById(R.id.editTextMonth);
        yearET = (EditText)findViewById(R.id.editTextYear);
        cscET = (EditText)findViewById(R.id.editTextCSC);
        cardHolderNameET = (EditText)findViewById(R.id.editTextCardHolderName);
        middleIET = (EditText)findViewById(R.id.editTextMiddleName);
        streetET = (EditText)findViewById(R.id.editTextStreet);
        cityET = (EditText)findViewById(R.id.editTextCity);
        stateET = (EditText)findViewById(R.id.editTextState);
        postalET = (EditText)findViewById(R.id.editTextPostal);
        countryET = (EditText)findViewById(R.id.editTextCountry);


    }

    //get user information
    private void getInfo(){
        firstName =  firstNameET.getText().toString();
        lastName =  lastNameET.getText().toString();
        cardNum =  cardNumET.getText().toString();
        month =  Integer.parseInt(monthET.getText().toString());
        year = Integer.parseInt(yearET.getText().toString());
        csc =  cscET.getText().toString();
        cardHolderName =  cardHolderNameET.getText().toString();
        middleI =  middleIET.getText().toString();
        street =  streetET.getText().toString();
        city =  cityET.getText().toString();
        state =  stateET.getText().toString();
        postal =  postalET.getText().toString();
        country =  countryET.getText().toString();
    }

    private boolean verifyCardNum(){
        boolean isValid = true;
        char curChar = ' ';
        //valid card number should be 16 characters
        if(cardNum.length() != 16){
            //Toast.makeText(this, "Invalid Card Number Entered", Toast.LENGTH_SHORT).show();
            isValid = false;
        }
        //ascii values of 0-9 should be between 48 and 57, anything below or above is not a number
        else {
            for (int i = 0; i < cardNum.length(); i++) {
                curChar = cardNum.charAt(i);
                if (curChar < 48 || curChar > 57) {
                    //Toast.makeText(this, "Invalid Character Entered in Card Number", Toast.LENGTH_SHORT).show();
                    isValid = false;
                    break;
                }
            }
        }
        return isValid;
    }

    private boolean verifyExpirationDate(){
        boolean isValid = true;
        Calendar c = Calendar.getInstance();
        int curMonth = c.get(Calendar.MONTH);
        int curYear = c.get(Calendar.YEAR);
        //invalid numbers entered into month or year text fields
        if(String.valueOf(month).length() < 2 || String.valueOf(year).length() < 4){
            isValid = false;
            Log.i("Failed","month or year length");
        }
        else {
            if (year <= curYear) {
                if (month < curMonth) {
                    isValid = false;
                    Log.i("Failed", "month");
                    return isValid;
                }
            } else {
                isValid = true;
            }
        }
        return isValid;
    }

    private boolean verifyCSC(){
        boolean isValid = true;
        if(csc.length() < 3){
            isValid = false;
        }
        return isValid;
    }

    private boolean verifyState(){
        boolean isValid = true;
        if(state.length() < 2){
            isValid = false;

        }
        return isValid;
    }

    private boolean verifyPostalCode(){
        boolean isValid = true;
        char curChar;
        if(postal.length() < 5){
            isValid = false;
        }
        else{
            //ascii values of 0-9 should be between 48 and 57, anything below or above is not a number
            for(int i = 0; i < postal.length(); i++){
                curChar = postal.charAt(i);
                if(curChar < 48 || curChar > 57){
                    //Toast.makeText(this, "Invalid Character Entered in Card Number", Toast.LENGTH_SHORT).show();
                    isValid = false;
                    break;
                }
            }
        }
        return isValid;
    }

    public void confirmClick(View view) {
        getInfo();
        //all should be true for a valid card
        boolean isValid = verifyExpirationDate() && verifyCardNum() && verifyCSC() && verifyPostalCode() && verifyState();
        if(isValid){
            Toast.makeText(this, "New Activity Started", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Invalid Card Information Entered", Toast.LENGTH_SHORT).show();
        }
    }
}
