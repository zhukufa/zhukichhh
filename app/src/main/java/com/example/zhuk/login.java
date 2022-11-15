package com.example.zhuk;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private Button logbutton;
    private EditText username;
    private EditText pass;
    private TextView login_locked;
    private TextView attempts;
    private TextView numberOfAttempts;
    int numberOfRemainingLoginAttempts = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        username = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.pass);
        logbutton = (Button) findViewById(R.id.logbutton);
        login_locked = (TextView) findViewById(R.id.login_locked);
        attempts = (TextView) findViewById(R.id.number_of_attempts);
        numberOfAttempts = (TextView) findViewById(R.id.number_of_attempts);
        numberOfAttempts.setText(Integer.toString(numberOfRemainingLoginAttempts));
    }


        public void logg(View view) {
            if (username.getText().toString().equals("s") &&
                    pass.getText().toString().equals("s")) {
                Toast.makeText(getApplicationContext(), "Вход выполнен!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(login.this, MainScreen.class);
                startActivity(intent);

            }
            else {
                Toast.makeText(getApplicationContext(), "Неправильные данные!",Toast.LENGTH_SHORT).show();
                numberOfRemainingLoginAttempts--;
                attempts.setVisibility(View.VISIBLE);
                numberOfAttempts.setVisibility(View.VISIBLE);
                numberOfAttempts.setText(Integer.toString(numberOfRemainingLoginAttempts));
                if (numberOfRemainingLoginAttempts == 0) {
                    logbutton.setEnabled(false);
                    login_locked.setVisibility(View.VISIBLE);
                    login_locked.setBackgroundColor(Color.RED);
                    login_locked.setText("Вход заблокирован!!!");
                }
            }
        }
}