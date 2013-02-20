package net.saga.android.noteblur;

import java.net.URL;

import oauth.signpost.OAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class OAuthFetcherLoader extends AsyncTaskLoader<URL> {

	private static final String TAG = "OAuthFetcherLoader";
	
	public OAuthFetcherLoader(Context context) {
		super(context);
	}

	@Override
	protected void onStartLoading() {

		forceLoad();

	}

	@Override
	public URL loadInBackground() {
		
		NoteblurApplication app = (NoteblurApplication) getContext().getApplicationContext();
		OAuthConsumer consumer = app.consumer;
		OAuthProvider provider = app.provider;		
		try {
			String authUrl = provider
					.retrieveRequestToken(consumer, OAuth.OUT_OF_BAND);
			
			SharedPreferences prefs = getContext().getSharedPreferences("bob", 0);
			prefs.edit().putString("TOKEN", consumer.getToken())
						.putString("SECRET", consumer.getTokenSecret())
						.commit();
			
			
			return new URL(authUrl);
		} catch (Exception e) {
			Log.e(TAG, e.getMessage(), e);
			throw new RuntimeException(e);
		}

	}

}
