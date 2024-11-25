package cl.example.proyectotodosyunoapi25;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class HistorialAvisos extends AppCompatActivity {

    private FirebaseFirestore db;
    private List<Avisos> avisosList;
    private AvisoAdapter avisoAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historial_avisos);

        // Inicializar RecyclerView
        recyclerView = findViewById(R.id.recyclerAvisos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        avisosList = new ArrayList<Avisos>();
        avisoAdapter = new AvisoAdapter(avisosList);
        recyclerView.setAdapter(avisoAdapter);

        // Configurar botón para retroceder
        ImageButton botonretroceder = findViewById(R.id.backbutton);
        botonretroceder.setOnClickListener(view -> {
            Intent intent = new Intent(HistorialAvisos.this, Menu2.class);
            startActivity(intent);
            finish();
        });




            cargarAvisos();
        }


    private void cargarAvisos() {
        db = FirebaseFirestore.getInstance();
        db.collection("avisos")
                .orderBy("fecha", Query.Direction.DESCENDING)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        avisosList.clear();
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            String fecha;
                            if (document.get("fecha") instanceof com.google.firebase.Timestamp) {
                                fecha = document.getTimestamp("fecha").toDate().toString();
                            } else {
                                fecha = document.getString("fecha"); // Si es texto
                            }
                            String descripcion = document.getString("descripcion");
                            int nivel = document.getLong("nivel") != null ? document.getLong("nivel").intValue() : 0;
                            avisosList.add(new Avisos(fecha, descripcion, nivel));
                        }
                        avisoAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(this, "Error al cargar los avisos", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
