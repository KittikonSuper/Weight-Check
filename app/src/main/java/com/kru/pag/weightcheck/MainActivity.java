package com.kru.pag.weightcheck;

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
    }//Main Constacter
}// Main Class
