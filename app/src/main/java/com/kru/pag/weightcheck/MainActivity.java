package com.kru.pag.weightcheck;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    //Explicit
    private myManage objMyManage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Request Database
        objMyManage = new myManage(this);
        //chack Regitter
        checkRegiter();
    }//Main Constacter

    private void checkRegiter() {
        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name, MODE_PRIVATE, null);
        Cursor objCursor = objSqLiteDatabase.rawQuery("SELECT * FROM userTABLE", null);

        if (objCursor.getCount() == 0) {
            Intent objIntent = new Intent(MainActivity.this, RegitterActivity.class);
            startActivity(objIntent);

        }//if
        objCursor.close();
    }//checkRegiter
}// Main Class
