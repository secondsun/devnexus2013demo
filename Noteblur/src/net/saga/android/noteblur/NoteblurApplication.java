package net.saga.android.noteblur;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.basic.DefaultOAuthProvider;
import android.app.Application;

public class NoteblurApplication extends Application {


	private static final String CONSUMER_KEY = "54Z7Uu1INMfr1wuzvbgaZx4NC4odrjXowgejk5wWxsfV3FWsBS";
	private static final String CONSUMER_SECRET = "dQPv98VCI1l9ydfG5wBiWdbyuUQLTpVUxmX8tZ1x1hpCcjDBNe";

	private static final String TUMBLR_REQUEST_TOKEN_URL = "http://www.tumblr.com/oauth/request_token";
	private static final String TUMBLR_ACCESS_TOKEN_URL = "http://www.tumblr.com/oauth/access_token";
	private static final String TUMBLR_AUTHORIZE_URL = "https://www.tumblr.com/oauth/authorize";
	private static final String TAG = NoteblurApplication.class.getSimpleName();

	public OAuthConsumer consumer ;
	public OAuthProvider provider;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		this.consumer = new DefaultOAuthConsumer(CONSUMER_KEY,
				CONSUMER_SECRET);

		this.provider = new DefaultOAuthProvider(
				TUMBLR_REQUEST_TOKEN_URL, TUMBLR_ACCESS_TOKEN_URL,
				TUMBLR_AUTHORIZE_URL);

		
		
	}
	
}
