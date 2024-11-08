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

public class Menu2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.menu2);

        ImageButton botonretroceder = (ImageButton) findViewById(R.id.backbutton);
        botonretroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu2.this, Menu.class);
                startActivity(intent);
                finish();
            }
        });

        Button historialaviso = (Button) findViewById(R.id.historialapp);
        historialaviso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu2.this, HistorialAvisos.class);
                startActivity(intent);
                finish();

            }
        });

        Button ajusteapp = (Button) findViewById(R.id.ajustesapp);
        ajusteapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu2.this, AjustesApp.class);
                startActivity(intent);
                finish();

            }
        });

        Button Infolegal = (Button) findViewById(R.id.infolegalboton);
        Infolegal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu2.this, Infolegal.class);
                startActivity(intent);
                finish();

            }
        });

        Button infoapp = (Button) findViewById(R.id.infoappboton);
        infoapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu2.this, Infoapp.class);
                startActivity(intent);
                finish();

            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.menu2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
    }
}