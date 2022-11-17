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
import com.google.firebase.database.FirebaseDatabase;

public class StdRegActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_reg);

        //Initialize firebase Auth
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            finish();
            return;
        }
        //obtain register btn from layout
        Button btnReg = findViewById(R.id.btnRegister);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();

                }


        });
        TextView txtAlready = findViewById(R.id.txtHaveAccount);
        txtAlready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToLogin();
            }
        });
    }
    private void registerUser(){
        EditText edtName = findViewById(R.id.name);
        EditText edtAdm = findViewById(R.id.admission);
        EditText edtEmail = findViewById(R.id.email);
        EditText edtPassword = findViewById(R.id.password);
        EditText edtConfirm = findViewById(R.id.confirm);

        String name = edtName.getText().toString();
        String adm = edtAdm.getText().toString();
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();
        String confirm = edtConfirm.getText().toString();

        if (name.isEmpty() || adm.isEmpty() || email.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
            Toast.makeText(this,"Please fill all Fields",Toast.LENGTH_LONG).show();
            return;

        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            user user = new user(name, email);

                            FirebaseDatabase.getInstance().getReference("users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>(){
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                        showMainActivity();
                                        }


                                    });

                        } else {

                            Toast.makeText(StdRegActivity.this, "Authentication Failed.",
                                    Toast.LENGTH_LONG).show();



                        }
                    }
                });

        }
        private void showMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
        }

    private void switchToLogin(){
        Intent intent = new Intent(this, StdLoginActivity.class);
        startActivity(intent);
        finish();
    }


}
