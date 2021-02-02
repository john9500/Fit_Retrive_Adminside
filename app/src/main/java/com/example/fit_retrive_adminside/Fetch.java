package com.example.fit_retrive_adminside;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Fetch extends AppCompatActivity {
    private DatabaseReference retrive;
    ListView listview;
    List<John> artlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch);
        listview = (ListView) findViewById(R.id.list);
        artlist = new ArrayList<>();

        retrive = FirebaseDatabase.getInstance().getReference("Users");;
        retrive.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                artlist.clear();
                for(DataSnapshot artistshot : snapshot.getChildren())
                {
                    John joh = artistshot.getValue(John.class);
                    artlist.add(joh);
                }
                Artistret adapter = new Artistret(Fetch.this, artlist);
                listview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    }