package com.spring.boot.development.sa.payload.response;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageResponse {
	private String message;
	private Object dto;

	public MessageResponse(String message) {
		this.message = message;
	}

	public MessageResponse(Object dto) {
		this.dto = dto;
	}

    public MessageResponse() {

    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
