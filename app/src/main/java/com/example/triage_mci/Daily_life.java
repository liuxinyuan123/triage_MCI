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

public class Daily_life extends AppCompatActivity {
    private static final int REQUEST_CALL_PHONE_PERMISSION = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_life);

        Button call = findViewById(R.id.call_dailylife);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(Daily_life.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // 如果没有获得权限，请求授权
                    ActivityCompat.requestPermissions(Daily_life.this, new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE_PERMISSION);
                } else {
                    // 如果已经获得权限，拨打电话
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:12121")); // 在这里替换为您想要拨打的电话号码
                    startActivity(callIntent);
                    Toast.makeText(Daily_life.this, "successful to call", Toast.LENGTH_SHORT).show();
                }
            }
        });





    }
}