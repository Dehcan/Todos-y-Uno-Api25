package cl.example.proyectotodosyunoapi25;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Botonp extends AppCompatActivity {

    FirebaseFirestore mStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.botonp);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.botonp), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button panico = findViewById(R.id.botonpanico);
        panico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                subirBoton_panico();
                Intent botonP_activado = new Intent(Botonp.this, android.R.menu.class);
                startActivity(botonP_activado);

            }
        });




    }

    private void subirBoton_panico() {

        String id = UUID.randomUUID().toString();

        Map<String, Object> boton_panico = new HashMap<>();
        boton_panico.put("id", id);

        mStore.collection("BotonPanico").document(id).set(boton_panico)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        Toast.makeText(Botonp.this,"Aviso subido exitosamente", Toast.LENGTH_LONG).show();

                    }
                })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(Botonp.this,"Aviso no se pudo subir", Toast.LENGTH_LONG).show();


                    }
                });

}}

