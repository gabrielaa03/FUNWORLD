package com.gabrielaangebrandt.funworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.gabrielaangebrandt.funworld.R.string.error_passwordsDontMatch;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etUsername, etPassword1, etPassword2, etEmail;
    Button bRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.setUpUI();

    }

    private void setUpUI() {
        this.etName = (EditText) findViewById(R.id.etName);
        this.etUsername = (EditText) findViewById(R.id.etUsername);
        this.etPassword1 = (EditText) findViewById(R.id.etPassword1);
        this.etPassword2 = (EditText) findViewById(R.id.etPassword2);
        this.etEmail = (EditText) findViewById(R.id.etEmail);
        this.bRegister = (Button) findViewById(R.id.bRegister);
        bRegister.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        if(etPassword1.getText() == etPassword2.getText()){
            //pohrani podatke u bazu
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }else{
            etPassword2.setError(getText(R.string.error_passwordsDontMatch));
        }

    }
}
