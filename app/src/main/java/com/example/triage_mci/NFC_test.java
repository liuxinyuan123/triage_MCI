package com.example.triage_mci;

import android.app.PendingIntent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class NFC_test extends AppCompatActivity {
    private NfcAdapter nfcAdapter;
    private PendingIntent pendingIntent;
    private TextView read_result;
    private TextView write_result;
    private TextView assess_report;
    private TextView reConfirm;
    private EditText name;
    private String confirmedInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfc_test);


        Button read = findViewById(R.id.read_NFC_information);
        Button write = findViewById(R.id.write_NFC_information);
        Button confirm = findViewById(R.id.confirm_infotmation);

        read_result = findViewById(R.id.read_result);
        write_result = findViewById(R.id.write_result);
        assess_report = findViewById(R.id.assess_report);
        name = findViewById(R.id.names);
        reConfirm = findViewById(R.id.re_confirm);

        // Read button click listener
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // Write button click listener
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // Confirm button click listener
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmedInfo = name.getText().toString();
                reConfirm.setText("re-confirm: " + confirmedInfo);
            }
        });

    }

}

