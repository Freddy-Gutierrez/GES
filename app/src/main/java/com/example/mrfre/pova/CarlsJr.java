package com.example.mrfre.pova;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarlsJr extends AppCompatActivity {

    
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> items = new ArrayList<>();
    List<String> burgerCustoms = new ArrayList<>();
    List<String> friesCustoms = new ArrayList<>();
    List<String> drinkOptions = new ArrayList<>();
    List<String> dessertOptions = new ArrayList<>();
    HashMap<String, List<String>> listDataChild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carls_jr);
        
        listDataChild = new HashMap<String, List<String>>();
        //drop down headers
        items.add("Burger");items.add("Fries");items.add("Drinks");items.add("Desserts");
        //burger drop down items
        burgerCustoms.add("pickles");burgerCustoms.add("onions");burgerCustoms.add("cheese");burgerCustoms.add("ketchup");
        //Fries drop down customizations
        friesCustoms.add("Light");friesCustoms.add("Crispy");friesCustoms.add("Extra Salt");friesCustoms.add("Plain");
        //Drink drop down options
        drinkOptions.add("Coke");drinkOptions.add("Pepsi");drinkOptions.add("Sprite");drinkOptions.add("Dr.Pepper");drinkOptions.add("Powerade");
        //Desserts drop down options
        dessertOptions.add("Chocolate Chip Cookies");dessertOptions.add("Hershey's Pie");dessertOptions.add("Apple Pie");dessertOptions.add("Chocolate Milkshake");dessertOptions.add("Vanilla Milkshake");
        expandableListView = (ExpandableListView)findViewById(R.id.lvExp);
        expandableListAdapter = new com.example.mrfre.pova.ExpandableListAdapter(this, items, listDataChild);
        expandableListView.setAdapter(expandableListAdapter);

        //Add items to List holding all headers for drop down menu in the first arguement, and the list holding drop down selections in the other
        listDataChild.put(items.get(0), burgerCustoms);
        listDataChild.put(items.get(1), friesCustoms);
        listDataChild.put(items.get(2), drinkOptions);
        listDataChild.put(items.get(3), dessertOptions);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                switch (i){
                    case 0:
                        alertBoxBurger(i1);
                        break;
                    case 1:
                        alertBoxFries(i1);
                        break;
                    case 2:
                        alertBoxDrinks(i1);
                        break;
                    case 3:
                        alertBoxDesserts(i1);
                        break;
                    default:

                }
                return false;
            }
        });
    }

    private void alertBoxDesserts(int listInd) {
    }

    private void alertBoxDrinks(int listInd) {
    }

    private void alertBoxFries(int listInd) {
    }

    private void alertBoxBurger(int listInd){
        String selection = "";
        switch (listInd){
            case 0:
                selection = "pickles";
                break;
            case 1:
                selection = "onion";
                break;
            case 2:
                selection = "cheese";
                break;
            case 3:
                selection = "ketchup";
                break;
            case 4:
            default:
        }
        final String finalSelection = selection;
        new AlertDialog.Builder(CarlsJr.this)
                .setTitle("Burger Customization")
                .setMessage("Would you like to add " + selection + "?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(CarlsJr.this, finalSelection + " added to burger", Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(CarlsJr.this, finalSelection + " removed from burger", Toast.LENGTH_LONG).show();
                    }
                })
                .show();
    }


}
