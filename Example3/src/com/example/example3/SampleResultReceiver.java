package com.example.example3;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

public class SampleResultReceiver extends ResultReceiver {

	MainActivity activity;

	public SampleResultReceiver(Handler handler) {
		super(handler);
	}
	
	@Override
	protected void onReceiveResult(int resultCode, Bundle resultData) {
		super.onReceiveResult(resultCode, resultData);
		if (activity != null) {
			activity.updateData(resultData.getString("Result"));
		}
	}

}
