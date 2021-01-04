package com.alinadangol.pre;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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

public class Login extends AppCompatActivity {

   EditText signup_email, signup_pass;
   Button login_btn;
   private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("LOGIN FORM");

        signup_email=findViewById(R.id.login_email);
        signup_pass=findViewById(R.id.login_password);
        login_btn=findViewById(R.id.login_btn);

        firebaseAuth=FirebaseAuth.getInstance();

        login_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String email =signup_email.getText().toString().trim();
                String password =signup_pass.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Login.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }


                if(TextUtils.isEmpty(password)){
                    Toast.makeText(Login.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }


                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    startActivity(new Intent(getApplicationContext(),menu.class));
                                    Toast.makeText(Login.this, "Succesfully Login.",Toast.LENGTH_SHORT).show();


                                } else {
                                    Toast.makeText(Login.this,"Login Failed or User not Available",Toast.LENGTH_SHORT).show();

                                }

                                // ...
                            }
                        });


            }
        });
    }

    public void btn_Signup(View view) {

        startActivity(new Intent(getApplicationContext(),Signup.class));
    }
}
