package com.example.jason.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button bLogin;
    EditText etName, etUsername, etPassword;
    TextView tvRegisterHere;

    UserLocalStore userLocalStore;


    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
<<<<<<< HEAD
=======
        sqliteHelper = new SqliteHelper(this);
        initCreateAccountTextView();
        initViews();

//        set click event of login button
        btLogin.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              check user input is correct or not
                if(validate()){

//                  get values from ExtitText fields
                    String Email = etEmail.getText().toString();
                    String Password = etPassword.getText().toString();

//                  Authenticate user
                    User currentUser = sqliteHelper.Authenticate(new User(null, null, Email, Password));

//                  Check if Authentication is successful or not
                    if(currentUser != null){
                        Snackbar.make(btLogin, "Sucessfully Logged in!", Snackbar.LENGTH_LONG).show();

//                      User Logged in successfully Launch home Screen activity
                      Intent intent = new Intent(LoginActivity.this, HomeScreen.class);
                      startActivity(intent);
//                      finish();
                    } else{
                        Snackbar.make(btLogin, "Failed to log in, please try again", Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        }));
>>>>>>> parent of ae5837b... Skip Login

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

<<<<<<< HEAD
    //this method used to set Create account TextView text and click event( maltipal colors
    // for TextView yet not supported in Xml so i have done it programmatically)
    private void initCreateAccountTextView() {
        TextView textViewCreateAccount = (TextView) findViewById(R.id.textViewCreateAccount);
        textViewCreateAccount.setText(fromHtml("<font color='#ffffff'>I don't have account yet. </font><font color='#0c0099'>create one</font>"));
        textViewCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
=======
>>>>>>> parent of e46a6a9... Update app/src/main/java/com/example/jason/myapplication/LoginActivity.java

<<<<<<< HEAD
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bLogin:
=======
    private void initSkipLoginTextView() {
        TextView textViewSkipLogin = (TextView) findViewById(R.id.textViewSkipLogin);
        textViewSkipLogin.setText(fromHtml("<font color='#ffffff'>I don't have account yet. </font><font color='#0c0099'>create one</font>"));
        textViewSkipLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, HomeScreen.class);
                startActivity(intent);
            }
        });
    }
>>>>>>> parent of ae5837b... Skip Login

                User user = new User(null, null);
                userLocalStore.storeUserData(user);
                userLocalStore.setUserLoggedIn(true);
                startActivity(new Intent(this, HomeScreen.class));

                break;
            case R.id.tvRegisterHere:

                startActivity(new Intent(this, RegisterActivity.class));

                break;
        }

    }
}

