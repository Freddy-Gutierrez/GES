package com.example.mrfre.pova;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Menu_item.db";
    public static final String TABLE_NAME = "Menu_item";
    private static final int DATABASE_VERSION = 1;
    String COL_0 = "ID";
    String COL_1 = "NAME";
    String COL_2 = "CALORIES";
    String COL_3 = "PRICE";
    String COL_4 = "DESCRIPTION";



    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY, NAME TEXT, CALORIES INTEGER, PRICE DOUBLE, DESCRIPTION TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        Log.i("Upgrade", "Success");
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String name, int calories, double price, String description ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_1, name);
        values.put(COL_2, calories);
        values.put(COL_3, price);
        values.put(COL_4, description);

        long result = db.insert(TABLE_NAME, null, values);
        if(result == -1)
            return false;
        else
            return true;
    }


    //retrieves all data in the table in descending order by score
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.query(TABLE_NAME, null, null, null, null, null, null, null);
        return res;
    }


    public boolean updateData(String id, String name, int calories, double price , String description){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_0, id);
        values.put(COL_1, name);
        values.put(COL_2, calories);
        values.put(COL_3, price);
        values.put(COL_4, description);
        db.update(TABLE_NAME, values, "ID = ?", new String[]{id});
        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] {id});
    }
    public void clearTable(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }
}