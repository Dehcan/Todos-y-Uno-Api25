package cl.example.proyectotodosyunoapi25;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AjustesApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ajustes_app);

        ImageButton botonretroceder = (ImageButton) findViewById(R.id.backbutton);
        botonretroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AjustesApp.this, Menu2.class);
                startActivity(intent);
                finish();
            }
        });

        Button Fuente = (Button) findViewById(R.id.tamañodefuente);
        Fuente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AjustesApp.this,"Función actualmente en desarrollo", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AjustesApp.this, Fuente.class);
                startActivity(intent);
                finish();
            }
        });

        Button Noti = (Button) findViewById(R.id.notificacion);
        Noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AjustesApp.this, Notificaciones.class);
                startActivity(intent);
                finish();
            }
        });
    }

    }

