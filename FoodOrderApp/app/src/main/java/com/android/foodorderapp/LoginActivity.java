package com.android.foodorderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity
{


    EditText email;
    EditText password;
    Button register;
    Button login;
    String Email;
    String pwd;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Geeting the respective id's

        email = findViewById(R.id.inputUsername);
        password = findViewById(R.id.inputEmail);

    }


    public void loggingin(View v)
    {
       Email = email.getText().toString();
       pwd= password.getText().toString();

       DataBaseHelper dataBaseHelper = new DataBaseHelper(LoginActivity.this);


       int i = dataBaseHelper.Login(Email,pwd);


       if(i>0)
       {
           Intent intent = new Intent(LoginActivity.this,MainActivity.class);
           startActivity(intent);
       }
       else
       {

           Toast.makeText(LoginActivity.this, "User does not exists", Toast.LENGTH_SHORT).show();



    }







    }






    public void Signmeup(View v)
    {

        // when click the signup on login page it should redirect to the signup page

        Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
        startActivity(intent);

    }







}
