package com.example.example3;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.os.ResultReceiver;

public class SampleLoader extends AsyncTaskLoader<String> {

	private ResultReceiver receiver;

	public SampleLoader(Context context, ResultReceiver receiver) {
		super(context);
		this.receiver = receiver;
	}

	@Override
	public String loadInBackground() {
		return null;
	}
	

}
