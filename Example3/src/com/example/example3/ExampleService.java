package com.example.example3;

import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;


public class ExampleService extends android.app.IntentService {

	public ExampleService() {
		super("Example");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		ResultReceiver receiver = intent.getExtras().getParcelable("ResultReceiver");
		Bundle result = new Bundle();
		result.putString("Result", intent.getExtras().getString("Posted"));
		receiver.send(1, result);
	}

}
