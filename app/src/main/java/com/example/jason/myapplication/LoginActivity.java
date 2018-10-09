package com.example.jason.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.text.Html.fromHtml;

public class LoginActivity extends AppCompatActivity {

//    declaration EditTexts
    EditText etEmail,etPassword;

//    declaration TextInputLayout
    TextInputLayout textInputLayoutEmail, textInputLayoutPassword;

//    declaration Button
    Button btLogin;


//    declaration SqliteHelper
    SqliteHelper sqliteHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sqliteHelper = new SqliteHelper(this);
        initCreateAccountTextView();
        initSkipLoginTextView();
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

    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

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

    private void initSkipLoginTextView() {
        TextView textViewSkipLogin = (TextView) findViewById(R.id.textViewSkipLogin);
        textViewSkipLogin.setText(fromHtml("<font color='#ffffff'>Skip login and register. </font><font color='#0c0099'>skip login</font>"));
        textViewSkipLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, HomeScreen.class);
                startActivity(intent);
            }
        });
    }

    //this method is used to connect XML views to its Objects
    private void initViews() {
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        btLogin = (Button) findViewById(R.id.btLogin);

    }

    //This method is for handling fromHtml method deprecation
    @SuppressWarnings("deprecation")
    public static Spanned fromHtml(String html) {
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
    }

    //This method is used to validate input given by user
    public boolean validate() {
        boolean valid = false;

        //Get values from EditText fields
        String Email = etEmail.getText().toString();
        String Password = etPassword.getText().toString();

        //Handling validation for Email field
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false;
            textInputLayoutEmail.setError("Please enter valid email!");
        } else {
            valid = true;
            textInputLayoutEmail.setError(null);
        }

        //Handling validation for Password field
        if (Password.isEmpty()) {
            valid = false;
            textInputLayoutPassword.setError("Please enter valid password!");
        } else {
            if (Password.length() > 5) {
                valid = true;
                textInputLayoutPassword.setError(null);
            } else {
                valid = false;
                textInputLayoutPassword.setError("Password is to short!");
            }
        }

        return valid;
    }


}
