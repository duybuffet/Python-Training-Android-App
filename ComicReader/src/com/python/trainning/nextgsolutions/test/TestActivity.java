package com.python.trainning.nextgsolutions.test;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tapswipe.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.python.trainning.nextgsolutions.utils.MyDialog;
import com.squareup.picasso.Picasso;

public class TestActivity extends Activity {
	TextView name, author, update, status, description;
	Button btn_read, btn_favorite;
	ImageView cover;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		RequestParams params = new RequestParams();
		params.put("ebook_id", "5");
		String url = "http://192.168.1.44:8000/comicreader/ebook";
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
					JSONObject obj = new JSONObject(response);
					JSONObject eObject = obj.getJSONObject("ebook");
					name = (TextView) findViewById(R.id.ebook_name);
					update = (TextView) findViewById(R.id.update);
					author = (TextView) findViewById(R.id.author);
					description = (TextView) findViewById(R.id.description);
					cover = (ImageView) findViewById(R.id.cover);
					status = (TextView) findViewById(R.id.status);
					String url = eObject.getString("cover").toString();
					Picasso.with(getApplicationContext()).load(url).into(cover);
					Log.d("Name", eObject.getString("name").toString());
					name.setText(eObject.getString("name").toString());
					description.setText(eObject.getString("description")
							.toString());
					update.setText("Update: "
							+ eObject.getString("update").toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}
}
