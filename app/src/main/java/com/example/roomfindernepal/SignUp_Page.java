package com.example.roomfindernepal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class
SignUp_Page extends AppCompatActivity {

    EditText fName,uName,eAddress,pword,cPword;
    RadioGroup rg;
    RadioButton Male,Female;
    Button registerBtn;
    ProgressBar pb;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up__page);

        fName=(EditText) findViewById(R.id.fullName);
        uName=(EditText) findViewById(R.id.userName);
        eAddress=(EditText) findViewById(R.id.emailAddress);
        pword=(EditText) findViewById(R.id.password);
        cPword=(EditText) findViewById(R.id.confirmPassword);
        rg=(RadioGroup) findViewById(R.id.radioGroup);
        Male=(RadioButton) findViewById(R.id.male);
        Female=(RadioButton) findViewById(R.id.female);
        registerBtn=(Button) findViewById(R.id.btnRegister);
        pb=(ProgressBar) findViewById(R.id.progreeBar);

        firebaseAuth = FirebaseAuth.getInstance();

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FullName = fName.getText().toString().trim();
                String UserName = uName.getText().toString().trim();
                String EmailAddress = eAddress.getText().toString().trim();
                String Password = pword.getText().toString().trim();
                String ConfirmPassword = cPword.getText().toString().trim();

                if (TextUtils.isEmpty(FullName)){
                    Toast.makeText(SignUp_Page.this,"Please Enter Full Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(UserName)){
                    Toast.makeText(SignUp_Page.this,"Please Enter User Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(EmailAddress)){
                    Toast.makeText(SignUp_Page.this,"Please Enter Email Address", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Password)){
                    Toast.makeText(SignUp_Page.this,"Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(ConfirmPassword)){
                    Toast.makeText(SignUp_Page.this,"Please Enter Confirm Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(Password.length()<8){
                    Toast.makeText(SignUp_Page.this,"Password Too Short",Toast.LENGTH_SHORT).show();
                    return;
                }
                pb.setVisibility(View.VISIBLE);

                if(Password.equals(ConfirmPassword)){

                    firebaseAuth.createUserWithEmailAndPassword(EmailAddress, Password)
                            .addOnCompleteListener(SignUp_Page.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    pb.setVisibility(View.GONE);

                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(getApplicationContext(),Login_Page.class));
                                        Toast.makeText(SignUp_Page.this,"Register Completed",Toast.LENGTH_SHORT).show();

                                    } else {
                                        Toast.makeText(SignUp_Page.this,"Authentication Failed",Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });

                }


            }
        });


    }
}
