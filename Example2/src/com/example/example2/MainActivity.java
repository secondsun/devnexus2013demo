package com.example.example2;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		((MainApplication)getApplication()).crash = !((MainApplication)getApplication()).crash;
		Toast.makeText(this, "Crash is " + (((MainApplication)getApplication()).crash?"enabled." : "disabled."), Toast.LENGTH_LONG).show();
		return true;
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		final TextView textView = ((TextView)MainActivity.this.findViewById(R.id.text));
		try {
			final MainApplication app = (MainApplication) MainActivity.this.getApplication();
			
			if (app.isLoading) {
				return;
			}
			new AsyncTask<URL, Void, String>() {

				@Override
				protected String doInBackground(URL... params) {
					try {
						app.isLoading = true;
						URL devNexusURL = params[0];
						HttpURLConnection devNexusConnection = null;
						InputStream devNexusInputStream = null;
						ByteArrayOutputStream byteStream = new ByteArrayOutputStream(
								1024);
						byte[] byteArray = new byte[1024];
						int length = -1;

						devNexusConnection = (HttpURLConnection) devNexusURL
								.openConnection();
						devNexusInputStream = devNexusConnection.getInputStream();
						while ((length = devNexusInputStream.read(byteArray)) != -1) {
							byteStream.write(byteArray, 0, length);
						}

						String httpResult = new String(byteStream.toByteArray(),
								Charset.defaultCharset());
						if (((MainApplication)MainActivity.this.getApplication()).crash) {
							Thread.sleep(5000l);
						}
						app.isLoading = false;
						return httpResult;
					} catch (Exception e) {
						Log.e("EXCEPTION", e.getMessage(), e);
						throw new RuntimeException(e);
					}
					
				}
				
				@Override
				protected void onPostExecute(String result) {
					textView.setText(result);
					Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
				}
			}.execute(new URL("http://devnexus.com/s/speakers.json"));
		} catch (MalformedURLException e) {
			//squash
		}
	}

}
