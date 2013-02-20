package net.saga.android.noteblur;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

public class AccountInfoLoader extends AsyncTaskLoader<String> {

	private static final String TAG = "AccountInfoLoader";
	
	private final String pin;

	public AccountInfoLoader(Context ctx, String pin) {
		super(ctx);
		this.pin = pin;
	}

	@Override
	protected void onStartLoading() {

		forceLoad();

	}

	@Override
	public String loadInBackground() {
		
		NoteblurApplication app = (NoteblurApplication) getContext().getApplicationContext();
		OAuthConsumer consumer = app.consumer;
		OAuthProvider provider = app.provider;
		try {
			
			provider.retrieveAccessToken(consumer, pin);

			URL url = new URL("http://api.tumblr.com/v2/user/info");
			HttpURLConnection request = (HttpURLConnection) url
					.openConnection();

			consumer.sign(request);

			InputStream stream = request.getInputStream();

			BufferedReader r = new BufferedReader(new InputStreamReader(stream));
			StringBuilder total = new StringBuilder();
			String line;
			while ((line = r.readLine()) != null) {
				total.append(line);
			}

			return total.toString();

		} catch (Exception e) {
			Log.e(TAG, e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

}
