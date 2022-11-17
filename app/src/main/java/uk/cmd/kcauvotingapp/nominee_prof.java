package uk.cmd.kcauvotingapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class nominee_prof extends AppCompatActivity {

    RecyclerView recyclerView;
    List<single_view>list = new ArrayList();
    RecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nominee_prof);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String txtUsername[]= getResources().getStringArray(R.array.txtUsername);
        int profile_image[]={R.drawable.image, R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,
                R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image};

         String txtDescription = getResources().getString(R.string.txtDescription);

         for (int i=0; i<txtUsername.length;i++){
             single_view single_view = new single_view(profile_image[i],txtUsername[i],txtDescription);

             list.add(single_view);
         }
         adapter = new RecyclerViewAdapter(this,list);
         recyclerView.setAdapter(adapter);

    }

}