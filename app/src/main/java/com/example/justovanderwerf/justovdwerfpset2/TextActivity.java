package com.example.justovanderwerf.justovdwerfpset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        Intent intent = getIntent();
        String finalText = intent.getStringExtra("finalText");
        TextView showText = findViewById(R.id.finalText);
        showText.setText(finalText);


    }
}
