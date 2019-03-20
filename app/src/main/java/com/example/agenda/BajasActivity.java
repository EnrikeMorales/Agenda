package com.example.agenda;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BajasActivity extends AppCompatActivity {
    private ArrayList<Contacto> Contact_aux;
    private ListView lv;
    private View currentView;
    private int deleteIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bajas);
        Intent i_aux = getIntent();
        Contact_aux = (ArrayList<Contacto>) i_aux.getSerializableExtra("listaContactos");
        lv = (ListView)findViewById(R.id.lv_id);

        final ArrayList<String> listaString = new ArrayList<>();
        for (int i = 0; i<Contact_aux.size();i++){
            listaString.add(Contact_aux.get(i).getNombre());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, listaString);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               currentView = view;
               deleteIndex = position;
               borrarContacto();
            }
        });
    }

private void borrarContacto(){
    AlertDialog.Builder builder = new AlertDialog.Builder(BajasActivity.this);
    builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            Contact_aux.remove(deleteIndex);
            Toast.makeText(BajasActivity.this, "Borrado con éxito!", Toast.LENGTH_SHORT).show();
            toMainActivity(currentView);
        }
    });
    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
        }
    });
    builder.setMessage("Estás seguro que quieres borrar?")
            .setTitle("Confirmar");

    AlertDialog dialog = builder.create();
    dialog.show();
}

    public void toMainActivity(View view){
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra("listaContactos", Contact_aux);
        startActivity(i);
    }
}
