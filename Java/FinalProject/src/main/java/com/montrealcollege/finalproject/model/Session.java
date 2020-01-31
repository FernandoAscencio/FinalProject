package com.montrealcollege.finalproject.model;

public class Session {
	
	private int userId;
	
	private boolean logedIn;
	
	public Session() {
		this.userId = 0;
		this.logedIn = false;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isLogedIn() {
		return logedIn;
	}

	public void setLogedIn(boolean logedIn) {
		this.logedIn = logedIn;
	}
}
