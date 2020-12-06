package com.sweetspot.gnfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button btnInicio;
    Spinner dropdown;

    static final String[] paths = {"Seleccione..","Coquimbo","La Serena","Ovalle"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dropdown = (Spinner) findViewById(R.id.spinner1);   //SELECT
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, paths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(this);
        btnInicio = (Button)findViewById(R.id.btnGo);
        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mostrarLugares();

            }
        });



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {    //SI SELECCIONO ESTO ALGO PASARÁ POH

        switch (position){
            case 0:

                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {  //NO CACHO, OSEA CACHO PERO NO MUCHO (MUCHOLUCHO?)(?)

    }

    public void mostrarLugares(){

        Intent intento = new Intent(this, PuntosTuristicos.class);
        startActivity(intento);
    }

}




