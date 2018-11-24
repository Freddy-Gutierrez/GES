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
            case "Natural-Cut French Fries - Small":
                item.setImageDrawable(getResources().getDrawable(R.drawable.naturalcutfries));
                break;
            case "Natural-Cut French Fries - Medium":
                item.setImageDrawable(getResources().getDrawable(R.drawable.naturalcutfries));
                break;
            case "Natural-Cut French Fries - Large":
                item.setImageDrawable(getResources().getDrawable(R.drawable.naturalcutfries));
                break;
            case "Crisscut® Fries":
                item.setImageDrawable(getResources().getDrawable(R.drawable.crisscutfries));
                break;
            case "Fried Zucchhini":
                item.setImageDrawable(getResources().getDrawable(R.drawable.friedzucchini));
                break;
            case "Fuze® Raspberry Tea":
                item.setImageDrawable(getResources().getDrawable(R.drawable.fuzeraspberrytea));
                break;
            case "Gold Peak® Iced Tea":
                item.setImageDrawable(getResources().getDrawable(R.drawable.goldpeakicedtea));
                break;
            case "Coca-Cola®":
                item.setImageDrawable(getResources().getDrawable(R.drawable.cocacola));
                break;
            case "Diet Coke®":
                item.setImageDrawable(getResources().getDrawable(R.drawable.dietcoke));
                break;
            case "Coca-Cola Zero™":
                item.setImageDrawable(getResources().getDrawable(R.drawable.cocacolazero));
                break;
            case "Sprite®":
                item.setImageDrawable(getResources().getDrawable(R.drawable.sprite));
                break;
            case "Barq’s® Rootbeer":
                item.setImageDrawable(getResources().getDrawable(R.drawable.barqsrootbeer));
                break;
            case "Powerade® Mountain Blast":
                item.setImageDrawable(getResources().getDrawable(R.drawable.powerademountainblast));
                break;
            case "Cherry Coke®":
                item.setImageDrawable(getResources().getDrawable(R.drawable.cherrycoke));
                break;
            case "Hi-C® Flashin’ Fruit Punch":
                item.setImageDrawable(getResources().getDrawable(R.drawable.hicflashinfruitpunch));
                break;
            case "Dr Pepper®":
                item.setImageDrawable(getResources().getDrawable(R.drawable.drpepper));
                break;
            case "Diet Dr Pepper®":
                item.setImageDrawable(getResources().getDrawable(R.drawable.dietdrpepper));
                break;
            case "Fanta® Orange":
                item.setImageDrawable(getResources().getDrawable(R.drawable.dietdrpepper));
                break;
            case "Fanta® Strawberry":
                item.setImageDrawable(getResources().getDrawable(R.drawable.fantastrawberry));
                break;
            case "Minute Maid Light™ Lemonade":
                item.setImageDrawable(getResources().getDrawable(R.drawable.minutemaidlightlemonade));
                break;
            case "Vanilla Hand-Scooped Ice Cream Shake™":
                item.setImageDrawable(getResources().getDrawable(R.drawable.vanillahandscoopedicecreamshake));
                break;
            case "Chocolate Hand-Scooped Ice Cream Shake™":
                item.setImageDrawable(getResources().getDrawable(R.drawable.chocolatehandscoopedicecreamshake));
                break;
            case "Strawberry Hand-Scooped Ice Cream Shake™":
                item.setImageDrawable(getResources().getDrawable(R.drawable.strawberryhandscoopedicecreamshake));
                break;
            case "Oreo® Cookie Hand-Scooped Ice Cream Shake™":
                item.setImageDrawable(getResources().getDrawable(R.drawable.oreohandscoopedicecreamshake));
                break;
            case "Monster Energy®":
                item.setImageDrawable(getResources().getDrawable(R.drawable.naturalcutfries));
                break;
            case "Dasani® Water":
                item.setImageDrawable(getResources().getDrawable(R.drawable.dasaniwater));
                break;
            case "Colombian Blend Coffee":
                item.setImageDrawable(getResources().getDrawable(R.drawable.coffee));
                break;
            case "Decaffeinated Coffee":
                item.setImageDrawable(getResources().getDrawable(R.drawable.coffee));
                break;
            case "Minute Maid® Orange Juice":
                item.setImageDrawable(getResources().getDrawable(R.drawable.minutemaidorangejuice));
                break;
            case "1% Fat Milk":
                item.setImageDrawable(getResources().getDrawable(R.drawable.fatmilk));
                break;
            case "Chocolate Chip Cookies":
                item.setImageDrawable(getResources().getDrawable(R.drawable.chocolatecake));
                break;
            case "Strawberry Swirl Cheesecake":
                item.setImageDrawable(getResources().getDrawable(R.drawable.strawberryswirlcheesecake));
                break;
            case "Chocolate Cake":
                item.setImageDrawable(getResources().getDrawable(R.drawable.cccookies));
                break;
            case "Jolly Rancher Milkshake":
                item.setImageDrawable(getResources().getDrawable(R.drawable.jollyranchermilkshake));
                break;
            default:
                Log.i("Error", "Could not locate the specified item");
        }
    }

    public void backToMenu(View view) {
        Intent i = new Intent(EditItemMenu.this, CarlsJr.class);
        startActivity(i);
        finish();
    }
}


