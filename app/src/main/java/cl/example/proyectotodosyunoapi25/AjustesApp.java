package cl.example.proyectotodosyunoapi25;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AjustesApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ajustes_app);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ajustesapp), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button ajustes_fuente = findViewById(R.id.tamañodefuente);
        ajustes_fuente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent tamañofuente = new Intent(AjustesApp.this, Fuente.class);
                startActivity(tamañofuente);

            }
        });

        Button ajustes_notificacion = findViewById(R.id.notificacion);
        ajustes_notificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent notificacion = new Intent(AjustesApp.this, Notificaciones.class);
                startActivity(notificacion);

            }
        });

    }
}