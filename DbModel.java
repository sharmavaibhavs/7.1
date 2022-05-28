package com.example.sit305_7_1p;

import static android.widget.Toast.makeText;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbModel extends SQLiteOpenHelper {

    public DbModel(@Nullable Context context) {
        super(context, "Alerts_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //this override creates the alerts table in the database through executing the string in SQL
        String CREATE_ITEM_TABLE = "CREATE TABLE ITEM(ITEMID INTEGER PRIMARY KEY AUTOINCREMENT, TYPE TEXT, NAME TEXT, PHONE INTEGER, DESCRIPTION TEXT, DATE TEXT, LOCATION TEXT)";
        sqLiteDatabase.execSQL(CREATE_ITEM_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String DROP_ITEM_TABLE = "DROP TABLE IF EXISTS ITEM";
        sqLiteDatabase.execSQL(DROP_ITEM_TABLE);
        onCreate(sqLiteDatabase);
    }
    public ArrayList<DataModel> fetchAllAlerts(){
        ArrayList<DataModel> AlertList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String SELECT_ALL_ITEM = "SELECT * FROM ITEM";
        Cursor cursor = db.rawQuery(SELECT_ALL_ITEM, null);
        if (cursor.moveToFirst()){
            do {
                DataModel temp = new DataModel(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                        cursor.getInt(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
                AlertList.add(temp);
            }while(cursor.moveToNext());
        }
        return AlertList;
    }


    public long InsertAlert(DataModel alert) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues Values = new ContentValues();
        Values.put("TYPE",alert.getLostOrFound());
        Values.put("NAME", alert.getName());
        Values.put("DESCRIPTION", alert.getDescription());
        Values.put("PHONE", alert.getPhone());
        Values.put("DATE", alert.getDate());
        Values.put("LOCATION", alert.getLocation());
        long checkRow = db.insert("ITEM",null, Values);
        return checkRow;

    }

    public void DeleteAlert(DataModel alert){
        //connect to the database and make it readable and writable
        SQLiteDatabase db = this.getWritableDatabase();
        String WhereClause = "ITEMID=?";
        String[] WhereArgs = {String.valueOf(alert.getAlertID())};
        db.delete("ITEM", WhereClause, WhereArgs);
        db.close();
    }


}
