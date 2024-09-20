package com.example.pypl2;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calendar);
       
    }

    @Override
    protected void onStart() {
        super.onStart();
        String[] from = new String[]{"body","address"};
        int[] to = {android.R.id.text1,android.R.id.text2};
        Uri uriSms = Uri.parse("content://sms/inbox");
        Cursor cursor = getContentResolver().query(uriSms, null,null,null,null);
        ListView contentListView = findViewById(R.id.listView);

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2,cursor,from,to,0);
        contentListView.setAdapter(adapter);


    }

    public void getSetTv(View view) {
        EditText etTest = findViewById(R.id.etTest);
        String data = etTest.getText().toString();
        TextView tvTest = findViewById(R.id.tvTeest);
        tvTest.setText(data);
    }
}