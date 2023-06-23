package com.myapp.agenda_contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.myapp.agenda_contactos.db.DbContactos;

public class NuevoActivity extends AppCompatActivity {
    EditText txtNombre,txtApellido,txtEdad,txtdomicilio,txtcorreo,txttelefono;
    Button btnGuarda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtEdad = findViewById(R.id.txtEdad);
        txtdomicilio = findViewById(R.id.txtdomicilio);
        txtcorreo = findViewById(R.id.txtcorreo);
        txttelefono = findViewById(R.id.txttelefono);
        btnGuarda = findViewById(R.id.btnGuarda);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbContactos dbContactos = new DbContactos(NuevoActivity.this);
                long id = dbContactos.insertarContacto(txtNombre.getText().toString(),txtApellido.getText().toString(),txtEdad.getText().toString(),txtdomicilio.getText().toString(),txtcorreo.getText().toString(),txttelefono.getText().toString());
                if (id>0){
                    Toast.makeText(NuevoActivity.this,"Registro Guardado", Toast.LENGTH_LONG).show();
                    limpiar();
                } else {
                    Toast.makeText(NuevoActivity.this,"Error al guardar resgistro", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void limpiar(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        txtdomicilio.setText("");
        txtcorreo.setText("");
        txttelefono.setText("");
    }
}