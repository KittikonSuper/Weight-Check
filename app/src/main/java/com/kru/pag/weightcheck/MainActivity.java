package com.kru.pag.weightcheck;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //Explicit
    private myManage objMyManage;
    private EditText userEditText, passwordEditText;
    private Button loginButton;
    private String userString, passwordString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Bind Widget คือการผูกตัวแปร ที่ประกาศ กับ Widget ที่อยู่ใน Layout
        bindWidget();

        //Request Database
        objMyManage = new myManage(this);
        //chack Regitter
        checkRegiter();
        //Button Controller
        buttonController();
    }//Main Constacter

    private void buttonController() {


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get Value From Edittext to String
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();
                //Check Space
                if (userString.equals("") || passwordString.equals("")) {
                    //Have Space
                    Toast.makeText(MainActivity.this, "Have Space", Toast.LENGTH_SHORT).show();
                } else {
                    //No Space
                    CheckUser();
                }

            }//event
        });

    }//buttonController

    private void CheckUser() {
        //การอ่านข้อมูลจาก SQLite
        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor objCursor = objSqLiteDatabase.rawQuery("SELECT * FROM " + myManage.table_user, null);
        objCursor.moveToFirst();
        String trueUser = objCursor.getString(1);
        String truePassword = objCursor.getString(2);
        String trueName = objCursor.getString(3);
        if (userString.equals(trueUser)){
            //User OK

        }else {
            //User False
            Toast.makeText(MainActivity.this,"User False",Toast.LENGTH_SHORT).show();
        }
    }// checkUser

    private void bindWidget() {
        userEditText = (EditText) findViewById(R.id.editText4);
        passwordEditText = (EditText) findViewById(R.id.editText5);
        loginButton = (Button) findViewById(R.id.button2);
    }

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
