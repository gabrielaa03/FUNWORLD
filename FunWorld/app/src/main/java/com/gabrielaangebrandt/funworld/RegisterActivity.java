package com.gabrielaangebrandt.funworld;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.gabrielaangebrandt.funworld.MainActivity.MainActivity;
import com.gabrielaangebrandt.funworld.data_model.Player;
import com.gabrielaangebrandt.funworld.database.DatabaseConfig;

import java.util.Objects;

import io.realm.Realm;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private static final String TAG = "sdada";
    EditText etName, etUsername, etPassword1, etPassword2, etEmail, etAnswer;
    Button bRegister;
    Spinner question;
    DbHelper dbHelper;
    String q;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        this.setUpUI();

    }

    private void setUpUI() {
        dbHelper = new DbHelper(this);
        this.etName = (EditText) findViewById(R.id.et_name);
        this.etUsername = (EditText) findViewById(R.id.et_username);
        this.etPassword1 = (EditText) findViewById(R.id.et_password1);
        this.etPassword2 = (EditText) findViewById(R.id.et_password2);
        this.etEmail = (EditText) findViewById(R.id.et_email);
        this.etAnswer = (EditText) findViewById(R.id.et_answer);
        this.bRegister = (Button) findViewById(R.id.btn_register_player);
        this.question = (Spinner) findViewById(R.id.spinner_choose_question);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.questions, android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        question.setAdapter(adapter);
        question.setOnItemSelectedListener(this);
        bRegister.setOnClickListener(this);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View view) {

        if(etName.getText().toString() == "" || etName.getText().toString().isEmpty() ||
           etUsername.getText().toString() == ""  || etUsername.getText().toString().isEmpty() ||
           etPassword1.getText().toString() == "" || etPassword1.getText().toString().isEmpty()  ||
           etPassword2.getText().toString() == "" || etPassword2.getText().toString().isEmpty()  ||
           etEmail.getText().toString() == "" || etEmail.getText().toString().isEmpty() ||
           etAnswer.getText().toString() == "" || etAnswer.getText().toString().isEmpty()){
            Toast.makeText(this, getText(R.string.elementsArentEntered), Toast.LENGTH_LONG).show();
        }
        else {
              if (Objects.equals(etPassword1.getText().toString(), etPassword2.getText().toString())) {

                  String name, username, pass, email, answer;
                  name = etName.getText().toString();
                  username=etUsername.getText().toString();
                  pass=etPassword1.getText().toString();
                  email=etEmail.getText().toString();
                  answer=etAnswer.getText().toString();
                  Player player = new Player(name, username, pass, email, q, answer);
             //     dbHelper.insertData(player);

                  Realm object = DatabaseConfig.getRealmInstance();
                  object.beginTransaction();
                  object.copyToRealmOrUpdate(player);
                  object.commitTransaction();


                  Intent intent = new Intent(this, MainActivity.class);
                  Log.d(TAG, "ovo je"  + name + username);
                  startActivity(intent);

            } else {
                etPassword2.setError(getText(R.string.error_passwordsDontMatch));
            }
        }

    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        q = question.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(this, getText(R.string.elementsArentEntered), Toast.LENGTH_LONG).show();
    }
}
