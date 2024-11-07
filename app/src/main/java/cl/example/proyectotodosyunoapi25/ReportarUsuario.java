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

public class ReportarUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.reportar_usuario);


        ImageButton botonretroceder = (ImageButton) findViewById(R.id.backbutton);
        botonretroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReportarUsuario.this, Menu.class);
                startActivity(intent);
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.reportarusuario), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView reportuser = findViewById(R.id.repor_user1);
        reportuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent reportUser = new Intent(ReportarUsuario.this, ReportarUsuario2.class);
                startActivity(reportUser);

            }
        });

        TextView reportuser2 = findViewById(R.id.repor_user2);
        reportuser2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent reportUser2 = new Intent(ReportarUsuario.this, ReportarUsuario2.class);
                startActivity(reportUser2);

            }
        });

        TextView reportuser3 = findViewById(R.id.repor_user3);
        reportuser3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent reportUser3 = new Intent(ReportarUsuario.this, ReportarUsuario2.class);
                startActivity(reportUser3);


            }
        });
    }
}