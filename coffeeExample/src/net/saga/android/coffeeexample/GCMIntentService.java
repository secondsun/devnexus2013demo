package net.saga.android.coffeeexample;

import org.jboss.aerogear.android.Callback;
import org.jboss.aerogear.android.Pipeline;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;

import com.google.android.gcm.GCMBaseIntentService;
import com.google.android.gcm.GCMRegistrar;

public class GCMIntentService extends GCMBaseIntentService {

	public GCMIntentService() {
		super("272275396485");
	}

	@Override
	public void onCreate() {
		super.onCreate();
		
	}
	
	@Override
	protected void onError(Context arg0, String arg1) {
		Log.e("GCM", arg1);
	}

	@Override
	protected void onMessage(Context arg0, Intent arg1) {
		NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		 // Set the icon, scrolling text and timestamp
        Notification notification = new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.ic_launcher).setLargeIcon(((BitmapDrawable)getResources().getDrawable(R.drawable.ic_launcher)).getBitmap()).setContentTitle("Ohai").setContentText("Got message").getNotification();

        // Send the notification.
        nm.notify(0x093898, notification);
        Intent activty = new Intent(this, MainActivity.class);
        activty.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(activty);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void onRegistered(Context context, String regId) {
        ServerUtilities.register(context, regId);
	}

	@Override
	protected void onUnregistered(Context context, String regId) {
		if (GCMRegistrar.isRegisteredOnServer(context)) {
            ServerUtilities.unregister(context, regId);
        }
	}

}
