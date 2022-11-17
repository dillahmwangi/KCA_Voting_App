//package uk.cmd.kcauvotingapp;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//public class std_profile extends AppCompatActivity {
//    TextView name, textEmail, admission;
//    ImageView profile;
//    private String email;
//    private FirebaseDatabase database;
//    private DatabaseReference mDatabase;
//    private static final String USER = "user";
//    private DatabaseReference userRef;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_std_profile);
//
//        Intent intent = getIntent();
//        email = intent.getStringExtra("email");
//
//        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
//        DatabaseReference userRef;
//        userRef = rootRef.child(USER);
//
//
//        name = findViewById(R.id.txtName);
//        textEmail=  findViewById(R.id.txtEmail);
//        admission = findViewById(R.id.txtAdmission);
//        profile = findViewById(R.id.image);
//
//        database = FirebaseDatabase.getInstance();
//        userRef = database.getReference(USER);
//
//        userRef.addValueEventListener(new ValueEventListener(){
//
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (dataSnapshot.getChildren());{
//
//
//                if (dataSnapshot.child("email").getValue().equals(email)) {
//                    name.setText(dataSnapshot.child("fullName").getValue(String.class));
//                    textEmail.setText(email);
//                    admission.setText(dataSnapshot.child("Admission").getValue(String.class));
//
//                }
//            }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//
//    })
//   ; }
//}