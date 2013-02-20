package net.saga.android.coffeeexample;

import org.jboss.aerogear.android.RecordId;

public class RegisterServlet {

	@RecordId
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
