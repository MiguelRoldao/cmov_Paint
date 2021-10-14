package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.madrapps.pikolo.ColorPicker;
import com.madrapps.pikolo.listeners.SimpleColorSelectionListener;

public class CanvasActivity extends AppCompatActivity {

	final int REQUEST_CODE = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_canvas);
		
		/*FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		
		BlankFragment fragment = new BlankFragment();
		fragmentTransaction.add(R.id.fragmentContainerView, fragment);	// change this to correct view
		fragmentTransaction.commit();
		
		 */
	}
	
	private View.OnClickListener mPaletteButtonListener = new View.OnClickListener() {
		@Override
		public void onClick(View view) {
			// open palette fragment
		}
	};
	/*
	final ColorPicker colorPicker = (ColorPicker) findViewById(R.id.colorPicker);
	colorPicker.setColo*/
}