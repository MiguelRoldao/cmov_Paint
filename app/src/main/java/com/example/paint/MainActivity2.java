package com.example.paint;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    final int REQUEST_CODE = 0;
    public static int backgroundColor = 0xFFFFFFFF;
    private static int colorState = 0;
    private int[] backgroundColors = {
            0xFFFFFFFF,
            0xFF000000,
            0xFFFF0000,
            0xFF00FF00,
            0xFF0000FF
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button mBotaoAbout = (Button) findViewById(R.id.button_about);
        mBotaoAbout.setOnClickListener(mBotaoAboutListener);

        Button mButtonChange = (Button) findViewById(R.id.button_change);
        mButtonChange.setOnClickListener(mButtonChangeListener);

        ConstraintLayout l = findViewById(R.id.canvas_layout);
        l.setBackgroundColor(backgroundColor);
    }

    private View.OnClickListener mBotaoAboutListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(getApplicationContext(), AboutActivity.class);
            startActivity(i);
        }
    };

    private View.OnClickListener mButtonChangeListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(getApplicationContext(), PaletteActivity.class);
            startActivityForResult(i, REQUEST_CODE);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra("color")) {
                backgroundColor = data.getIntExtra("color", 0xFF0000FF);

                ConstraintLayout l = findViewById(R.id.canvas_layout);
                l.setBackgroundColor(backgroundColor);
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}