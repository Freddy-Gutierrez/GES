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
    List<String> bigCarlCustoms = new ArrayList<>();
    List<String> westernBaconCustoms = new ArrayList<>();
    List<String> sideOptions = new ArrayList<>();
    List<String> drinkOptions = new ArrayList<>();
    List<String> dessertOptions = new ArrayList<>();
    HashMap<String, List<String>> listDataChild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carls_jr);
        
        listDataChild = new HashMap<String, List<String>>();
        //drop down headers
        items.add("BIG CARL");items.add("DOUBLE WESTERN BACON CHEESEBURGER");items.add("SIDES");items.add("DRINKS");items.add("DESSERTS");
        //big carls drop down items
        bigCarlCustoms.add("lettuce");bigCarlCustoms.add("classic sauce");
        //western bacon customs
        westernBaconCustoms.add("Thick-Cut Applewood-Smoked Bacon");westernBaconCustoms.add("Onion Rings");westernBaconCustoms.add("BBQ Sauce");
        //Fries drop down customizations
        sideOptions.add("Natural-Cut French Fries - Small");sideOptions.add("Natural-Cut French Fries - Medium");sideOptions.add("Natural-Cut French Fries - Large");sideOptions.add("Crisscut® Fries");sideOptions.add("Onion Rings");sideOptions.add("Fried Zucchhini");
        //Drink drop down options
        drinkOptions.add("Fuze® Raspberry Tea");drinkOptions.add("Gold Peak® Iced Tea");drinkOptions.add("Coca-Cola®");drinkOptions.add("Diet Coke®");drinkOptions.add("Coca-Cola Zero™");
        drinkOptions.add("Sprite®");drinkOptions.add("Barq’s® Rootbeer");drinkOptions.add("Powerade® Mountain Blast");drinkOptions.add("Cherry Coke®");drinkOptions.add("Hi-C® Flashin’ Fruit Punch");drinkOptions.add("Dr Pepper®");
        drinkOptions.add("Diet Dr Pepper®");drinkOptions.add("Fanta® Orange");drinkOptions.add("Fanta® Strawberry");drinkOptions.add("Minute Maid Light™ Lemonade");drinkOptions.add("Vanilla Hand-Scooped Ice Cream Shake™");drinkOptions.add("Chocolate Hand-Scooped Ice Cream Shake™");
        drinkOptions.add("Strawberry Hand-Scooped Ice Cream Shake™");drinkOptions.add("Oreo® Cookie Hand-Scooped Ice Cream Shake™");drinkOptions.add("Monster Energy®");drinkOptions.add("Sprite®");drinkOptions.add("Dasani® Water");drinkOptions.add("Colombian Blend Coffee");
        drinkOptions.add("Decaffeinated Coffee");drinkOptions.add("Minute Maid® Orange Juice");drinkOptions.add("1% Fat Milk");
        //Desserts drop down options
        dessertOptions.add("Chocolate Chip Cookies");dessertOptions.add("Strawberry Swirl Cheesecake");dessertOptions.add("Chocolate Cake");dessertOptions.add("Jolly Rancher Milkshake");
        expandableListView = (ExpandableListView)findViewById(R.id.lvExp);
        expandableListAdapter = new com.example.mrfre.pova.ExpandableListAdapter(this, items, listDataChild);
        expandableListView.setAdapter(expandableListAdapter);

        //Add items to List holding all headers for drop down menu in the first arguement, and the list holding drop down selections in the other
        listDataChild.put(items.get(0), bigCarlCustoms);
        listDataChild.put(items.get(1), westernBaconCustoms);
        listDataChild.put(items.get(2), sideOptions);
        listDataChild.put(items.get(3), drinkOptions);
        listDataChild.put(items.get(4
        ), dessertOptions);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                switch (i){
                    case 0:
                        alertBoxBigCarl(i1);
                        break;
                    case 1:
                        alertBoxDoubleWestern(i1);
                        break;
                    case 3:
                        alertBoxSides(i1);
                        break;
                    case 4:
                        alertBoxDrinks(i1);
                        break;
                    case 5:
                        alertBoxDesserts(i1);
                        break;
                    default:

                }
                return false;
            }
        });
    }

    private void alertBoxDoubleWestern(int i1) {
    }

    private void alertBoxDesserts(int listInd) {
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

    private void alertBoxDrinks(int listInd) {
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

    private void alertBoxSides(int listInd) {
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

    private void alertBoxBigCarl(int listInd){
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
