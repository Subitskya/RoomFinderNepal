package com.example.roomfindernepal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Page extends AppCompatActivity {

    EditText Email,Password;
    Button btnLogin,RegisterBtn;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__page);
        getSupportActionBar().setTitle("Login Form");

        Email=(EditText) findViewById(R.id.eAddress);
        Password=(EditText) findViewById(R.id.pWord);
        btnLogin=(Button)findViewById(R.id.loginBtn);
        RegisterBtn=(Button) findViewById(R.id.registerBtn);

        firebaseAuth=FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = Email.getText().toString().trim();
                String password= Password.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Login_Page.this,"Please Enter Email Adress",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(Login_Page.this,"Please Enter Password",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(password.length()<8){
                    Toast.makeText(Login_Page.this,"Password Too Short",Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login_Page.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                    Toast.makeText(Login_Page.this,"Login Successful",Toast.LENGTH_SHORT).show();


                                } else {
                                    Toast.makeText(Login_Page.this,"Login Failed or User not Available",Toast.LENGTH_SHORT).show();
                                }

                            }
                        });



            }

        });

        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignUp_Page.class));
            }
        });


    }
}
