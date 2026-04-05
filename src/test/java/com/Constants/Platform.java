package com.Constants;

public enum Platform {
	FST(3),
	FRONTDESK(2);

	private int code;

	Platform(int code) {
		this.code=code;
	}
	public int getCode() {
		return code;
	}
}
