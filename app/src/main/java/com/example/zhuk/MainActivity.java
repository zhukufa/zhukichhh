package com.example.zhuk;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar ();
        assert actionBar != null;
        actionBar.hide();
    }

    public void reg(View view) {
        Intent intent;
        intent = new Intent(MainActivity.this,SignUpScreen.class);
        startActivity(intent);
    }

    public void login(View view) {
        Intent intent;
        intent = new Intent(MainActivity.this,login.class);
        startActivity(intent);
    }
}