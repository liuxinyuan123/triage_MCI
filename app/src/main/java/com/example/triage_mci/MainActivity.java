package com.example.triage_mci;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void intent_to_Triage_START(View view) {
        Intent intent = new Intent(MainActivity.this, Triage_START.class);
        startActivity(intent);
    }

    public void intent_to_Triage_SALT(View view) {
        String text = "请根据现场情况评估患者的SALT等级";
        Intent intent = new Intent(MainActivity.this, triage_salt.class);
        startActivity(intent);
    }

}