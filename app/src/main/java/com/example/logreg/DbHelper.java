package com.example.logreg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Ügyfél";
    public static final String TABLE_NAME="Felhasználó";

    public static final String COL_1="ID";
    public static final String COL_2="Email";
    public static final String COL_3="Felhnev";
    public static final String COL_4="Jelszo";
    public static final String COL_5="TeljesNev";

    public DbHelper(Context context)
    {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Email TEXT NOT NULL,Felhnev TEXT NOT NULL,Jelszo TEXT NOT NULL,TeljesNev TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i,int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }

    public boolean adatRogzites(String email, String felhnev, String jelszo, String teljesNev)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, email);
        contentValues.put(COL_3, felhnev);
        contentValues.put(COL_4, jelszo);
        contentValues.put(COL_4, teljesNev);

        long eredmeny = database.insert(TABLE_NAME, null, contentValues);

        if (eredmeny == -1)
            return false;
        else
            return true;
    }

    public Cursor adatLekerdezes()
    {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor eredmeny = database.rawQuery("SELECT * from " + TABLE_NAME, null);
        return eredmeny;
    }

    public long adatTorles(int id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete(TABLE_NAME,COL_1+" = ?",new String[] {String.valueOf(id)});
    }

    public long adatModosit(String id, String email, String felhnev, String jelszo, String teljesNev){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_2, email);
        values.put(COL_3, felhnev);
        values.put(COL_4, jelszo);
        values.put(COL_4, teljesNev);

        return database.update(TABLE_NAME, values, COL_1 + " = ?", new String[]{id});
    }



}
