package com.python.training.nextgsolutions.duy;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.tapswipe.R;
import com.example.tapswipe.R.id;
import com.example.tapswipe.R.layout;
import com.example.tapswipe.R.menu;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.squareup.picasso.Picasso;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi") public class CategoryActivity extends Activity {
	private List<String> testData;
	
	private ListView lvCategory;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category);
		
		/*init comps*/
		lvCategory = (ListView)findViewById(R.id.lvCategory);
		testData = new ArrayList<String>();		
		
		/*load data*/
		RequestParams params = new RequestParams();
		String url = "http://192.168.1.44:8000/comicreader/category";
		getData(params, url);						
	}

	public void getData(RequestParams params, String url) {
		// Make RESTful webservice call using AsyncHttpClient object
		AsyncHttpClient client = new AsyncHttpClient();
		client.get(url, params, new AsyncHttpResponseHandler() {

			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				super.onFinish();
			}

			@Override
			public void onFailure(int statusCode, Throwable error,
					String content) {
				// TODO Auto-generated method stub

				Log.d("Out put", "Fail" + statusCode);

			}

			@Override
			public void onSuccess(String response) {
				// TODO Auto-generated method stub

				try {
					// JSON Object
//					JSONObject obj = new JSONObject(response);	
//					Log.d("JSON OBJ", obj.toString());
					JSONArray arr = new JSONArray(response);						
					for (int i = 0; i < arr.length(); i++) {
					    JSONObject obj = arr.getJSONObject(i);
					    testData.add(obj.getString("name") + " (" + obj.getString("total") + ")");
					}
					
					CategoryArrayAdapter adapter = new CategoryArrayAdapter(CategoryActivity.this, R.layout.category_item_layout, testData);
					lvCategory.setAdapter(adapter);
					lvCategory.setOnItemClickListener(new OnItemClickListener() {

						@Override
						public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
								long arg3) {
							// TODO Auto-generated method stub
							Toast.makeText(CategoryActivity.this, testData.get(arg2), Toast.LENGTH_SHORT).show();
						}
					
					});
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}
}
