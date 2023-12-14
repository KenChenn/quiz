package com.example.quiz.constants;

public enum RtnCode {
	SUCCESSFUL(200, "Successful!"),//
	PARAM_ERROR(400, "Param error!"),//
	ACCOUNT_NOT_FOUND(400, "Account not found!");

	private int code;

	private String message;

	private RtnCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
