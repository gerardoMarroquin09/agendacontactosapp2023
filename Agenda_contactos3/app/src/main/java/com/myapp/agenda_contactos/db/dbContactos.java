package com.myapp.agenda_contactos.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbContactos extends DdHelper{
    Context context;
    public dbContactos(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long insertarContacto(Integer id,String nombre,String apellido,Integer edad,String domicilio,String correo_electronico,Integer telefono ){
        long ID = 0;
        try {
            DdHelper ddHelper = new DdHelper(context);
            SQLiteDatabase db = ddHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("id", id);
            values.put("nombre", nombre);
            values.put("apellido", apellido);
            values.put("edad", edad);
            values.put("domicilio", domicilio);
            values.put("correo_electronico", correo_electronico);
            values.put("telefono", telefono);

            ID = db.insert(TABLE_CONTACTOS, null, values);
        }catch(Exception ex){
            ex.toString();
        }
        return ID;
    }
}
