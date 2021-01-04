package com.alinadangol.pre;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Signup extends AppCompatActivity {


    /* Data from the authenticated user */
    private FirebaseAuth mAuth;
    private Button signup_btn;
    private EditText signup_email, signup_pass;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signup_btn = findViewById(R.id.signup_btn);
        signup_email = findViewById(R.id.signup_email);
        signup_pass = findViewById(R.id.signup_pass);


         firebaseAuth = FirebaseAuth.getInstance();

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email =signup_email.getText().toString().trim();
                String password =signup_pass.getText().toString().trim();


                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Signup.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }


                if(TextUtils.isEmpty(password)){
                    Toast.makeText(Signup.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }




                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {

                                    startActivity(new Intent(getApplicationContext(),menu.class));
                                    Toast.makeText(Signup.this, "Succesfully signedup.",Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(Signup.this, "Failed to sign up.",Toast.LENGTH_SHORT).show();


                                }
                            }
                        });

            }
        });
        

    }

}





