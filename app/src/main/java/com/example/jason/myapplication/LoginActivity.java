package com.example.jason.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    Button bLogin;
    EditText etName, etUsername, etPassword;
    TextView tvRegisterHere;

    UserLocalStore userLocalStore;


    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etName = (EditText) findViewById(R.id.etName);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin = (Button) findViewById(R.id.bLogin);
        tvRegisterHere = (TextView) findViewById(R.id.tvRegisterHere);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        bLogin.setOnClickListener(this);
        tvRegisterHere.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bLogin:

                User user = new User(null,null);
                userLocalStore.storeUserData(user);
                userLocalStore.setUserLoggedIn(true);
                startActivity(new Intent(this, HomeScreen.class));

            break;
            case R.id.tvRegisterHere:

                startActivity(new Intent(this, RegistgerActivity.class));

            break;
        }

    }








    }

