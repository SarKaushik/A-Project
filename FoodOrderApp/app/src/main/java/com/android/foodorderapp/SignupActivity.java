package com.android.foodorderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class SignupActivity extends AppCompatActivity
{


    private EditText username, email, password, Confirmpwd;
    private String uname;
    private String Email;
    private String pwd;
    private String confirmpwd;

    DataBaseHelper myDB;






    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myDB = new DataBaseHelper(this);

        // Getting the respective id's
        username = findViewById(R.id.inputUsername);
        email = findViewById(R.id.inputEmail);
        password = findViewById(R.id.inputPassword);
        Confirmpwd = findViewById(R.id.inputConfirmPassword);
    }






    public void Registerme(View v)
    {

        uname  = username.getText().toString();
        Email = email.getText().toString();
        pwd = password.getText().toString();
        confirmpwd = Confirmpwd.getText().toString();

          User user;


             user = new User(-1, uname,Email,pwd);

             DataBaseHelper dataBaseHelper = new DataBaseHelper(SignupActivity.this);


             if(uname.isEmpty() || Email.isEmpty() || pwd.isEmpty() || confirmpwd.isEmpty())
             {

                 Toast.makeText(SignupActivity.this, "Please complete al the fields ", Toast.LENGTH_SHORT).show();


             }

             else
             {

                 if(pwd.equals(confirmpwd)){



                     boolean success = dataBaseHelper.addData(user);


                     if(success)
                     {
                         Toast.makeText(SignupActivity.this, "You have Successfully Registered, Please Log In", Toast.LENGTH_SHORT).show();
                     }
                     else
                     {
                         Toast.makeText(SignupActivity.this, "Something is wrong", Toast.LENGTH_SHORT).show();
                     }



                 }




             }





    }



    public void Gotologin(View v)
    {

        Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
        startActivity(intent);

    }



}
