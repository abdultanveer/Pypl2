package com.example.pypl2;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;


public class CalendarActivity extends AppCompatActivity {
    Cursor cursor;
    SimpleCursorAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
       
    }

    @Override
    protected void onStart() {
        super.onStart();
        String[] from = new String[]{"body","address"};
        int[] to = {android.R.id.text1,android.R.id.text2};



        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.READ_SMS}, 100);
        } else {
            Uri uriSms = Uri.parse("content://sms/inbox");
             cursor = getContentResolver().query(uriSms, null,null,null,null);
        }




       ListView contentListView = findViewById(R.id.listView);

         adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2,cursor,from,to,0);
        contentListView.setAdapter(adapter);
       // adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(
                new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        // val token: String = task.getResult().toString()
                        String token = task.getResult().toString();
                        Log.i("TAG","token is--"+token);
                    }
                }
        );
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Uri uriSms = Uri.parse("content://sms/inbox");
                cursor = getContentResolver().query(uriSms, null,null,null,null);
                adapter.notifyDataSetChanged();
            }
        }
    }

    public void getSetTv(View view) {
        EditText etTest = findViewById(R.id.etTest);
        String data = etTest.getText().toString();
        TextView tvTest = findViewById(R.id.tvTeest);
        tvTest.setText(data);
    }
}