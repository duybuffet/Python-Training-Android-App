package com.python.trainning.nextgsolutions.tapswipe;

import com.example.tapswipe.R;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class New extends Fragment implements OnClickListener {

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
		Button btn = (Button) view.findViewById(R.id.bnt_test);
		btn.setOnClickListener(this);
		view.setBackgroundResource(R.color.color1);
		return view;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(getActivity(),
				com.python.trainning.nextgsolutions.test.TestActivity.class);
		startActivity(intent);
	}
}