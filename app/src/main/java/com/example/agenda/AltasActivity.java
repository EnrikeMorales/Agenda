package com.example.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class AltasActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Tel;
    private EditText Mail;
    private TextView Total;
    private ArrayList<Contacto> Contact_aux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altas);

        Intent i_aux = getIntent();
        Contact_aux = (ArrayList<Contacto>) i_aux.getSerializableExtra("listaContactos");

        Name = (EditText)findViewById(R.id.eTNombre);
        Tel = (EditText)findViewById(R.id.eTTelefono);
        Mail = (EditText)findViewById(R.id.eTEmail);
    }

    public void AgregarContacto(View view){
        Contacto temp = new Contacto();
        temp.setNombre(Name.getText().toString());
        temp.setTelefono(Tel.getText().toString());
        temp.setEmail(Mail.getText().toString());
        Contact_aux.add(temp);
        toMainActivity(view);
    }

    public void toMainActivity(View view){
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra("listaContactos", Contact_aux);
        startActivity(i);
    }
}
