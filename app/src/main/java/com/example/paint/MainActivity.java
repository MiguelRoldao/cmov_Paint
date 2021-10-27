package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mBotao = (Button) findViewById(R.id.button_start);
        mBotao.setOnClickListener(mBotaoListener);
    }

    private View.OnClickListener mBotaoListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(getApplicationContext(), CanvasActivity.class);
            //Intent i = new Intent(getApplicationContext(), MainActivity2.class);
            startActivity(i);
        }
    };
}