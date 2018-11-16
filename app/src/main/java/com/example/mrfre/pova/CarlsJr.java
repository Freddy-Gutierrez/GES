package com.example.mrfre.pova;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
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

    //data structures and views that will be used to set up UI
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> items = new ArrayList<>();
    List<String> burgers = new ArrayList<>();
    List<String> sideOptions = new ArrayList<>();
    List<String> drinkOptions = new ArrayList<>();
    List<String> dessertOptions = new ArrayList<>();
    HashMap<String, List<String>> listDataChild;
    Drawable image;

    //database instance
    DataBaseHelper myDB = new DataBaseHelper(CarlsJr.this);

    //instances to store information about the item selected
    String selection = "";
    String name = "";
    String description = "";
    String customs = "";
    int calories = 0;
    double price = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carls_jr);
        
        listDataChild = new HashMap<String, List<String>>();
        //drop down headers
        items.add("BURGERS");items.add("SIDES");items.add("DRINKS");items.add("DESSERTS");

        //burger drop down menu
        burgers.add("Big Carl®");burgers.add("Double Western Bacon Cheeseburger®");

        //Fries drop down customizations
        sideOptions.add("Natural-Cut French Fries - Small");sideOptions.add("Natural-Cut French Fries - Medium");sideOptions.add("Natural-Cut French Fries - Large");sideOptions.add("Crisscut® Fries");sideOptions.add("Onion Rings");sideOptions.add("Fried Zucchhini");

        //Drink drop down options
        drinkOptions.add("Fuze® Raspberry Tea");drinkOptions.add("Gold Peak® Iced Tea");drinkOptions.add("Coca-Cola®");drinkOptions.add("Diet Coke®");drinkOptions.add("Coca-Cola Zero™");
        drinkOptions.add("Sprite®");drinkOptions.add("Barq’s® Rootbeer");drinkOptions.add("Powerade® Mountain Blast");drinkOptions.add("Cherry Coke®");drinkOptions.add("Hi-C® Flashin’ Fruit Punch");drinkOptions.add("Dr Pepper®");
        drinkOptions.add("Diet Dr Pepper®");drinkOptions.add("Fanta® Orange");drinkOptions.add("Fanta® Strawberry");drinkOptions.add("Minute Maid Light™ Lemonade");drinkOptions.add("Vanilla Hand-Scooped Ice Cream Shake™");drinkOptions.add("Chocolate Hand-Scooped Ice Cream Shake™");
        drinkOptions.add("Strawberry Hand-Scooped Ice Cream Shake™");drinkOptions.add("Oreo® Cookie Hand-Scooped Ice Cream Shake™");drinkOptions.add("Monster Energy®");drinkOptions.add("Dasani® Water");drinkOptions.add("Colombian Blend Coffee");
        drinkOptions.add("Decaffeinated Coffee");drinkOptions.add("Minute Maid® Orange Juice");drinkOptions.add("1% Fat Milk");

        //Desserts drop down options
        dessertOptions.add("Chocolate Chip Cookies");dessertOptions.add("Strawberry Swirl Cheesecake");dessertOptions.add("Chocolate Cake");dessertOptions.add("Jolly Rancher Milkshake");
        expandableListView = (ExpandableListView)findViewById(R.id.lvExp);
        expandableListAdapter = new com.example.mrfre.pova.ExpandableListAdapter(this, items, listDataChild);
        expandableListView.setAdapter(expandableListAdapter);

        //Add items to List holding all headers for drop down menu in the first arguement, and the list holding drop down selections in the other
        listDataChild.put(items.get(0), burgers);
        listDataChild.put(items.get(1), sideOptions);
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
                        alertBoxSides(i1);
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

    private void alertBoxBurger(int listInd) {
        //Create String to save user selection from expandable LV
        switch (listInd){
            case 0:
                selection = "Big Carl®";
                break;
            case 1:
                selection = "Double Western Bacon Cheeseburger®";
                break;
            default:
        }
        /* use given string to query database
        use cursor object to get all data from database
        save that data into appropriate instances
        */
        Cursor cursor = myDB.getData(selection);
        while(cursor.moveToNext()){
            name = cursor.getString(1);
            calories = cursor.getInt(2);
            price = cursor.getDouble(3);
            description = cursor.getString(4);
            customs = cursor.getString(5);
        }
        createDialogueBox();
    }

    //Same as alertBoxBurger
    private void alertBoxSides(int listInd) {
        switch (listInd){
            case 0:
                selection = "Natural-Cut French Fries - Small";
                break;
            case 1:
                selection = "Natural-Cut French Fries - Medium";
                break;
            case 2:
                selection = "Natural-Cut French Fries - Large";
                break;
            case 3:
                selection = "Crisscut® Fries";
                break;
            case 4:
                selection = "Onion Rings";
                break;
            case 5:
                selection = "Fried Zucchhini";
                break;
            default:
        }

        Cursor cursor = myDB.getData(selection);
        while(cursor.moveToNext()){
            name = cursor.getString(1);
            calories = cursor.getInt(2);
            price = cursor.getDouble(3);
            description = cursor.getString(4);
            customs = cursor.getString(5);
        }
        createDialogueBox();


    }

    private void alertBoxDrinks(int listInd) {

        switch (listInd){
            case 0:
                selection = "Fuze® Raspberry Tea";
                break;
            case 1:
                selection = "Gold Peak® Iced Tea";
                break;
            case 2:
                selection = "Coca-Cola®";
                break;
            case 3:
                selection = "Diet Coke®";
                break;
            case 4:
                selection = "Coca-Cola Zero™";
                break;
            case 5:
                selection = "Sprite®";
                break;
            case 6:
                selection = "Barq’s® Rootbeer";
                break;
            case 7:
                selection = "Powerade® Mountain Blast";
                break;
            case 8:
                selection = "Cherry Coke®";
                break;
            case 9:
                selection = "Hi-C® Flashin’ Fruit Punch";
                break;
            case 10:
                selection = "Dr Pepper®";
                break;
            case 11:
                selection = "Diet Dr Pepper®";
                break;
            case 12:
                selection = "Fanta® Orange";
                break;
            case 13:
                selection = "Fanta® Strawberry";
                break;
            case 14:
                selection = "Minute Maid Light™ Lemonade";
                break;
            case 15:
                selection = "Vanilla Hand-Scooped Ice Cream Shake™";
                break;
            case 16:
                selection = "Chocolate Hand-Scooped Ice Cream Shake™";
                break;
            case 17:
                selection = "Strawberry Hand-Scooped Ice Cream Shake™";
                break;
            case 18:
                selection = "Oreo® Cookie Hand-Scooped Ice Cream Shake™";
                break;
            case 19:
                selection = "Monster Energy®";
                break;
            case 20:
                selection = "Dasani® Water";
                break;
            case 21:
                selection = "Colombian Blend Coffee";
                break;
            case 22:
                selection = "Decaffeinated Coffee";
                break;
            case 23:
                selection = "Minute Maid® Orange Juice";
                break;
            case 24:
                selection = "1% Fat Milk";
                break;
            default:
        }


        Cursor cursor = myDB.getData(selection);
        while(cursor.moveToNext()){
            name = cursor.getString(1);
            calories = cursor.getInt(2);
            price = cursor.getDouble(3);
            description = cursor.getString(4);
            customs = cursor.getString(5);
        }
        createDialogueBox();

    }

    private void alertBoxDesserts(int listInd) {

        switch (listInd){
            case 0:
                selection = "Chocolate Chip Cookies";
                break;
            case 1:
                selection = "Strawberry Swirl Cheesecake";
                break;
            case 2:
                selection = "Chocolate Cake";
                break;
            case 3:
                selection = "Jolly Rancher Milkshake";
                break;
            default:
        }

        Cursor cursor = myDB.getData(selection);
        while(cursor.moveToNext()){
            name = cursor.getString(1);
            calories = cursor.getInt(2);
            price = cursor.getDouble(3);
            description = cursor.getString(4);
            customs = cursor.getString(5);
        }
        createDialogueBox();
    }


    private void createDialogueBox(){
        /*
            Display an alertbox to the user with data query'd from database
         */
        new AlertDialog.Builder(CarlsJr.this)
                .setTitle(name)
                .setMessage("Description: " + description + "\n" +
                        "\nCalories: " + calories + "\n" +
                        "\nPrice: " + price + "\n" +
                        "\nWould you like to add a " + name + " to your cart?")
                .setIcon(R.drawable.carlslogo)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(CarlsJr.this, selection + " added to cart", Toast.LENGTH_LONG).show();
                    }
                })
                .setNeutralButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        /*create intent to switch activity to EditItemMenu activity
                        pass item name and customizations to EditItemMenu
                        start EditItemMenu Activity and finish this activity
                        */
                        Intent intent = new Intent(CarlsJr.this, EditItemMenu.class);
                        intent.putExtra("itemName", name);
                        intent.putExtra("customs", customs);
                        startActivity(intent);
                        finish();
                        Toast.makeText(CarlsJr.this, selection + " will be edited", Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(CarlsJr.this, selection
                                + " removed from cart", Toast.LENGTH_LONG).show();
                    }
                }).show();
    }
}
