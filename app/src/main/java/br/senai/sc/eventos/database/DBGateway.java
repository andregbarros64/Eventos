package br.senai.sc.eventos.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DBGateway {

    private static DBGateway dbGateway;
    private SQLiteDatabase db;

    public static  DBGateway getInstance(Context context){
        if(dbGateway == null){
            dbGateway = new DBGateway(context);
        }
        return dbGateway;
    }

    private DBGateway(Context context){

        DataBaseDBHelper dbHelper = new DataBaseDBHelper(context);
        db = dbHelper.getWritableDatabase();
        db.execSQL("INSERT INTO eventos(nome)VALUES('Florianópolis')");
        db.execSQL("INSERT INTO eventos(nome)VALUES('Joinville')");
        db.execSQL("INSERT INTO eventos(nome)VALUES('Blumenau')");
        db.execSQL("INSERT INTO eventos(nome)VALUES('Curitiba')");
        db.execSQL("INSERT INTO eventos(nome)VALUES('São Paulo')");
    }

    public SQLiteDatabase getDataBase(){
        return db;
    }

}
