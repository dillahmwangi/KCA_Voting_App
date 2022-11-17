package uk.cmd.kcauvotingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class StdLoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_login);

        //Initialize firebase Auth
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            finish();
            return;
        }
        Button btnLogin = findViewById(R.id.login_btn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authenticateUser();

            }
                });
                TextView txtRegister = findViewById(R.id.back_to_reg);
                txtRegister.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switchToRegister();
                    }
                });

            }

    private void authenticateUser() {
        EditText edtEmail = findViewById(R.id.email);
        EditText edtPassword = findViewById(R.id.password);

        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();



        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            showMainActivity();

                        } else {
                            Toast.makeText(StdLoginActivity.this, "Authentication Failed.",
                                    Toast.LENGTH_LONG).show();

                        }
                    }
                });
    }
    private void showMainActivity(){
        Intent intent = new Intent(this, nominee_prof.class);
        startActivity(intent);
        finish();

    }
    private void switchToRegister(){
        Intent intent = new Intent(this, StdRegActivity.class);
        startActivity(intent);
        finish();
    }
}