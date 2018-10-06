package com.example.mrfre.pova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
