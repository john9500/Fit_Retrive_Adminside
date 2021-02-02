package com.example.fit_retrive_adminside;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText user,pass;
    Button logi;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.username);
        pass = findViewById(R.id.pass);
        fAuth = FirebaseAuth.getInstance();
        logi = findViewById(R.id.loginbtn);
        logi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        String email = user.getText().toString().trim();
        String password = pass.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            user.setError("Email is Required.");
            return;
        }

        if(TextUtils.isEmpty(password)){
            pass.setError("Password is Required.");
            return;
        }

        if(password.length() < 6){
            pass.setError("Password Must be >= 6 Characters");
            return;
        }

        // authenticate the user

        fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),Fetch.class));
                }else {
                    Toast.makeText(MainActivity.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}