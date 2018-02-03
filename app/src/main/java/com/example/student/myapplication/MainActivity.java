package com.example.student.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.Key;

public class MainActivity extends AppCompatActivity {

    EditText login;
    EditText password;
    Button registration;
    Button ok;

    public void registration(){
        login=findViewById(R.id.login);
        password=findViewById(R.id.password);
        registration=findViewById(R.id.registration);
        ok=findViewById(R.id.ok);



        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Registration_page.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registration();
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences("login", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
             if (sharedPreferences.getString(login.getText().toString(),"Error").equals(password.getText().toString())){
                 Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                 startActivity(intent);

             }else {
                 Toast toast = Toast.makeText(getApplicationContext(),
                         "Incorrect LOGIN or PASSWORD!",
                         Toast.LENGTH_SHORT);
                 toast.setGravity(Gravity.CENTER, 0, 0);
                 toast.show();

             }
            }
        });

    }
}
