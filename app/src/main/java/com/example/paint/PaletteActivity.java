package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaletteActivity extends AppCompatActivity {

    private int selectedColor = 0xFFFFFFFF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
    
        Button mButtonRed = (Button) findViewById(R.id.buttonRed);
        mButtonRed.setOnClickListener(mButtonRedListener);
    
        Button mButtonGreen = (Button) findViewById(R.id.buttonGreen);
        mButtonGreen.setOnClickListener(mButtonGreenListener);
    
        Button mButtonBlue = (Button) findViewById(R.id.buttonBlue);
        mButtonBlue.setOnClickListener(mButtonBlueListener);
    
        Button mButtonBlack = (Button) findViewById(R.id.buttonBlack);
        mButtonBlack.setOnClickListener(mButtonBlackListener);
    
        Button mButtonGrey = (Button) findViewById(R.id.buttonGrey);
        mButtonGrey.setOnClickListener(mButtonGreyListener);
    
        Button mButtonWhite = (Button) findViewById(R.id.buttonWhite);
        mButtonWhite.setOnClickListener(mButtonWhiteListener);
    
        Button mButtonMagenta = (Button) findViewById(R.id.buttonMagenta);
        mButtonMagenta.setOnClickListener(mButtonMagentaListener);
    
        Button mButtonYellow = (Button) findViewById(R.id.buttonYellow);
        mButtonYellow.setOnClickListener(mButtonYellowListener);
    
        Button mButtonCyan = (Button) findViewById(R.id.buttonCyan);
        mButtonCyan.setOnClickListener(mButtonCyanListener);
    }

    @Override
    public void finish() {
        Intent data = new Intent();
        data.putExtra("color", selectedColor);

        setResult(RESULT_OK, data);
        super.finish();
    }
    
    private View.OnClickListener mButtonRedListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            selectedColor = 0xFFFF0000;
        }
    };
    
    private View.OnClickListener mButtonGreenListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            selectedColor = 0xFF00FF00;
        }
    };
    
    private View.OnClickListener mButtonBlueListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            selectedColor = 0xFF0000FF;
        }
    };
    
    private View.OnClickListener mButtonBlackListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            selectedColor = 0xFF000000;

        }
    };
    
    private View.OnClickListener mButtonGreyListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            selectedColor = 0xFF808080;

        }
    };
    
    private View.OnClickListener mButtonWhiteListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            selectedColor = 0xFFFFFFFF;
        }
    };
    
    private View.OnClickListener mButtonMagentaListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            selectedColor = 0xFFFF00FF;

        }
    };
    
    private View.OnClickListener mButtonYellowListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            selectedColor = 0xFFFFFF00;

        }
    };
    
    private View.OnClickListener mButtonCyanListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            selectedColor = 0xFF00FFFF;

        }
    };
}