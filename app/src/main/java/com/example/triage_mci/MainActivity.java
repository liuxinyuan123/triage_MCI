package com.example.triage_mci;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.KeyEventDispatcher;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

        public void intent_to_Triage_START( View view)
        {
            Intent intent = new Intent(MainActivity.this, Triage_START.class);
            startActivity(intent);
        }

    public void intent_to_Triage_SALT( View view)
    {
        Intent intent = new Intent(MainActivity.this, triage_salt.class);
        startActivity(intent);
    }



}