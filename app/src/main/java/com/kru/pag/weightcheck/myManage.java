package com.kru.pag.weightcheck;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by pag on 2/2/2559.
 */
public class myManage {
    //Explicit
    private MyOpenHelper objmyOpenHelper;
    private SQLiteDatabase writeSqliteDatabase, readSqLiteDatabase;
    public static final String table_user = "user TABLE";
    public static final String table_weight = "weightTABLE ";
    public static final String Column_user = "_id";
    public static final String Column_Password = "_Password";
    public static final String Column_name = "_Name";
    public static final String Column_data = "_Data";
    public static final String Column_weight = "_weight";


    public myManage(Context context) {
        //Creat & Connected
        objmyOpenHelper = new MyOpenHelper(context);
        writeSqliteDatabase = objmyOpenHelper.getWritableDatabase();
        writeSqliteDatabase = objmyOpenHelper.getReadableDatabase();


    }//Constacter
    //Add New Value to userTABLE
    public long addUserTable(String strUser, String strPassword, String strName) {
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(Column_user, strUser);
        objContentValues.put(Column_Password, strPassword);
        objContentValues.put(Column_name, strName);


        return writeSqliteDatabase.insert(table_user, null,objContentValues);
    }

}//Main Class
