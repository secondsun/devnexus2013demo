package net.saga.android.coffeeexample;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.gcm.GCMRegistrar;

public class MainActivity extends Activity {

	private static final String TAG = "Main";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		new AsyncTask<Void, Void, Void>() {
		      @Override
		      protected Void doInBackground(Void... params) {
		        return null;
		      }
		    }.execute();
		setContentView(R.layout.activity_main);
		GCMRegistrar.checkDevice(this);
		GCMRegistrar.checkManifest(this);
		final String regId = GCMRegistrar.getRegistrationId(this);
		
		  GCMRegistrar.register(this, "272275396485");
		
	}

	

}
