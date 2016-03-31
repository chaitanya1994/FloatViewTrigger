package com.example.chaitanya.floatview;

import android.app.ActivityManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.start_button);
        button.setOnClickListener(this);
        intent = new Intent(this, WindowChangeDetectingService.class);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.start_button) {
            startService(intent);

        }
    }
}
