package com.example.example3;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	SampleResultReceiver receiver = new SampleResultReceiver(new Handler());
	
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
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent = new Intent(this, ExampleService.class);
		intent.putExtra("Posted", "Menu option selected");
		intent.putExtra("ResultReceiver", this.receiver);
		startService(intent);
		return super.onOptionsItemSelected(item);
	}


	@Override
	protected void onResume() {
		super.onResume();
		receiver.activity = this;
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		receiver.activity = null;
	}
	
	public void updateData(String text) {
		Toast.makeText(this, text, Toast.LENGTH_LONG).show();
	}

}
