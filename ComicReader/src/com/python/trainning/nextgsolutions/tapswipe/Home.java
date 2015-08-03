package com.python.trainning.nextgsolutions.tapswipe;

import com.example.tapswipe.R;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Home extends Fragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.swipe_tab, null);
		TextView tv = (TextView) view.findViewById(R.id.textView);
		view.setBackgroundResource(R.color.color2);
		return view;
	}
}