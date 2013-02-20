package net.saga.android.noteblur;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;

public class OAuthService extends IntentService {

	public OAuthService() {
		super("OAuthService");
	}
	
	private static final String CONSUMER_KEY = "54Z7Uu1INMfr1wuzvbgaZx4NC4odrjXowgejk5wWxsfV3FWsBS";
	private static final String CONSUMER_SECRET = "dQPv98VCI1l9ydfG5wBiWdbyuUQLTpVUxmX8tZ1x1hpCcjDBNe";
	
	private static final String TUMBLR_REQUEST_TOKEN_URL = "http://www.tumblr.com/oauth/request_token";
	private static final String TUMBLR_ACCESS_TOKEN_URL = "http://www.tumblr.com/oauth/access_token";
	private static final String TUMBLR_AUTHORIZE_URL = "https://www.tumblr.com/oauth/authorize";

	//private static final String BLOG_NAME = "percent20.tumblr.com";
	private static final String API_KEY = CONSUMER_KEY;
	private static final String TAG = OAuthService.class.getSimpleName();
	private static final String EXTRA_RESULT_RECEIVER = "net.saga.RESULT_RECEIVER";
	
	
	
	
	@Override
	protected void onHandleIntent(Intent intent) {
		Bundle extras = intent.getExtras();
	    
	    if (extras == null || !extras.containsKey(EXTRA_RESULT_RECEIVER)) {
	        // Extras contain our ResultReceiver and data is our REST action.  
	        // So, without these components we can't do anything useful.
	        Log.e(TAG, "You did not pass extras or data with the Intent.");
	        
	        return;
	    }
	    
	    ResultReceiver receiver = extras.getParcelable(EXTRA_RESULT_RECEIVER);
	    
	    
	}
	
}
