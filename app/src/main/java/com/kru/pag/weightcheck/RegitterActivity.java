package com.kru.pag.weightcheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegitterActivity extends AppCompatActivity {
    //Explicit
    private EditText userEdittext,PasswordEdittext, NameEdittext;
    private String userString,passwordString, nameString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regitter);

        //Bind Widget
        BindWidget();


    }//Main Method

    private void BindWidget() {
        userEdittext = (EditText) findViewById(R.id.editText);
        PasswordEdittext = (EditText) findViewById(R.id.editText2);
        NameEdittext = (EditText) findViewById(R.id.editText3);

    }

    public void clickRegit(View view) {
        userString = userEdittext.getText().toString().trim();
        passwordString = PasswordEdittext.getText().toString().trim();
        nameString = NameEdittext.getText().toString().trim();
        if (userString.equals("")|| passwordString.equals("") || nameString.equals("")) {
            //Have Space
            Toast.makeText(RegitterActivity.this,getResources().getString(R.string.have_space),
                    Toast.LENGTH_LONG).show();
        } else {
            // No Space
            myManage objmyManage = new myManage(this);
            objmyManage.addUserTable(userString, passwordString, nameString);
            Toast.makeText(RegitterActivity. this, getResources().getString(R.string.success_Regit),
                    Toast.LENGTH_SHORT).show();
            finish();
        } //if

    }//clickRegit
}//Main Class
