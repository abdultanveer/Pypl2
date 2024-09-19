package com.example.pypl2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

    public void getSetTv(View view) {
        EditText etTest = findViewById(R.id.etTest);
        String data = etTest.getText().toString();
        TextView tvTest = findViewById(R.id.tvTeest);
        tvTest.setText(data);
    }
}