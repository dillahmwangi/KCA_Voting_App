package uk.cmd.kcauvotingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class adminRegActivity extends AppCompatActivity {
    Button reg;
    TextView HaveAnAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_reg);

        reg = findViewById(R.id.btnRegister);
        HaveAnAccount = findViewById(R.id.txtHaveAccount);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(adminRegActivity.this, admin_login.class));
                finish();

            }
        });

        HaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(adminRegActivity.this, admin_login.class));
                finish();

            }
        });
    }
}