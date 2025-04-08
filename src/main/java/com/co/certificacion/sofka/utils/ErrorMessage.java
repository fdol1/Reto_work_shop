package com.co.certificacion.sofka.utils;

/**
 * Esta clase permite tener un mensaje de error que es usado por ExceptionsCreateToken
 */

public enum ErrorMessage {
	IMPOSIBLE_INSTANT("It is not possible to instantiate this class");
	private String message;

	ErrorMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}