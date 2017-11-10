package com.example.justovanderwerf.justovdwerfpset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


    }

    public void buttonSimple(View view) {

        Intent intent = new Intent(this, thirthActivity.class);
        startActivity(intent);
        finish();
    }
}