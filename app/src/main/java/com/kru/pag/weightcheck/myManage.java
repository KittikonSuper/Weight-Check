package com.kru.pag.weightcheck;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by pag on 2/2/2559.
 */
public class myManage {
    //Explicit
    private MyOpenHelper objmyOpenHelper;
    private SQLiteDatabase writeSqliteDatabase, readSqLiteDatabase;

    public myManage(Context context) {
        //Creat & Connected
        objmyOpenHelper = new MyOpenHelper(context);
        writeSqliteDatabase = objmyOpenHelper.getWritableDatabase();
        writeSqliteDatabase = objmyOpenHelper.getReadableDatabase();


    }//Constacter

}//Main Class
