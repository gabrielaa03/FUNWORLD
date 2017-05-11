package com.gabrielaangebrandt.funworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button bLogin, bRegister;
    EditText password, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.setUpIU();
    }

    private void setUpIU() {
        this.bLogin = (Button) findViewById(R.id.bLogin);
        this.bRegister = (Button) findViewById(R.id.bRegister);
        this.username = (EditText) findViewById(R.id.username);
        this.password = (EditText) findViewById(R.id.password);

        this.bLogin.setOnClickListener(this);
        this.bRegister.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch(view.getId()) {
            case R.id.bLogin:
                //if statement for username and password
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.bRegister:
                intent = new Intent (this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
