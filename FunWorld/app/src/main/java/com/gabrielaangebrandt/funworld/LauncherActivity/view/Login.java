package com.gabrielaangebrandt.funworld.LauncherActivity.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gabrielaangebrandt.funworld.ForgottenPassword.ForgottenPassword;
import com.gabrielaangebrandt.funworld.MainActivity.MainActivity;
import com.gabrielaangebrandt.funworld.R;
import com.gabrielaangebrandt.funworld.RegisterActivity;
import com.gabrielaangebrandt.funworld.data_model.Player;
import com.gabrielaangebrandt.funworld.database.DatabaseConfig;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;

public class Login extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.et_password) EditText password;
    @BindView(R.id.et_username) EditText username;
    Button btn_login2,btn_register2;
    TextView tv_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);
        ButterKnife.bind(this);

        btn_login2 = (Button) findViewById(R.id.btn_login1);
        btn_register2 = (Button) findViewById(R.id.btn_register);
        tv_pass = (TextView) findViewById(R.id.tv_forgotten_pass);
        btn_login2.setOnClickListener(this);
        btn_register2.setOnClickListener(this);
        tv_pass.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_login1:
                Realm realm = DatabaseConfig.getRealmInstance();
                Player user = realm.copyFromRealm(realm.where((Player.class)).equalTo("username", username.getText().toString()).findFirst());
                Player pass = realm.copyFromRealm(realm.where(Player.class).equalTo("password", password.getText().toString()).findFirst());
                if(user != null && pass != null) {
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    break;
                }else{
                    Toast.makeText(this, R.string.userDoesNotExists, Toast.LENGTH_LONG).show();
                }
            case R.id.btn_register:
                Intent intent1 = new Intent(this, RegisterActivity.class);
                startActivity(intent1);
                break;
            case R.id.tv_forgotten_pass:
                Intent intent2 = new Intent(this, ForgottenPassword.class);
                startActivity(intent2);
        }
    }
}
