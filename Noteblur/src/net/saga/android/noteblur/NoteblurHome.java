package net.saga.android.noteblur;

import java.net.URL;

import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class NoteblurHome extends Activity implements LoaderCallbacks<URL> {

	protected static final int RESULT_SPEECH = 1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noteblur_login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_noteblur_home, menu);
        return true;
    }
    
    public void launchLogin(View v) {
    	getLoaderManager().initLoader(0, null, this);
    }

	@Override
	public Loader<URL> onCreateLoader(int id, Bundle args) {
		return new OAuthFetcherLoader(this);
	}

	@Override
	public void onLoadFinished(Loader<URL> loader, URL data) {
		 Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(data.toString()));
		 startActivity(i);
	}

	@Override
	public void onLoaderReset(Loader<URL> loader) {
		//noop
	}
    
}
