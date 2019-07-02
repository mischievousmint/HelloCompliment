package com.example.hellocompliment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText etName;
    EditText etPasswd;
    Button btnSignIn;
    String name;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etName = findViewById(R.id.etName);
        etPasswd = findViewById(R.id.etPasswd);
        btnSignIn = findViewById(R.id.btnSingIn);

        name = etName.getText().toString();
        password = etPasswd.getText().toString();

        //Pasamos el contexto
        MySharedPreferences.init(getApplicationContext());


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                MySharedPreferences.saveName(name);
                MySharedPreferences.savePassword(password);
                i.putExtra("name", etName.getText().toString());
                startActivity(i);
            }
        });

    }
}
