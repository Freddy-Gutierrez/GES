package com.example.mrfre.pova;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class EditItemMenu extends AppCompatActivity {

    ImageView item;
    String itemName = "";
    String customs = "";
    String[] customsArray;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item_menu);


        lv = (ListView)findViewById(R.id.customsListView);
        item = (ImageView)findViewById(R.id.itemImageView);
        Intent i = getIntent();
        itemName = i.getStringExtra("itemName");
        //get string of toppings/customs then split using ',' as delimiter
        customs = i.getStringExtra("customs");
        customsArray = customs.split(",");
        setListView();
        setImage();
    }

    //set listview contents that display the toppings/customizations of an item
    private void setListView() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, customsArray);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(EditItemMenu.this, "Item was click", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setImage() {
        switch (itemName){
            case "Big Carl®":
                item.setImageDrawable(getResources().getDrawable(R.drawable.bigcarl));
                break;
            case "Double Western Bacon Cheeseburger®":
                item.setImageDrawable(getResources().getDrawable(R.drawable.doublewetern));
                break;
            default:
                Log.i("Error", "Could not locate the specified item");
        }
    }
}
