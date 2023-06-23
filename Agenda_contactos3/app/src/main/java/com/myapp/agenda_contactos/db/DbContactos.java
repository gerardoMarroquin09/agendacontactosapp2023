package com.myapp.agenda_contactos.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbContactos extends DdHelper{
    Context context;
    public DbContactos(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long insertarContacto(String nombre,String apellido,String edad,String domicilio,String correo_electronico,String telefono ){
        long id = 0;
        try {
            DdHelper ddHelper = new DdHelper(context);
            SQLiteDatabase db = ddHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("apellido", apellido);
            values.put("edad", edad);
            values.put("domicilio", domicilio);
            values.put("correo_electronico", correo_electronico);
            values.put("telefono", telefono);

            id = db.insert(TABLE_CONTACTOS, null, values);
        }catch(Exception ex){
            ex.toString();
        }
        return id;
    }
}
