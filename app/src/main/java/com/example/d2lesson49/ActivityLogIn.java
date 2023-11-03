package com.example.d2lesson49;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityLogIn extends AppCompatActivity {
private EditText userName,pasvord;
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        setUI();
        String key1 = getIntent().getStringExtra("email");
        String key2 = getIntent().getStringExtra("password");
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               if (userName.getText().equals(key1) & pasvord.getText().equals(key2) ){
                   Toast.makeText(ActivityLogIn.this, "Xushkelibsiz", Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(ActivityLogIn.this ,MainActivity.class);
                   startActivity(intent);

               }
           }
       });


    }

    private void setUI() {
        userName = findViewById(R.id.username_log);
        pasvord= findViewById(R.id.password_log);
        button = findViewById(R.id.login_btn);
    }
}