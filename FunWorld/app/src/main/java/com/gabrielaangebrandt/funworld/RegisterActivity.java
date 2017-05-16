package com.gabrielaangebrandt.funworld;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

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
        this.bRegister = (Button) findViewById(R.id.registerRegister);
        bRegister.setOnClickListener(this);



    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View view) {
        if(Objects.equals(etPassword1.getText().toString(), etPassword2.getText().toString())){
            //pohrani podatke u bazu
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }else{
            etPassword2.setError(getText(R.string.error_passwordsDontMatch));
        }

    }
}
