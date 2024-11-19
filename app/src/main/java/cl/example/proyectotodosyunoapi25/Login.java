package cl.example.proyectotodosyunoapi25;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Login extends AppCompatActivity {

    String email;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        FirebaseApp.initializeApp(this);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        if(mAuth.getCurrentUser() != null){
            // Ya iniciarion sesion
            Intent i = new Intent(Login.this, Menu.class);
            startActivity(i);
            finish();
        }

        Button aviso = (Button) findViewById(R.id.registrarme);
        aviso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
                finish();

            }
        });

    Button iniciar_sesion = findViewById(R.id.iniciarsesion);
    iniciar_sesion.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            EditText etEmail = findViewById(R.id.et_correo);
            EditText etPass = findViewById(R.id.et_contraseña);

            email = etEmail.getText().toString();
            String password = etPass.getText().toString();

            email = email.trim();
            password = password.trim();

            // Validar los datos
            if(email.equals("")){
                etEmail.setError("Campo obligatorio");
                return;
            }

            if(password.equals("")){
                etPass.setError("Campo obligatorio");
                return;
            }
            iniciarsesion(email, password);

            etEmail.setHint("Ingrese su email");
            etPass.setHint("Ingrese su contraseña");
        }
        public void iniciarsesion(String usercred, String userpass){

            mAuth.signInWithEmailAndPassword(usercred,userpass).addOnCompleteListener(task->{

                if (task.isSuccessful()) {
                    String userId = mAuth.getCurrentUser().getUid();
                    db.collection("users").document(userId).get().addOnCompleteListener(documentTask -> {
                        if (documentTask.isSuccessful()){
                            DocumentSnapshot document = documentTask.getResult();
                            if (document.exists()){
                                String rol = document.getString("rol");
                                if ("Admin".equals(rol)){
                                    startActivity(new Intent(Login.this, Menuadm.class));
                                }if ("User".equals(rol)){
                                    startActivity(new Intent(Login.this, Menu.class));
                                }
                                finish();
                            }
                        }
                    });
                }else{
                    Toast.makeText(Login.this,"Error al iniciar Sesion", Toast.LENGTH_LONG).show();
                }


            });
        }
    });


    }
}