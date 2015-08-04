package com.python.training.nextgsolutions.duy;

import java.util.List;

import com.example.tapswipe.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryArrayAdapter extends ArrayAdapter<String> {
	private Activity context;
	private int layoutId;
	private List<String> objects;		

	public CategoryArrayAdapter(Activity context, int layoutId, List<String> objects) {
		super(context, layoutId, objects);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.layoutId = layoutId;
		this.objects = objects;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = context.getLayoutInflater();
		convertView = inflater.inflate(layoutId, null);
		if (objects.size() > 0 && position >= 0) {
			final TextView tvCatName = (TextView)convertView.findViewById(R.id.tvCategoryName);
			final ImageView ivCatImage = (ImageView)convertView.findViewById(R.id.ivCategoryImage);
			tvCatName.setText(objects.get(position));
			ivCatImage.setImageResource(R.drawable.ic_launcher);
		}
		return convertView;
	}
	
}
