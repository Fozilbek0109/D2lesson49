package com.example.d2lesson49;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.d2lesson49.databinding.ActivityLogInBinding;

public class ActivitySigIn extends AppCompatActivity {
private EditText elmail,username,password,retypePasword;
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sig_in);
        setUI();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = elmail.getText().toString();
                if (s.isEmpty()){
                    Toast.makeText(ActivitySigIn.this, "Email kiriting", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(ActivitySigIn.this,ActivityLogIn.class);
                    intent.putExtra("email",1);
                    startActivity(intent);
                    finish();
                }
                String s1= username.getText().toString();
                if (s1.isEmpty()){
                    Toast.makeText(ActivitySigIn.this, "User name kiriting", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent1 = new Intent(ActivitySigIn.this,ActivityLogIn.class);
                    intent1.putExtra("user",2);
                    startActivity(intent1);
                    finish();
                }
                String s2 = password.getText().toString();
                    if (s2.isEmpty()){
                        Toast.makeText(ActivitySigIn.this, "passwor kiriting", Toast.LENGTH_SHORT).show();
                    }else {
                        Intent intent2 = new Intent(ActivitySigIn.this, ActivityLogIn.class);
                        intent2.putExtra("password", 3);
                        startActivity(intent2);
                        finish();
                    }
                String s3 = retypePasword.getText().toString();
                    if (s3.isEmpty()){
                        Toast.makeText(ActivitySigIn.this, "passwor kiriting", Toast.LENGTH_SHORT).show();
                    }else {
                        Intent intent3 = new Intent(ActivitySigIn.this, ActivityLogIn.class);
                        intent3.putExtra("retypepassword", 4);
                        startActivity(intent3);
                        finish();
                    }
                if (retypePasword.getText().equals(password.getText())) {
                    retypePasword.getText().toString();
                }
                else {
                    Toast.makeText(ActivitySigIn.this, "birinchi parol\nbilan birxil emas", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    private void setUI() {
        elmail = findViewById(R.id.Email_edt);
        username = findViewById(R.id.usernamte_edt);
        password = findViewById(R.id.password_edt);
        retypePasword = findViewById(R.id.reytypePasvord);
        button = findViewById(R.id.sign_up_btn);

    }
}