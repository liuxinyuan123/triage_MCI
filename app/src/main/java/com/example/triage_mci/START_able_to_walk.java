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

public class START_able_to_walk extends AppCompatActivity {


    private static final int REQUEST_CALL_PHONE_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_able_to_walk);

        Button call = findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(START_able_to_walk.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // 如果没有获得权限，请求授权
                    ActivityCompat.requestPermissions(START_able_to_walk.this, new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE_PERMISSION);
                } else {
                    // 如果已经获得权限，拨打电话
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:1234567890")); // 在这里替换为您想要拨打的电话号码
                    startActivity(callIntent);
                    Toast.makeText(START_able_to_walk.this, "successful to call", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // 处理权限请求的结果
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL_PHONE_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 如果授权成功，拨打电话
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:1234567890")); // 在这里替换为您想要拨打的电话号码
                startActivity(callIntent);
                Toast.makeText(START_able_to_walk.this, "successful to call", Toast.LENGTH_SHORT).show();
            } else {
                // 如果授权失败，显示一个提示信息
                Toast.makeText(START_able_to_walk.this, "无法拨打电话，因为您没有授权", Toast.LENGTH_SHORT).show();
            }
        }
    }
}