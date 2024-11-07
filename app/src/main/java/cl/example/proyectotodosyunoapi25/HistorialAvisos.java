package cl.example.proyectotodosyunoapi25;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HistorialAvisos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.historial_avisos);

        ImageButton botonretroceder = (ImageButton) findViewById(R.id.backbutton);
        botonretroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HistorialAvisos.this, Menu2.class);
                startActivity(intent);
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.historialavisos), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView texto1 = findViewById(R.id.fecha_hist1);
        texto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent texto1 = new Intent(HistorialAvisos.this, HistorialAvisosImagen.class);
                startActivity(texto1);


            }
        });

        TextView texto2 = findViewById(R.id.fecha_hist2);
        texto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent texto2 = new Intent(HistorialAvisos.this, HistorialAvisosImagen.class);
                startActivity(texto2);


            }
        });

        TextView texto3 = findViewById(R.id.fecha_hist3);
        texto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent texto3 = new Intent(HistorialAvisos.this, HistorialAvisosImagen.class);
                startActivity(texto3);


            }
        });
    }
}