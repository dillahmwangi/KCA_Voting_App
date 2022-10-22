package uk.cmd.kcauvotingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NextActivity extends AppCompatActivity {
    Button admin,student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        admin = findViewById(R.id.admin_btn);
        student = findViewById(R.id.student_btn);



        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NextActivity.this, regActivity.class));
                finish();

            }
        });


    }
}