package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CALL_LOG}, PackageManager.PERMISSION_GRANTED);
        textView = findViewById(R.id.textView);
    }

    public void buttonCallLogOutGoing(View view){
        textView.setText("Call Logging Started ... ");
        String stringOutput = "";

        Uri uriCallLogs = Uri.parse("content://call_log/calls");
        Cursor cursorCallLogs = getContentResolver().query(uriCallLogs, null,null,null);
        cursorCallLogs.moveToFirst();
        do {
            String stringNumber = cursorCallLogs.getString(cursorCallLogs.getColumnIndex(CallLog.Calls.NUMBER));
            String stringName = cursorCallLogs.getString(cursorCallLogs.getColumnIndex(CallLog.Calls.CACHED_NAME));
            String stringDuration = cursorCallLogs.getString(cursorCallLogs.getColumnIndex(CallLog.Calls.DURATION));
            String stringType = cursorCallLogs.getString(cursorCallLogs.getColumnIndex(CallLog.Calls.TYPE));

            if(stringType.endsWith("2")) {
                stringOutput = stringOutput + "Number: " + stringNumber
                        + "\nName: " + stringName
                        + "\nDuration: " + stringDuration
                        + "\n Type: " + stringType
                        + "\n\n";
            }
        }while (cursorCallLogs.moveToNext());
        textView.setText(stringOutput);
    }
    public void buttonCallLogInComing(View view){
        textView.setText("Call Logging Started ... ");
        String stringOutput = "";

        Uri uriCallLogs = Uri.parse("content://call_log/calls");
        Cursor cursorCallLogs = getContentResolver().query(uriCallLogs, null,null,null);
        cursorCallLogs.moveToFirst();
        do {
            String stringNumber = cursorCallLogs.getString(cursorCallLogs.getColumnIndex(CallLog.Calls.NUMBER));
            String stringName = cursorCallLogs.getString(cursorCallLogs.getColumnIndex(CallLog.Calls.CACHED_NAME));
            String stringDuration = cursorCallLogs.getString(cursorCallLogs.getColumnIndex(CallLog.Calls.DURATION));
            String stringType = cursorCallLogs.getString(cursorCallLogs.getColumnIndex(CallLog.Calls.TYPE));

            if(stringType.endsWith("1")) {
                stringOutput = stringOutput + "Number: " + stringNumber
                        + "\nName: " + stringName
                        + "\nDuration: " + stringDuration
                        + "\n Type: " + stringType
                        + "\n\n";
            }
        }while (cursorCallLogs.moveToNext());
        textView.setText(stringOutput);
    }
    public void buttonCallLogMissed(View view){
        textView.setText("Call Logging Started ... ");
        String stringOutput = "";

        Uri uriCallLogs = Uri.parse("content://call_log/calls");
        Cursor cursorCallLogs = getContentResolver().query(uriCallLogs, null,null,null);
        cursorCallLogs.moveToFirst();
        do {
            String stringNumber = cursorCallLogs.getString(cursorCallLogs.getColumnIndex(CallLog.Calls.NUMBER));
            String stringName = cursorCallLogs.getString(cursorCallLogs.getColumnIndex(CallLog.Calls.CACHED_NAME));
            String stringDuration = cursorCallLogs.getString(cursorCallLogs.getColumnIndex(CallLog.Calls.DURATION));
            String stringType = cursorCallLogs.getString(cursorCallLogs.getColumnIndex(CallLog.Calls.TYPE));

            if(stringType.endsWith("3")) {
                stringOutput = stringOutput + "Number: " + stringNumber
                        + "\nName: " + stringName
                        + "\nDuration: " + stringDuration
                        + "\n Type: " + stringType
                        + "\n\n";
            }
        }while (cursorCallLogs.moveToNext());
        textView.setText(stringOutput);
    }
}