package com.example.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //private ArrayList<Contactos> itemList = new ArrayList<Contactos>();
    private Contacto item;
    private ArrayList<Contacto> listaContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaContactos = new ArrayList<>();
        Contacto temp = new Contacto();
        temp.setNombre("Luis Morales");
        temp.setTelefono("6861167489");
        temp.setEmail("enrike.mles@hotmail.com");
        listaContactos.add(temp);
        //itemList.size();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Intent i = getIntent();
        ArrayList<Contacto> temp = (ArrayList<Contacto>) i.getSerializableExtra("listaContactos");
        if(temp != null){
            listaContactos = temp;
        }
    }

    public void toActivityAlta(View view) {
        Intent i = new Intent( this, AltasActivity.class);
        i.putExtra("listaContactos", listaContactos);
        startActivity(i);
    }

    public void toActivityBajas(View view) {
        Intent iB = new Intent( this, BajasActivity.class);
        iB.putExtra("listaContactos", listaContactos);
        startActivity(iB);
    }

    public void toActivityBuscar(View view) {
        Intent iC = new Intent( this, ConsultaActivity.class);
        iC.putExtra("listaContactos", listaContactos);
        startActivity(iC);
    }
}
