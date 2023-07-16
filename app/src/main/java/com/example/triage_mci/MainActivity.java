package com.example.triage_mci;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CALL_PHONE_PERMISSION = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button NFC_test = findViewById(R.id.NFC_test);
        NFC_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = "OK ";
                Intent intent = new Intent(MainActivity.this, NFC_test.class);
                startActivity(intent);
            }
        });


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

    public void intent_to_Daily_life(View view)
    {
        Intent intent = new Intent(MainActivity.this, Daily_life.class);
        startActivity(intent);
    }

    public void intent_to_NFC_test(View view)
    {

    }




    public  void call(View view)
    {
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // 如果没有获得权限，请求授权
            ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE_PERMISSION);
        } else {
            // 如果已经获得权限，拨打电话
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:12121")); // 在这里替换为您想要拨打的电话号码
            startActivity(callIntent);
            Toast.makeText(MainActivity.this, "successful to call", Toast.LENGTH_SHORT).show();
        }

    }


}