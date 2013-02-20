package net.saga.android.noteblur;

import java.util.ArrayList;

import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Toast;

public class NoteblurSpeech extends Activity implements LoaderCallbacks<String>{

	protected static final int RESULT_SPEECH = 1;
	private String pin;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noteblur_home);
        Uri data = getIntent().getData();
        this.pin = data.getQueryParameter("oauth_verifier");
    }

    public void launchSpeech(View v) {
    	getLoaderManager().initLoader(0, null, this);
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
 
        switch (requestCode) {
        case RESULT_SPEECH: {
            if (resultCode == RESULT_OK && null != data) {
 
                ArrayList<String> text = data
                        .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
 
                Toast.makeText(this, text.get(0), Toast.LENGTH_LONG).show();
            }
            break;
        }
 
        }
    }

	@Override
	public Loader<String> onCreateLoader(int id, Bundle args) {
		return new AccountInfoLoader(this, pin);
	}

	@Override
	public void onLoadFinished(Loader<String> loader, String data) {
		Toast.makeText(this, data, Toast.LENGTH_LONG).show();
	}

	@Override
	public void onLoaderReset(Loader<String> loader) {
//noop		
	}
    
}
