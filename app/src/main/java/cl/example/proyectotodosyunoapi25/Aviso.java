package cl.example.proyectotodosyunoapi25;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Aviso extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.aviso);


        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedRadioButton = findViewById(checkedId);
                String selectedText = selectedRadioButton.getText().toString();
                Toast.makeText(Aviso.this, "Seleccionado: " + selectedText, Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton botonretroceder = (ImageButton) findViewById(R.id.backbutton);
        botonretroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Aviso.this, Menu.class);
                startActivity(intent);
                finish();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.aviso), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        Button volver = findViewById(R.id.subiraviso);
        EditText descripcion = findViewById(R.id.et_descripcion_aviso);
        RadioGroup radioGroupNiveles = findViewById(R.id.radioGroup);


// Obtén el ID del RadioButton seleccionado
        int selectedId = radioGroupNiveles.getCheckedRadioButtonId();

// Define una variable para almacenar el nivel
        int nivelSeleccionado = 0;

// Evalúa cuál botón está seleccionado
        if (selectedId == R.id.radioButton1) {

        } else if (selectedId == R.id.radioButton2) {

        } else if (selectedId == R.id.radioButton3) {

        }
        if (selectedId == -1) { // -1 significa que no se seleccionó ningún botón
            Toast.makeText(this, "Por favor, selecciona un nivel", Toast.LENGTH_SHORT).show();
            return;
        }

        if (descripcion.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Por favor, escribe un aviso", Toast.LENGTH_SHORT).show();
            return;
        }


        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String descripcion_av = descripcion.getText().toString().trim();
                guardar_aviso(descripcion_av, nivelSeleccionado);

                Intent enviaravi = new Intent(Aviso.this, Menu.class);
                startActivity(enviaravi);


            }
        });


    }
    public void guardar_aviso(String descripcion, int nivelSeleccionado){
        String userId = mAuth.getCurrentUser().getUid();

        Map<String, Object> aviso = new HashMap<>();
        aviso.put("nivel", nivelSeleccionado);
        aviso.put("descripcion", descripcion);
        aviso.put("fecha", new Timestamp(new Date()));

        db.collection("avisos")
                .add(aviso)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(this, "Aviso guardado", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Error al guardar el aviso", Toast.LENGTH_SHORT).show();
                });

    }
}
