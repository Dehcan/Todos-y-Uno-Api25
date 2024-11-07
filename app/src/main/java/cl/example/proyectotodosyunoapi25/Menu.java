package cl.example.proyectotodosyunoapi25;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;



public class Menu extends AppCompatActivity {

    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.menu), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton cerrar_sesion = findViewById(R.id.logoutboton);
        cerrar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Menu.this,"Sesión cerrada con exito", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Menu.this, Login.class);
                startActivity(intent);
                finish();

            }
        });

        ImageButton menu2 = (ImageButton) findViewById(R.id.menuboton);
        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Menu2.class);
                startActivity(intent);
                finish();
            }
        });

        Button aviso = (Button) findViewById(R.id.menuAviso);
        aviso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Aviso.class);
                startActivity(intent);
                finish();

            }
        });

        Button botonpanico = (Button) findViewById(R.id.botonpanico);
        botonpanico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Botonp.class);
                startActivity(intent);
                finish();

            }
        });

        Button advertencia = (Button) findViewById(R.id.botonadvertencia);
        advertencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Advertencia.class);
                startActivity(intent);
                finish();

            }
        });

        Button reportaruser = (Button) findViewById(R.id.reportar);
        botonpanico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, ReportarUsuario.class);
                startActivity(intent);
                finish();

            }
        });



    }
}