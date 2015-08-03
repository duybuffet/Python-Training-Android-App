package com.python.trainning.nextgsolutions.api;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.python.trainning.nextgsolutions.models.Ebook;

public class RequestAPI {
	private Ebook ebook;

	public void getData(RequestParams params, String url) {
		// Make RESTful webservice call using AsyncHttpClient object
		AsyncHttpClient client = new AsyncHttpClient();
		client.get(url, params, new AsyncHttpResponseHandler() {
			Ebook eb = new Ebook();

			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				super.onFinish();
				Log.d("Oke", eb.getCover());
				setEbook(eb);
				Log.d("Oke", ebook.getCover());

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
					String out = eObject.toString();
					eb.setId(Integer.parseInt(eObject.getString("id")
							.toString()));
					eb.setDescription(eObject.get("description").toString());
					eb.setAuthor(eObject.get("author").toString());
					eb.setName(eObject.get("name").toString());
					eb.setCover(eObject.get("cover").toString());
					eb.setUpdate("");
					displayInfor(out);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}

	public void displayInfor(String infor) {
		Log.d("Infor Data", infor);
	}

	public Ebook getEbook() {
		return ebook;
	}

	public void setEbook(Ebook ebook) {
		this.ebook = ebook;
	}

}
