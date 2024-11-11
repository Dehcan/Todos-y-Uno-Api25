package cl.example.proyectotodosyunoapi25;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    String email;
    String nombre;
    String direccion;
    String contra;
    String contraConfirmed;


    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseFirestore mStore = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        Button completeRegister = findViewById(R.id.registeruser);
        completeRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etRemail = findViewById(R.id.createmail);
                EditText etRnombre = findViewById(R.id.createname);
                EditText etRdireccion = findViewById(R.id.createdirection);
                EditText etRcontra = findViewById(R.id.createpass);
                EditText etConfircontra = findViewById(R.id.confirmpass);

                email = etRemail.getText().toString().trim();
                nombre = etRnombre.getText().toString().trim();
                direccion = etRdireccion.getText().toString().trim();
                contra = etRcontra.getText().toString().trim();
                contraConfirmed = etConfircontra.getText().toString().trim();

                // Verificar si las contraseñas coinciden
                if (!contra.equals(contraConfirmed)) {
                    Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    return;
                }

                registrarUsuario(email, nombre, direccion);
            }
        });
    }

    private void registrarUsuario(String email, String nombre, String direccion) {
        mAuth.createUserWithEmailAndPassword(email, contra).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    String userId = mAuth.getCurrentUser() != null ? mAuth.getCurrentUser().getUid() : null;

                    if (userId == null) {
                        Toast.makeText(getApplicationContext(), "Error al obtener el ID del usuario", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Map<String, Object> user = new HashMap<>();
                    user.put("nombre", nombre);
                    user.put("email", email);
                    user.put("direccion", direccion);
                    user.put("rol", "User");

                    mStore.collection("users").document(userId).set(user)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(),
                                                "Usuario registrado y datos guardados correctamente",
                                                Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getApplicationContext(),
                                                "Error al guardar los datos del usuario",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getApplicationContext(),
                                            "Error: " + e.getMessage(),
                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Error en el registro: " + task.getException().getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

