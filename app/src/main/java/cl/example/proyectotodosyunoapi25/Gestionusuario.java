package cl.example.proyectotodosyunoapi25;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Gestionusuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.gestionusuario);

        ImageButton botonretroceder = (ImageButton) findViewById(R.id.backbutton);
        botonretroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Gestionusuario.this, Menuadm.class);
                startActivity(intent);
                finish();
            }
        });

        Button revisarreporte = (Button) findViewById(R.id.revisareporte);
        revisarreporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Gestionusuario.this, Verreport.class);
                startActivity(intent);
                finish();

            }
        });

        Button advuser = (Button) findViewById(R.id.advusuario);
        advuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Gestionusuario.this, Advertirusuario.class);
                startActivity(intent);
                finish();

            }
        });

        Button elmusuario = (Button) findViewById(R.id.elmusuario);
        elmusuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Gestionusuario.this, Eliminarusuario.class);
                startActivity(intent);
                finish();

            }
        });

        Button editaruser = (Button) findViewById(R.id.editarusuario);
        editaruser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Gestionusuario.this, Edituser.class);
                startActivity(intent);
                finish();

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.gestionusuario), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}