package com.example.zhuk;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class SignUpScreen extends AppCompatActivity {
    private EditText email;
    private EditText username;
    private EditText phone;
    private EditText pass;
    private EditText pass1;
    private Button logbutton;
    boolean isAllFieldsChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
        email = (EditText) findViewById(R.id.email);
        username = (EditText) findViewById(R.id.username);
        phone = (EditText) findViewById(R.id.phone);
        pass = (EditText) findViewById(R.id.pass);
        pass1 = (EditText) findViewById(R.id.pass1);


        findViewById(R.id.logbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAllFieldsChecked = CheckAllFields();
                if (isAllFieldsChecked) {
                    if (email.getText().toString().equals("") || username.getText().toString().equals("") || phone.getText().toString().equals("") || pass.getText().toString().equals("") || pass1.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Поля не заполнены", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Вход выполнен!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUpScreen.this, MainScreen.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }


    private boolean CheckAllFields() {
        if (username.length() == 0) {
            username.setError("Введите имя");
            MyDialogFragment myDialogFragment = new MyDialogFragment();
            FragmentManager manager = getSupportFragmentManager();
            //myDialogFragment.show(manager, "dialog");

            FragmentTransaction transaction = manager.beginTransaction();
            myDialogFragment.show(transaction, "dialog");
            return false;
        }
        if (email.length() == 0) {
            email.setError("Введите фамилию");
            MyDialogFragment myDialogFragment = new MyDialogFragment();
            FragmentManager manager = getSupportFragmentManager();
            //myDialogFragment.show(manager, "dialog");

            FragmentTransaction transaction = manager.beginTransaction();
            myDialogFragment.show(transaction, "dialog");
            return false;
        }
        if (phone.length() == 0) {
            phone.setError("Введите E-mail");
            MyDialogFragment myDialogFragment = new MyDialogFragment();
            FragmentManager manager = getSupportFragmentManager();
            //myDialogFragment.show(manager, "dialog");

            FragmentTransaction transaction = manager.beginTransaction();
            myDialogFragment.show(transaction, "dialog");
            return false;
        }
        if (pass.length() == 0) {
            pass.setError("Пароль");
            MyDialogFragment myDialogFragment = new MyDialogFragment();
            FragmentManager manager = getSupportFragmentManager();
            //myDialogFragment.show(manager, "dialog");

            FragmentTransaction transaction = manager.beginTransaction();
            myDialogFragment.show(transaction, "dialog");
            return false;
        }
        if (pass1.length() == 0) {
            pass1.setError("Повторите пароль");
            MyDialogFragment myDialogFragment = new MyDialogFragment();
            FragmentManager manager = getSupportFragmentManager();
            //myDialogFragment.show(manager, "dialog");

            FragmentTransaction transaction = manager.beginTransaction();
            myDialogFragment.show(transaction, "dialog");
            return false;
        }
        return true;
    }
}
