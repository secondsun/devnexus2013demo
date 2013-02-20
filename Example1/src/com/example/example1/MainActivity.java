package com.example.example1;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
				URL devNexusURL = null;
		        HttpURLConnection devNexusConnection = null;
		        InputStream devNexusInputStream = null;
		        ByteArrayOutputStream byteStream = new ByteArrayOutputStream(1024);
		        byte[] byteArray = new byte[1024];
		        int length = -1;
		        
		        devNexusURL = new URL("http://devnexus.com/s/speakers.json");

		        devNexusConnection = (HttpURLConnection) devNexusURL.openConnection();
		        devNexusInputStream = devNexusConnection.getInputStream();
		        while((length = devNexusInputStream.read(byteArray)) != -1) {
		            byteStream.write(byteArray, 0, length);
		        }
		        
		        String httpResult = new String(byteStream.toByteArray(),Charset.defaultCharset());
		        Log.d("RESULT", httpResult);
				} catch (Exception e) {
					Log.e("EXCEPTION", e.getMessage(), e);
					throw new RuntimeException(e);
				}
			}
		}).start();
	}

}
