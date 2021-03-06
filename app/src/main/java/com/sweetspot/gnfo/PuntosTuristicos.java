package com.sweetspot.gnfo;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;


public class PuntosTuristicos extends AppCompatActivity {

    ArrayList<lugares> listDatos;
    FirebaseDatabase FBData;
    DatabaseReference DBReference,DBMostrar;
    String lugar;
    RecyclerView recycler;
    String enviarCodigo;
    String enviarLugar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntos_turisticos);

        Intent inten = this.getIntent();
        this.lugar = inten.getStringExtra("lugar".toString());
        iniciar_firebase();
        llenarLista();
        recycler = (RecyclerView) findViewById(R.id.Recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

    }

    private void iniciar_firebase() {
        FirebaseApp.initializeApp(this);
        this.FBData = FirebaseDatabase.getInstance();
        this.DBReference = this.FBData.getReference();
    }

    private void llenarLista(){
        final int[] cont = {0};
        listDatos=new ArrayList<>();
        DatabaseReference bbdd = FirebaseDatabase.getInstance().getReference(lugar);

        Query q=bbdd.orderByChild("lugar");

        q.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {

               for(DataSnapshot datasnapshot: dataSnapshot.getChildren()){
                    cont[0]++;

                    System.out.println(dataSnapshot.getValue());

                   lugares lugaresquehablan = dataSnapshot.getValue(lugares.class);   //ERROR
                   listDatos.add(lugaresquehablan);
                    break;
                }
                Adapter adapter = new Adapter(listDatos);
                adapter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        enviarCodigo = listDatos.get(recycler.getChildAdapterPosition(view)).getCode();
                        enviarLugar = listDatos.get(recycler.getChildAdapterPosition(view)).getLugar();
                        mostrarDetalle();

                    }
                });
                recycler.setAdapter(adapter);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }
    public void mostrarDetalle(){
        Intent intento = new Intent(this, DetalleLugar.class);

        intento.putExtra("code", enviarCodigo);
        intento.putExtra("lugarcito", enviarLugar);

        startActivity(intento);
    }














































    }

