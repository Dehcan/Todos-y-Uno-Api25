package cl.example.proyectotodosyunoapi25;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class Menuadm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.menuadm);

        ImageButton rAlertButton = (ImageButton) findViewById(R.id.logoutboton);
        rAlertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alerta  = new AlertDialog.Builder(Menuadm.this);
                alerta.setMessage("¿Desea salir de la aplicación?")
                        .setCancelable(false)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(Menuadm.this, Login.class);
                                Toast.makeText(Menuadm.this,"Sesión cerrada con exito", Toast.LENGTH_LONG).show();
                                startActivity(intent);
                                FirebaseAuth.getInstance().signOut();
                                finish();
                            }
                        })

                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dialogInterface.cancel();
                            }
                        });

                AlertDialog titulo = alerta.create();
                titulo.setTitle("Salida");
                titulo.show();


            }
        });


/*        ImageButton cerrar_sesion = findViewById(R.id.logoutboton);
        cerrar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Menuadm.this,"Sesión cerrada con exito", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Menuadm.this, Login.class);
                startActivity(intent);
                finish();

            }
        });*/

        ImageButton menu2 = (ImageButton) findViewById(R.id.menuboton);
        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menuadm.this, Menu2.class);
                startActivity(intent);
                finish();
            }
        });

        Button gestuser = (Button) findViewById(R.id.gestiondeusuario);
        gestuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menuadm.this, Gestionusuario.class);
                startActivity(intent);
                finish();

            }
        });

        Button gestaviso = (Button) findViewById(R.id.gestiondeaviso);
        gestaviso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menuadm.this, Gestionaviso.class);
                startActivity(intent);
                finish();

            }
        });

        Button switchuser = (Button) findViewById(R.id.switchadm);
        switchuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menuadm.this, Menu.class);
                startActivity(intent);
                finish();

            }
        });

        Button register = (Button) findViewById(R.id.registerus);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menuadm.this, Register.class);
                startActivity(intent);
                finish();

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.menuadm), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}