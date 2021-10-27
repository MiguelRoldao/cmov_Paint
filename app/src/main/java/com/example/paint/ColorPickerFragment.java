package com.example.paint;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.larswerkman.holocolorpicker.*;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ColorPickerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ColorPickerFragment extends Fragment {
	
	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

	private static final String ARG_COLOR = "param1";
	
	private View view;
	
	// TODO: Rename and change types of parameters
	private int oldColor;
	
	public ColorPickerFragment() {
		// Required empty public constructor
	}
	
	/**
	 * Use this factory method to create a new instance of
	 * this fragment using the provided parameters.
	 *
	 * @param param1 Parameter 1.
	 * @return A new instance of fragment ColorPickerFragment.
	 */
	// TODO: Rename and change types and number of parameters
	public static ColorPickerFragment newInstance(int param1) {
		ColorPickerFragment fragment = new ColorPickerFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_COLOR, param1);
		fragment.setArguments(args);
		return fragment;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			oldColor = getArguments().getInt(ARG_COLOR);
		}
		

	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		view = inflater.inflate(R.layout.fragment_color_picker, container, false);
		
		ColorPicker picker = view.findViewById(R.id.picker);
		SaturationBar saturationBar = view.findViewById(R.id.saturationbar);
		ValueBar valueBar = view.findViewById(R.id.valuebar);
		
		picker.addSaturationBar(saturationBar);
		picker.addValueBar(valueBar);
		
		picker.setOldCenterColor(oldColor);
		
		Configuration conf = getActivity().getResources().getConfiguration();
		if (conf.orientation == conf.ORIENTATION_LANDSCAPE) {
			ConstraintLayout pickerLayout = view.findViewById(R.id.pickerLayout);
			pickerLayout.setScaleX(0.7f);
			pickerLayout.setScaleY(0.7f);
		}

		
		return view;
	}
}