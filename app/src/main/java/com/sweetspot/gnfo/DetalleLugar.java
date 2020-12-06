package com.sweetspot.gnfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class DetalleLugar extends AppCompatActivity {

    FirebaseDatabase FBData;
    DatabaseReference DBReference,DBMostrar;
    String recibirCodigo;
    String recibirLugar;
    EditText txtNom, txtCode, txtDesc;
    String enviarLatitud;
    String enviarLongitud;
    Button bMapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_lugar);


        Intent inten = this.getIntent();
        this.recibirLugar = inten.getStringExtra("lugarcito".toString());
        this.recibirCodigo = inten.getStringExtra("code".toString());


        txtNom = (EditText) findViewById(R.id.idLugar);
        txtCode = (EditText) findViewById(R.id.idCodigo);
        txtDesc = (EditText) findViewById(R.id.idDesc);

        txtNom.setText(recibirLugar);
        txtCode.setText(recibirCodigo);

        bMapa = (Button) findViewById(R.id.btnMapa);
        bMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mostrarMapa();

            }
        });
        iniciar_firebase();
        buscarDetalle();
    }

    private void iniciar_firebase() {
        FirebaseApp.initializeApp(this);
        this.FBData = FirebaseDatabase.getInstance();
        this.DBReference = this.FBData.getReference();
    }

    public void buscarDetalle(){

        final int[] cont = {0};
        DatabaseReference bbdd = FirebaseDatabase.getInstance().getReference(recibirLugar);
        Query q=bbdd.orderByChild("code").equalTo(recibirCodigo);

        q.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {

                for(DataSnapshot datasnapshot: dataSnapshot.getChildren()){
                    cont[0]++;

                    System.out.println(dataSnapshot.getValue());

                    lugares lugaresquehablan = dataSnapshot.getValue(lugares.class);   //ERROR
                    txtDesc.setText(lugaresquehablan.getDescLugar().toString());

                    enviarLatitud = lugaresquehablan.getLatitud();
                    enviarLongitud = lugaresquehablan.getLongitud();

                    break;
                }

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
    public void mostrarMapa(){

        Intent intento = new Intent(this, mapalugar.class);

        intento.putExtra("LAT", enviarLatitud);
        intento.putExtra("LON", enviarLongitud);

        startActivity(intento);
    }

}