package com.example.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ConsultaActivity extends AppCompatActivity {
    private ArrayList<Contacto> Contact_aux;
    private ListView lv;
    private EditText et_buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        Intent i_aux = getIntent();
        Contact_aux = (ArrayList<Contacto>) i_aux.getSerializableExtra("listaContactos");
        lv = (ListView)findViewById(R.id.lv_id);
        et_buscar = (EditText)findViewById(R.id.eT_Search);
    }

    public void toMainActivity(View view){
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra("listaContactos", Contact_aux);
        startActivity(i);
    }

    public void buscaContacto(View view){
        String st_search = et_buscar.getText().toString();

        ArrayList<String> listaString = new ArrayList<>();
        for (int i = 0; i<Contact_aux.size();i++){
            if (Contact_aux.get(i).getNombre().toUpperCase().contains(st_search.toUpperCase())) {
                listaString.add(Contact_aux.get(i).getNombre());
            }
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, listaString);
        lv.setAdapter(arrayAdapter);
    }
}
