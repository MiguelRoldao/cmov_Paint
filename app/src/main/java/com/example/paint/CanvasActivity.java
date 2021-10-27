package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.larswerkman.holocolorpicker.ColorPicker;


public class CanvasActivity extends AppCompatActivity {
	
	private boolean isPaletteOpen = false;
	private int brushColor = 0xFF000000;

	final int REQUEST_CODE = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_canvas);
		
		FloatingActionButton mPaletteButton = (FloatingActionButton) findViewById(R.id.paletteButton);
		
		Configuration conf = getResources().getConfiguration();
		if (conf.orientation == conf.ORIENTATION_PORTRAIT) {
			mPaletteButton.setOnClickListener(mButtonPaletteListener);
		}
		
		
		
	}

	
	private View.OnClickListener mButtonPaletteListener = new View.OnClickListener() {
		@Override
		public void onClick(View view) {
			// open palette fragment
			if (isPaletteOpen) {
				// get picker color
				FragmentContainerView fragmentContainerView = (FragmentContainerView) findViewById(R.id.fragmentContainerView2);
				ColorPicker picker = (ColorPicker) fragmentContainerView.findViewById(R.id.picker);
				brushColor = picker.getColor();
				
				// show original canvas fragment
				FragmentManager fragmentManager = getSupportFragmentManager();
				fragmentManager.popBackStack();
				
				// set background color
				CanvasFragment.backgroundColor = brushColor;
				
				// change floating button image
				FloatingActionButton b = (FloatingActionButton) findViewById(R.id.paletteButton);
				b.setImageResource(R.drawable.palette_icon);
				
				isPaletteOpen = false;
			} else {
				
				FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
				ColorPickerFragment colorPickerFragment = ColorPickerFragment.newInstance(brushColor);
				
				//ColorPicker colorPicker = colorPickerFragment.getView().findViewById(R.id.picker);
				//colorPicker.setOldCenterColor(brushColor);
				
				// Replace whatever is in the fragment_container view with this fragment,
				// and add the transaction to the back stack
				fragmentTransaction.replace(R.id.fragmentContainerView2, colorPickerFragment);
				fragmentTransaction.addToBackStack(null);
				// Commit the transaction
				fragmentTransaction.commit();
				
				// change floating button image
				FloatingActionButton b = (FloatingActionButton) findViewById(R.id.paletteButton);
				b.setImageResource(R.drawable.brush_icon);
				isPaletteOpen = true;
			}
			
			
		}
	};
	
}