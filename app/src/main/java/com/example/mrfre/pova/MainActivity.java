package com.example.mrfre.pova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper myDB = new DataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB.clearTable();
        myDB.insertData("Big Carl®", 920, 6.95, "Two charbroiled beef patties, our classic sauce, two slices of American cheese, and lettuce all on a seeded bun.", "Lettuce,Pickles,Onions");
        myDB.insertData("Double Western Bacon Cheeseburger®", 1100, 6.00, "Two Charbroiled All-Beef Patties, Two Strips of Bacon, Two Slices of Melted American Cheese, Crispy Onion Rings and Tangy BBQ Sauce on a seeded bun.", "Onion Rings,BBQ Sauce,Cheese");
        myDB.insertData("Sprite®", 140, 2.00, "Cold Drink", "Small,Medium,Large");
        myDB.insertData("Strawberry Swirl Cheesecake", 450, 2.99, "Yummy dessert", "No,Desc,Here");

        ListView resList = (ListView)findViewById(R.id.resListView);
        ArrayList<String> restaurants = new ArrayList<>();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, restaurants);
        restaurants.add("Carls Jr.");
        restaurants.add("Johnny's Kitchen");
        restaurants.add("El Pollo Loco");
        restaurants.add("Rice Garden");
        resList.setAdapter(arrayAdapter);
        resList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch (i){
                    case 0:
                        intent = new Intent(MainActivity.this, CarlsJr.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, JohnnysKitchen.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, ElPolloLoco.class);
                        startActivity(intent);
                        finish();
                    case 3:
                        intent = new Intent(MainActivity.this, RiceGarden.class);
                        startActivity(intent);
                        finish();
                        break;
                        default:
                }
            }
        });

    }
}
