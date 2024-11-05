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

public class Notificaciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.notificaciones);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.notificaciones), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button silenciar = findViewById(R.id.silenciardurante);
        silenciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent silenciar = new Intent(Notificaciones.this, Silenciar.class);
                startActivity(silenciar);

            }
        });

        Button vibracion = findViewById(R.id.vibraciones);
        vibracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent vibra = new Intent(Notificaciones.this, Vibraciones.class);
                startActivity(vibra);

            }
        });


    }
}