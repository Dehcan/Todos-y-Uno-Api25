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

public class Advertencia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.advertencia);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.advertencia), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button volver = findViewById(R.id.enviaradv);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent enviaradver = new Intent(Advertencia.this, Menu.class);
                startActivity(enviaradver);

            }
        });

    }
}